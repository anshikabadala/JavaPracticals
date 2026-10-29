class DeadlockDemo{
    static final Object lock1=new Object();
    static final Object lock2=new Object();

    static void createDeadlock(){
        Thread t1=new Thread(()->{
            synchronized(lock1){
                System.out.println("Thread 1 locked lock1");

                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }

                synchronized(lock2){
                    System.out.println("Thread 1 locked lock2");
                }
            }
        });

        Thread t2=new Thread(()->{
            synchronized(lock2){
                System.out.println("Thread 2 locked lock2");

                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }

                synchronized(lock1){
                    System.out.println("Thread 2 locked lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }

    static void avoidDeadlock(){
        Thread t1=new Thread(()->{
            synchronized(lock1){
                System.out.println("Thread 1 locked lock1");

                synchronized(lock2){
                    System.out.println("Thread 1 locked lock2");
                }
            }
        });

        Thread t2=new Thread(()->{
            synchronized(lock1){
                System.out.println("Thread 2 locked lock1");

                synchronized(lock2){
                    System.out.println("Thread 2 locked lock2");
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args){
        System.out.println("Deadlock demonstration:");
        createDeadlock();

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("Deadlock demonstration may leave threads blocked.");
        System.out.println("Run avoidDeadlock() separately to test the solution.");
    }
}