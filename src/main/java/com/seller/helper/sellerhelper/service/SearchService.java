package com.seller.helper.sellerhelper.service;

import com.seller.helper.sellerhelper.dto.KeywordSearchDTO;
import com.seller.helper.sellerhelper.dto.SearchResultDTO;

public interface SearchService {
    SearchResultDTO getSearchDTO(KeywordSearchDTO searchDTO);
}
