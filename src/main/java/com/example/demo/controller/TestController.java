package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.fastjson.Group;
import com.example.demo.fastjson.User;
import com.example.demo.mapper.CharTestMapper;
import com.example.demo.model.CharTestEntity;
import com.example.demo.dto.TestReqDto;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/test")
@RestController
@Slf4j
public class TestController {


    @RequestMapping("/ceshi")
    public List<User> equals(@RequestBody TestReqDto testReqDto) {
        Group group = new Group();
        group.setId(11L);
        group.setName("zf");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);
        //对象转化成json格式字符串
        String jsonString=  JSON.toJSONString(group);
        log.info(jsonString);
        //json格式字符串转化为对象
//        Group group1 = JSON.parseObject(jsonString,Group.class);

        // json格式字符串转化为对象list
        JSONObject jsonStringtest = JSON.parseObject(jsonString);
        //jsonStringtest不能为null
        List<User> usertest11 = JSONArray.parseArray(jsonStringtest.get("users").toString(),User.class);
        return usertest11;
        /*
        入参: null 和 空字符串 时
        JSON.parseObject(null)
        出参: null
        注意null的处理
        */
//        JSONObject fieldsJson = JSON.parseObject("");
//                log.info(new Gson().toJson(fieldsJson));
//        log.info(new Gson().toJson(fieldsJson));


        //JSONObject对象测试
        //json字符串转化为 JSONObject
//        String jsonString111 =  "{\"name3\":\"张三3\",\"name2\":\"张三2\",\"name1\":\"张三1\"}";
//        JSONObject jsonObjecttest11 = JSON.parseObject(jsonString111);
                /*
        入参: null 和 空字符串 时
        JSON.parseObject(null)
        出参: null
        注意null的处理
        */

//        JSONObject object1 = new JSONObject();
        //1.在JSONObject对象中放入键值对
//        object1.put("name1","张三1");
//        object1.put("name2","张三2");
//        object1.put("name3","张三3");
        //2.根据key获取value
//        String name = (String) object1.get("name1");
        //3.获取JSONObject中的键值对个数
//        int size = object1.size();
        //4.判断是否为空
//        boolean result = object1.isEmpty();
        //5. 如果object1不进行赋值，则是一个空对象 {}

        // 5.是否包含对应的key值，包含返回true，不包含返回false
//        boolean isContainsKeyResult = object1.containsKey("name");
        //6.是否包含对应的value值，包含返回true，不包含返回false
//        boolean isContainsValueResult = object1.containsValue("王五");
//        System.out.println(isContainsValueResult);

        //7.JSONObjct对象中的value是一个JSONObject对象，即根据key获取对应的JSONObject对象；
//        JSONObject object2 = new JSONObject();
        //将jsonobject对象作为value进行设置
//        object2.put("student1", object1);
//        JSONObject student =object2.getJSONObject("student1");

        //8.如果JSONObject对象中的value是一个JSONObject数组，既根据key获取对应的JSONObject数组；
//        JSONObject objectArrayTest = new JSONObject();
        //创建JSONArray数组
//        JSONArray jsonArray = new JSONArray();
        //在JSONArray数组设值:jsonArray.add(int index, Object value);
//        jsonArray.add(0, "this is a jsonArray value");
//        jsonArray.add(1, "another jsonArray value");
//        objectArrayTest.put("testArray", jsonArray);
        //获取JSONObject对象中的JSONArray数组
//        JSONArray jsonArray2 = objectArrayTest.getJSONArray("testArray");

        //9.remove.根据key移除JSONObject对象中的某个键值对
//        object1.remove("name1");

        //10.取得JSONObject对象中key的集合
//        Set<String> keySet= object1.keySet();
//        for (String key : keySet) {
//            log.info(new Gson().toJson(key));
//        }

        //11.取得JSONObject对象中的键和值的映射关系
//        Set<Map.Entry<String, Object>> entrySet = object1.entrySet();
//        for (Map.Entry<String, Object> entry : entrySet) {
//            log.info(new Gson().toJson(entry));
//        }
        //12.转换为json字符串
//        String str1 = object1.toJSONString();
//        log.info(str1);
//        String str2 =object1.toString();
//        log.info(str2);
//        log.info(new Gson().toJson(str2));

        //getIntValue
//        JSONObject jsonObjecttest22 = JSON.parseObject("{\"name3\":\"张三3\",\"name2\":\"张三2\",\"name1\":\"张三1\"}");
//        return jsonObjecttest22.getJSONObject("name3").getIntValue("code")!=0;
        //
//        JSONObject jsonObjecttest22 = JSON.parseObject("{\"name3\":\"张三3\",\"name2\":\"张三2\",\"name1\":\"张三1\"}");
//        return jsonObjecttest22.getJSONObject("name3").getIntValue("code")!=0;
    }
}
