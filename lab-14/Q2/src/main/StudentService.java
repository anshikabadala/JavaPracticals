package com.example.studentapp;

import java.util.ArrayList;
import java.io.*;

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

    public void save(String file)throws IOException{
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(students);
        }
    }

    @SuppressWarnings("unchecked")
    public void load(String file)throws IOException,ClassNotFoundException{
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(file))){
            students=(ArrayList<Student>)in.readObject();
        }
    }
}
