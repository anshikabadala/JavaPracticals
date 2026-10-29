import java.util.ArrayList;

public class StudentService{
    private ArrayList<Student> students=new ArrayList<>();

    public void addStudent(Student s){
        if(s==null){
            throw new IllegalArgumentException("Student cannot be null");
        }
        for(Student student:students){
            if(student.getId()==s.getId()){
                throw new IllegalArgumentException("Student already exists");
            }
        }
        students.add(s);
    }

    public int getCount(){
        return students.size();
    }

    public ArrayList<Student> getStudents(){
        return new ArrayList<>(students);
    }
}