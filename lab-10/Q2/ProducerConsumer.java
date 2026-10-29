class Buffer{
    int[] data=new int[3];
    int count=0;
    int in=0;
    int out=0;

    synchronized void produce(int value)throws InterruptedException{
        while(count==data.length){
            wait();
        }

        data[in]=value;
        in=(in+1)%data.length;
        count++;

        System.out.println("Produced: "+value);
        notify();
    }

    synchronized int consume()throws InterruptedException{
        while(count==0){
            wait();
        }

        int value=data[out];
        out=(out+1)%data.length;
        count--;

        System.out.println("Consumed: "+value);
        notify();

        return value;
    }
}

public class ProducerConsumer{
    public static void main(String[] args)throws InterruptedException{
        Buffer buffer=new Buffer();
        int total=10;

        Thread producer=new Thread(()->{
            try{
                for(int i=1;i<=total;i++){
                    buffer.produce(i);
                }
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer=new Thread(()->{
            try{
                for(int i=1;i<=total;i++){
                    buffer.consume();
                }
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("All items processed");
    }
}