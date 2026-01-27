package com.example.Day3_SMS.service;
import java.util.*;
import com.example.Day3_SMS.model.StudentModel;
import com.example.Day3_SMS.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository=repository;
    }
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }

    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    public StudentModel updateStudent(String id , StudentModel student){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);
    }
    // D E L E T E .....
    public void deleteStudent(String id) {
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found"));

        repository.delete(existingStudent);
    }
}
