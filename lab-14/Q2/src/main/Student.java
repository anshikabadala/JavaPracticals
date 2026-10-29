package com.example.studentapp;

import java.io.Serializable;

public class Student implements Serializable{
    private static final long serialVersionUID=1L;
    private int id;
    private String name;

    public Student(int id,String name){
        if(id<=0||name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid student");
        }
        this.id=id;
        this.name=name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
