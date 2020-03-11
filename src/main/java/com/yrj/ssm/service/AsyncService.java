package com.yrj.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ：Yangrj
 * @date ：Created in 2020/3/11 15:29
 * @description：异步测试服务类
 * @version: 1.0$
 */
@Service
public class AsyncService {

    @Autowired
    private AsyncService2 asyncService2;

    /**
     * 没有进行异步处理asyncService2
     * @throws InterruptedException
     */
    public void step1 () throws InterruptedException {
        System.out.println("AA:我不爱你了？");

        asyncService2.say();

        System.out.println("AA:这么久才回复我？");
    }

    public void step2 () throws InterruptedException {
        System.out.println("AA:我不爱你了？");

//        asyncService2.say2();

        // 调用了同一个service中的异步方法
//        say();

        // 有返回值的异步方法的调用
        String result = asyncService2.say3();
        System.out.println(result); // 没有结果，异步请求还没有来得及返回结果

        System.out.println("AA:这么久才回复我？");
    }

    /**
     * 调用同一个service下，异步失效（原因：查找Async的异步原理）
     * @throws InterruptedException
     */
    @Async
    public void say() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("AA:还没有回复？！");
    }

    /**
     * 测试有回调结果的异步请求
     * @throws InterruptedException
     */
    public void step3 () throws InterruptedException, ExecutionException {
        System.out.println("AA:我不爱你了？");

        Future<String> future = asyncService2.say4();
        System.out.println(future.get());

        System.out.println("AA:这么久才回复我？");

    }
}
