package logic;

import java.util.*;

import logic.subjects.CodingSubject;
import logic.subjects.Subject;

public class Student {

    private ArrayList<Subject> subjects;
    private String studentName;
    
    public Student(String studentName) {
        
        this.subjects = new ArrayList<>();

        // adding all the subjects, codingsubejcts also implements a Codeable
        // interface so that they also open code editor upon selection
        subjects.add(new CodingSubject("OOP"));
        subjects.add(new CodingSubject("DSA"));
        subjects.add(new Subject("IE"));
        subjects.add(new Subject("CALC"));
        subjects.add(new Subject("PK"));
        subjects.add(new Subject("SEC"));
       
        this.studentName = studentName;
    }



    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public String getName() {
        return studentName;
    }

}