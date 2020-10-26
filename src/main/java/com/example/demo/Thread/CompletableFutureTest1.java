package com.example.demo.Thread;

import com.example.demo.CompletableFutureTest.JacksonUtil;
import com.example.demo.HttpclientUtils.HttpclientUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Author zhangfu
 * @Date 2020-10-08 16:18
 */
@Slf4j
public class CompletableFutureTest1 {

    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newFixedThreadPool(4);

        long start = System.currentTimeMillis();
        //并发取商品信息
        CompletableFuture<String> getSsuInfo = CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest1 t1 = new CompletableFutureTest1();
            return  t1.getSsuInfoByIds();
        }, executorService);
        //获取价格信息
        CompletableFuture<String> getSsuPric = CompletableFuture.supplyAsync(() -> {
            CompletableFutureTest1 t1 = new CompletableFutureTest1();

             return  t1.getSsuPrice();
        }, executorService);
        //获取库存信息
        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + RandomUtils.nextInt(1,1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "库存信息: ";
        }, executorService);
        //获取订单信息
        CompletableFuture<String> futureD = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + RandomUtils.nextInt(1,1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "订单信息: ";
        }, executorService);

        CompletableFuture[] task = new CompletableFuture[] {getSsuInfo, getSsuPric,futureC,futureD};

        CompletableFuture<Void> all = CompletableFuture.allOf(task);

        List<CompletableFuture> taskList = Arrays.asList(task);

        CompletableFuture<List<Object>> thenApply = all.thenApply(value -> {
            return taskList.stream().map(t -> t.join()).collect(Collectors.toList());
        });
        thenApply.get().forEach(e -> {
            System.out.println(e);
        });
        System.out.println("总耗时:" + (System.currentTimeMillis() - start));
        executorService.shutdown();
    }

    public String getSsuInfoByIds(){
        String resp ="";
        try {
            List<Integer> ssuids = new ArrayList<>();
            ssuids.add(2136);
            ssuids.add(139634);
            ssuids.add(139694);
            Map<String,Object > params = new HashMap<>();
            params.put("cityId","1");
            params.put("areaId","4327");
            params.put("companyId","9951931");
            params.put("channel","2");
            params.put("suIds",ssuids);
            resp = HttpclientUtils.postJsonWithTimeOut("http://192.168.250.76:9004/api/su/getSuSkuByBatchSaleSuIds", JacksonUtil.obj2Str(params), 2000);
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public String getSsuPrice(){
        String resp ="";

        try {
            List<Integer> ssuids = new ArrayList<>();
            ssuids.add(2136);
            ssuids.add(139634);
            ssuids.add(139694);
            Map<String,Object > params = new HashMap<>();
            params.put("cityId","1");
            params.put("areaId","4327");
            params.put("companyId","9951931");
            params.put("channel","2");
            params.put("sourceType",1001);
            params.put("ssuIds",ssuids);
            resp = HttpclientUtils.postJsonWithTimeOut("http://192.168.248.141:888/query/all/ssuList", JacksonUtil.obj2Str(params), 2000);
        } catch ( IOException e) {
            e.printStackTrace();
//            log.error("getSsuPrice  completableFuture fail" + e);
        }
        return resp;
    }
}
