package logic;

import java.util.*;

import logic.subjects.CodingSubject;
import logic.subjects.Subject;

public class Student {

    private List<Subject> subjects;
    private String studentName;
    
    public Student(String studentName) {
        this.subjects = List.of(
            new CodingSubject("OOP"),
            new CodingSubject("DSA"),
            new Subject("IE"),
            new Subject("CALC"),
            new Subject("PK"),
            new Subject("SEC")
        );

        this.studentName = studentName;
    }



    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getName() {
        return studentName;
    }

}