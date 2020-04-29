package com.seller.helper.sellerhelper.controller.rest;

import com.seller.helper.sellerhelper.dto.KeywordSearchDTO;
import com.seller.helper.sellerhelper.dto.SearchResultDTO;
import com.seller.helper.sellerhelper.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mvp")
public class IndexRestController {
    private final SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<SearchResultDTO> search(KeywordSearchDTO searchDTO) {
        // 검색 건수 조회
        SearchResultDTO searchResultDTO = searchService.getSearchDTO(searchDTO);
        return ResponseEntity.ok(searchResultDTO);
    }
}
