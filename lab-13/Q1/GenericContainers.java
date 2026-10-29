class Box<T>{
    private T value;

    public void set(T value){
        this.value=value;
    }

    public T get(){
        return value;
    }
}

class Pair<A,B>{
    private A first;
    private B second;

    Pair(A first,B second){
        this.first=first;
        this.second=second;
    }

    public A getFirst(){
        return first;
    }

    public B getSecond(){
        return second;
    }
}

public class GenericContainers{
    public static <T>T first(T[] array){
        return array[0];
    }

    public static void main(String[] args){
        Box<Integer> b1=new Box<>();
        b1.set(100);
        System.out.println("Integer Box: "+b1.get());

        Box<String> b2=new Box<>();
        b2.set("Java");
        System.out.println("String Box: "+b2.get());

        Pair<String,Integer> p=new Pair<>("Anshika",19);
        System.out.println("Name: "+p.getFirst());
        System.out.println("Age: "+p.getSecond());

        String[] names={"Ashu","Heshvi","Kritika"};
        Integer[] numbers={18,19,30};

        System.out.println("First Name: "+first(names));
        System.out.println("First Number: "+first(numbers));
    }
}