package com.school.client;

import com.school.reponses.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "STUDENT", url = "http://localhost:9090/student")
public interface StudentClient {

    @GetMapping("/school/{school_id}")
    List<Student> getAllStudentsBySchoolId(@PathVariable Integer school_id);
}

