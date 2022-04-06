package com.eLibrary.eLibrary.service;

import com.eLibrary.eLibrary.model.Student;
import com.eLibrary.eLibrary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public  StudentService(StudentRepository  studentRepository){
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student  student){
        studentRepository.save(student);
    }

    public List<Student>  findStudents(){
        return  studentRepository.findAll();
    }

    public Optional<Student> findStudentById(Integer studentId){
        return studentRepository.findById(studentId);
    }

    public void  delete( Student student){
        studentRepository.delete(student);
    }
}
