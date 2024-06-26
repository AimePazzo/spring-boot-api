package com.example.demo.student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="api/v1/student")
public class studentController {

    private final StudentService studentService;

    @Autowired
    public studentController (StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
public List<Student> Students(){
    return studentService.getStudents();
}
@PostMapping
public void registerNewStudent(@RequestBody Student student){
    studentService.addNewStudent(student);
}
@DeleteMapping(path ="{studentId}")
public void deleteStudent(@PathVariable("studentId") Long StudentId) {
    studentService.deleteStudent(StudentId);
}
@PutMapping(path="{studentId}")
public void updateStudent(
    @PathVariable("studentId") Long studentId,
    @RequestParam(required = false) String name,
    @RequestParam(required = false ) String email
   
){
    studentService.updateStudent(studentId, name ,email);
}
}
