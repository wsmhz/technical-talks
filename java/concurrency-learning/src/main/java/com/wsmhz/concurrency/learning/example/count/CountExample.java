package com.wsmhz.concurrency.learning.example.count;

import com.wsmhz.concurrency.learning.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created By tangbj On 2019/7/24
 * Description: 简单的计数器--线程不安全
 */
@NotThreadSafe
@Slf4j
public class CountExample {

    private static int clientTotal = 5000;

    private static int threadCount = 200;

    private static int count = 0;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(threadCount);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    count ++;
                    semaphore.release();

                    countDownLatch.countDown();
                } catch (Exception e){
                    log.error("error:",e);
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:" + count);
    }

}
