import java.util.*;

public class UniqueVisitors{
    public static void main(String[] args){
        List<String> names=Arrays.asList("Ansh","Tirth","Jugal","Om","Aryan","Tirth","Manav","om");

        HashSet<String> set=new HashSet<>(names);
        LinkedHashSet<String> linked=new LinkedHashSet<>(names);

        System.out.println("Unique Users: "+set.size());
        System.out.println("First Three Distinct Names:");

        int count=0;
        for(String name:linked){
            if(count==3){
                break;
            }
            System.out.println(name);
            count++;
        }
    }
}