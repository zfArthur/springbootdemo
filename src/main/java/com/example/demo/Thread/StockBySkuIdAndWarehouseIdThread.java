package com.example.demo.Thread;

import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.dubbo.common.json.JSONObject;
import com.example.demo.CompletableFutureTest.JacksonUtil;
import com.example.demo.HttpclientUtils.HttpclientUtils;

import java.util.Map;
import java.util.concurrent.Callable;

public class StockBySkuIdAndWarehouseIdThread implements Callable<JSONArray> {

    private Map<String,Object > params;

    public StockBySkuIdAndWarehouseIdThread(Map<String,Object > params){
        this.params = params;
    }

    @Override
    public JSONArray call() throws Exception {
//        String resp = HttpclientUtils.postJsonWithTimeOut("http://192.168.248.141:888/query/all/ssuList", JacksonUtil.obj2Str(this.params), 2000);
//        JSONObject response = JSONObject.parseObject(resp);
//        return response.getJSONObject("data").getJSONArray("priceList");
        return null;
    }
}
