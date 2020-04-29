package com.seller.helper.sellerhelper.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BaseEntity {
    private LocalDateTime createDateTime;
    private String creatorId;
    private String creatorIp;
    private LocalDateTime editDateTime;
    private String editorId;
    private String editorIp;
}
