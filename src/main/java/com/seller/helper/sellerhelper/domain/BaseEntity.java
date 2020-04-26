package com.seller.helper.sellerhelper.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BaseEntity {
    @Column
    private LocalDateTime createDateTime;
    @Column
    private String creatorId;
    @Column
    private String creatorIp;
    @Column
    private LocalDateTime editDateTime;
    @Column
    private String editorId;
    @Column
    private String editorIp;
}
