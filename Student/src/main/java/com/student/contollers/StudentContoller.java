package com.student.contollers;

import com.student.dtos.StudentDto;
import com.student.entities.Student;
import com.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentContoller {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.createStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/school/{school_id}")
    public ResponseEntity<List<Student>> getAllStudentsBySchoolId(@PathVariable Integer school_id) {
        List<Student> allStudentsBySchoolId = studentService.getAllStudentsBySchoolId(school_id);
        return new ResponseEntity<>(allStudentsBySchoolId, HttpStatus.OK);
    }
}
