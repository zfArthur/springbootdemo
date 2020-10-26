package com.example.demo.Thread;

import lombok.Data;

@Data
public class QueryStockReqDto {

    private Integer skuId;

    private Integer warehouseId;

    private Integer ownerId;
}
