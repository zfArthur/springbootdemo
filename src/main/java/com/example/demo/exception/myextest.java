package com.example.demo.exception;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author zhangfu
 * @Date 2020-10-02 12:09
 */
@Slf4j
public class myextest {
    public static void main(String[] args) {

      try {
          myextest mye = new myextest();
          mye.testEx();
    }catch (MyExceptionTest e){

        }
    }

    public void testEx() {
//        throw new MyExceptionTest(BizCodeEnum.APPOINT_BASIC_INVALID);
    }
}
