package com.wsmhz.concurrency.learning.example.count;

import com.wsmhz.concurrency.learning.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created By tangbj On 2019/7/24
 * Description: 计数器(Atomic)--线程不安全
 */
@ThreadSafe
@Slf4j
public class CountExample2 {

    private static int clientTotal = 5000;

    private static int threadCount = 200;

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(threadCount);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    count.incrementAndGet();
                    semaphore.release();

                    countDownLatch.countDown();
                } catch (Exception e){
                    log.error("error:",e);
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:" + count.get());
    }

}
