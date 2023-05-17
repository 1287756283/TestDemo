import org.junit.Test;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * @author LIAN
 * @create 2021/10/13 22:42
 */
public class Test1 {
    @Test
    public void a(){
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (2, 3, 3, TimeUnit.SECONDS,
                workQueue, new ThreadPoolExecutor.DiscardPolicy());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()    //队列满了，（尝试竞争）会尝试和最早的人取竞争，不抛出异常
                // new ThreadPoolExecutor.AbortPolicy()      //银行人满了，但是还有人进来，就不处理并抛出异常
                // new ThreadPoolExecutor.CallerRunsPolicy() //哪里来的去哪里
                // new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，不会抛出异常
        );
        Thread thread = new Thread(() -> System.out.println(1111));
        executor.execute(thread);
        threadPool.execute(thread);
    }

}
