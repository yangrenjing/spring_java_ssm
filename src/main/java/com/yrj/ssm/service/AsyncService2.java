package com.yrj.ssm.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author ：Yangrj
 * @date ：Created in 2020/3/11 15:37
 * @description：异步测试类2
 * @version: 1.0$
 */
@Service
public class AsyncService2 {

    /**
     * 未进行异步处理的say方法
     *
     * @throws InterruptedException
     */
    public void say() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("BB:爱你！");
    }

    /**
     * 使用Async进行异步处理的say方法
     *
     * @throws InterruptedException
     */
    @Async
    public void say2() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("BB:爱你！");
    }

    /**
     * 有返回值的异步方法
     *
     * @throws InterruptedException
     */
    @Async
    public String say3() throws InterruptedException {
        Thread.sleep(2000);
        return "BB:爱你！";
    }

    @Async
    public Future<String> say4 () throws InterruptedException {
        Thread.sleep(2000);
        String result = "BB:爱你！";

        return new AsyncResult<String>(result);
    }
}
