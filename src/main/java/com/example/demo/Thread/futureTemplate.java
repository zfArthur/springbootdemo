package com.example.demo.Thread;

//import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author zhangfu
 * @Date 2020-10-15 17:00
 */
public class futureTemplate {

//    public static void main(String args[]){
//        List<Future<JSONArray>> resultList = new ArrayList<Future<JSONArray>>();
//        List<Integer> ssuids = new ArrayList<>();
//
//        ssuids.add(2136);
//        ssuids.add(139634);
//        ssuids.add(139694);
//        ssuids.add(139694);
//
//        Map<String,Object > params = new HashMap<>();
//        params.put("cityId","1");
//        params.put("areaId","4327");
//        params.put("companyId","9951931");
//        params.put("channel","2");
//        params.put("sourceType",1001);
//        ExecutorPoolFactory executorPoolFactory=new ExecutorPoolFactory();
//        List<List<Integer>> ssuIdList = splitByPage(ssuids,2);
//        for (List<Integer> ssuId:ssuIdList) {
//            params.put("ssuIds",ssuId);
//            ThreadPoolExecutor threadPoolExecutor = executorPoolFactory.getExecutor(ExecuteTypeEnum.SKU_SSU_NUM);
//            Future<JSONArray> future = threadPoolExecutor.submit(new StockBySkuIdAndWarehouseIdThread(params));
//            resultList.add(future);
//        }
//        JSONArray resJsonArray = new JSONArray();
//        for (Future<JSONArray> future : resultList) {
//            try {
//                resJsonArray.addAll(future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
//        //总的结果集
//        System.out.println(resJsonArray);
//
//    }
//
//
//    public static <T> List<List<T>> splitByPage(List<T> list, int pageNumber) {
//        if (list == null) {
//            return null;
//        }
//        int pageCounter = list.size() / pageNumber + (list.size() % pageNumber > 0 ? 1 : 0);
//        return Stream.iterate(0, n -> n + 1).limit(pageCounter).map(p ->
//                list.stream().skip(p * pageNumber).limit(pageNumber).collect(Collectors.toList())
//        ).collect(Collectors.toList());
//    }

}
