package com.sanket.student_service.controller;

import com.sanket.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/home/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getMarks/{id}")
    Long getStudentMarks(@PathVariable("id") String id) throws URISyntaxException {
        return studentService.getStudentAverage(id);
    }


}
