package future_api;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

class FutureApiTest {

    private Random r = new Random();

    Void heavyWork(String workName) {
        long waitTime = Math.abs(r.nextLong()) % 2000;
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException ignored) {
        }

        System.out.printf("work %s finish.(wait: %d msec)%n", workName, waitTime);
        return null;
    }

    // java8でできたこと
    @Test
    void testJava8() {
        Executor executor = Executors.newCachedThreadPool();

        long startTime = System.currentTimeMillis();

        CompletableFuture<Void> cf = CompletableFuture.allOf(
                CompletableFuture.supplyAsync(() -> heavyWork("job1"), executor),
                CompletableFuture.supplyAsync(() -> heavyWork("job2"), executor),
                CompletableFuture.supplyAsync(() -> heavyWork("job3"), executor)
        );

        cf.whenComplete((ret, ex) -> {
            long time = System.currentTimeMillis() - startTime;
            System.out.printf("all finished. time: %d msec%n", time);
        });

        try {
            cf.get(); // 終了待ち
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test1() {
        // ユーティリティメソッドができた(1秒待ってから実行開始)
        Executor executor = CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS);

        long startTime = System.currentTimeMillis();

        CompletableFuture<Void> cf = CompletableFuture.allOf(
                CompletableFuture.supplyAsync(() -> heavyWork("job1"), executor),
                CompletableFuture.supplyAsync(() -> heavyWork("job2"), executor),
                CompletableFuture.supplyAsync(() -> heavyWork("job3"), executor)
        );

        cf.whenComplete((ret, ex) -> {
            long time = System.currentTimeMillis() - startTime;
            System.out.printf("all finished. time: %d msec%n", time);
        });

        try {
            cf.get(); // 終了待ち
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
