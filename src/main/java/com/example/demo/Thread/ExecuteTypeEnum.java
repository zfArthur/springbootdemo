package com.example.demo.Thread;

public enum ExecuteTypeEnum {

    /**
     *一二级售卖分类
     */
    SALE_CLASS_ENUM("1", 10, 20,200000),
    /**
     * 获取库存
     */
    SKU_SSU_NUM("2",4,8,100000);

    ExecuteTypeEnum(String type, int coreThreadNumber, int maxThreadNumber, int capacity) {
        this.type = type;
        this.coreThreadNumber = coreThreadNumber;
        this.maxThreadNumber = maxThreadNumber;
        this.capacity = capacity;
    }
    private String type;
    private int coreThreadNumber;
    private int maxThreadNumber;
    private int capacity;

    public String getType() {
        return type;
    }
    public int getCoreThreadNumber() {
        return coreThreadNumber;
    }
    public int getMaxThreadNumber() {
        return maxThreadNumber;
    }
    public int getCapacity() {
        return capacity;
    }
}
