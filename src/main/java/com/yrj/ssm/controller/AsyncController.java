package com.yrj.ssm.controller;

import com.yrj.ssm.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author ：Yangrj
 * @date ：Created in 2020/3/11 15:41
 * @description：异步测试控制类
 * @version: 1.0$
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("step1")
    public void step1() throws InterruptedException, ExecutionException {
        // 这个没有进行异步处理，整个程序按照顺序从上往下执行
//        asyncService.step1();
        // 这个已经进行了异步处理
//        asyncService.step2();

        // 有回调结果的异步请求
        asyncService.step3();
    }
}
