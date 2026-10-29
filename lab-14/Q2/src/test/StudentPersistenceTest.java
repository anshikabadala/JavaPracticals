package com.example.studentapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class StudentPersistenceTest{
    @TempDir
    Path tempDir;

    @Test
    void savedDataLoadsUnchanged()throws Exception{
        String file=tempDir.resolve("students.dat").toString();

        StudentService original=new StudentService();
        original.addStudent(new Student(1,"Amit"));
        original.addStudent(new Student(2,"Raj"));
        original.save(file);

        StudentService loaded=new StudentService();
        loaded.load(file);

        assertEquals(2,loaded.getCount());
        assertEquals(1,loaded.getStudents().get(0).getId());
        assertEquals("Amit",loaded.getStudents().get(0).getName());
        assertEquals(2,loaded.getStudents().get(1).getId());
        assertEquals("Raj",loaded.getStudents().get(1).getName());
    }
}
