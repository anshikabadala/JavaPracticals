import java.util.concurrent.*;

public class ThreadPoolRunner{
    public static void main(String[] args)throws InterruptedException{
        ExecutorService executor=Executors.newFixedThreadPool(3);

        for(int i=1;i<=10;i++){
            int id=i;

            executor.submit(()->{
                System.out.println("Task "+id+" running on "+Thread.currentThread().getName());

                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1,TimeUnit.MINUTES);

        System.out.println("All tasks completed");
    }
}