package com.student.services;

import com.student.entities.Student;
import com.student.dtos.StudentDto;
import com.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // GET - List<Student>
    public List<Student> getAllStudents() {
        List<Student> all = studentRepository.findAll();
        return all;
    }

    // POST - Create and return a Student
    public Student createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setGrade(studentDto.getGrade());
        student.setSchoolId(studentDto.getSchoolId());

        Student created = studentRepository.save(student);
        return created;
    }

    public List<Student> getAllStudentsBySchoolId(Integer schoolId) {
        List<Student> studentSchool = new ArrayList<>();

        List<Student> allStudents = studentRepository.findAll();

        for(Student student : allStudents) {
            if(student.getSchoolId() == schoolId){
                studentSchool.add(student);
            }
        }
        return studentSchool;
    }
}
