import java.io.*;

class Student implements Serializable{
    int id;
    String name;
    transient String password;

    Student(int id,String name,String password){
        this.id=id;
        this.name=name;
        this.password=password;
    }
}

public class SaveLoad{
    public static void main(String[] args)throws Exception{
        Student[] s={new Student(1,"Ansh","abc123"),new Student(2,"Hetav","xyz456")};

        ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("student.dat"));
        o.writeObject(s);
        o.close();

        ObjectInputStream i=new ObjectInputStream(new FileInputStream("student.dat"));
        Student[] loaded=(Student[])i.readObject();
        i.close();

        for(Student st:loaded){
            System.out.println("ID: "+st.id);
            System.out.println("Name: "+st.name);
            System.out.println("Password: "+st.password);
        }
    }
}