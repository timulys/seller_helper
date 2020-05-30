package com.seller.helper.sellerhelper.service;

import com.seller.helper.sellerhelper.dto.KeywordSearchDTO;
import com.seller.helper.sellerhelper.dto.SearchResultDTO;
import com.seller.helper.sellerhelper.utils.Signatures;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class SearchServiceImpl implements SearchService {
    //
    private static final String BASE_URL = "https://api.naver.com";
    private static final String SHOP_URL = "https://search.shopping.naver.com/search/all?";

    @Override
    public SearchResultDTO getSearchDTO(KeywordSearchDTO searchDTO) {
        SearchResultDTO searchResultDTO = getSearchCnt(searchDTO);

        searchResultDTO.setKeyword(searchDTO.getKeyword());

        // result VO
        searchResultDTO.setShopCnt(getShopCnt(searchDTO.getKeyword()));
        double rate = ((double) (searchResultDTO.getShopCnt())) / ((double) searchResultDTO.getSearchCnt());
        searchResultDTO.setRate(Math.round(rate * 100) / 100.0);

        return searchResultDTO;
    }

    /**
     *  private methods
     */
    private SearchResultDTO getSearchCnt(KeywordSearchDTO searchDTO) {
        SearchResultDTO searchResultDTO = new SearchResultDTO();

        try {
            String parameter = URLEncoder.encode("hintKeywords=" + searchDTO.getKeyword() + "&showDetail=1&includeHintKeywords=0", "UTF-8");
            String sTime = String.valueOf(System.currentTimeMillis());
            String path = "/keywordstool";
            String signature = Signatures.of(sTime, "GET", path, searchDTO.getSecretKey());

            URL url = new URL(BASE_URL + path + "?" + parameter);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Timestamp", sTime);
            con.setRequestProperty("X-API-KEY", searchDTO.getAccLicense());
            con.setRequestProperty("X-Customer", searchDTO.getCustomerId());
            con.setRequestProperty("X-Signature", signature);

            int responseCode = con.getResponseCode();

            BufferedReader br;
            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
            }
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                if (!inputLine.contains("BAD")) {
                    JSONObject object = new JSONObject(inputLine);

                    String pc = object.getJSONArray("keywordList").getJSONObject(0).get("monthlyPcQcCnt").toString();
                    String mobile = object.getJSONArray("keywordList").getJSONObject(0).get("monthlyMobileQcCnt").toString();

                    int pcCnt = 10;
                    int mobileCnt = 10;
                    if (!pc.contains("<")) {
                        pcCnt = Integer.parseInt(object.getJSONArray("keywordList").getJSONObject(0).get("monthlyPcQcCnt").toString());
                    }
                    if (!mobile.contains("<")) {
                        mobileCnt = Integer.parseInt(object.getJSONArray("keywordList").getJSONObject(0).get("monthlyMobileQcCnt").toString());
                    }

                    double pcClick = Double.parseDouble(object.getJSONArray("keywordList").getJSONObject(0).get("monthlyAvePcClkCnt").toString());
                    double moClick = Double.parseDouble(object.getJSONArray("keywordList").getJSONObject(0).get("monthlyAveMobileClkCnt").toString());
                    double monthlyPcCtr = Double.parseDouble(object.getJSONArray("keywordList").getJSONObject(0).get("monthlyAvePcCtr").toString());
                    double monthlyMoCtr = Double.parseDouble(object.getJSONArray("keywordList").getJSONObject(0).get("monthlyAveMobileCtr").toString());
                    int adCount = Integer.parseInt(object.getJSONArray("keywordList").getJSONObject(0).get("plAvgDepth").toString());
                    String compIdx = object.getJSONArray("keywordList").getJSONObject(0).get("compIdx").toString();

                    searchResultDTO.setSearchCnt(pcCnt + mobileCnt);
                    searchResultDTO.setClickCnt(pcClick + moClick);
                    searchResultDTO.setClickRate(monthlyPcCtr + monthlyMoCtr);
                    searchResultDTO.setAdCount(adCount);
                    searchResultDTO.setCompIdx(compIdx);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchResultDTO;
    }

    private int getShopCnt(String keyword) {
        try {
            Document doc = Jsoup.connect(String.format(SHOP_URL + "where=all&frm=NVSHATC&query=" + keyword, "UTF-8"))
                    .header("Accept-Language", "ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4")
                    .timeout(999999)
                    .get();
            if (doc.body().getElementsByClass("subFilter_num__2x0jq").size() > 0) {
                String shopCnt = doc.body().getElementsByClass("subFilter_num__2x0jq").get(0).text().replaceAll("전체", ""); // shop cnt
                return Integer.parseInt(shopCnt.replaceAll(",", ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
