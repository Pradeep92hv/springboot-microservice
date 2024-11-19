package net.javaguides.springboot_rest_api.controller;

import net.javaguides.springboot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student =new Student(
                1,
                "pradeep",
                "HV"
        );

        return  student;
    }


    //http://localhost:8080/students
@GetMapping("students")
    public List<Student> getstudents(){

        List<Student> students=new ArrayList<>();

        students.add(new Student(1,"a","b"));
        students.add(new Student(2,"aa","bb"));

        return  students;
    }

    // spring boot REST API that with path variable

    //http://localhost:8080/students/1/jyfh/try
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstNmae,
                                       @PathVariable("last-name") String lastname){
        return new Student(studentId,firstNmae,lastname);
    }

    // create spring boot REST API that with Request variable , it extract the value from query paramter,  path varivale use value from url

    //http://localhost:8080/students/query?id=1&firstName=pradeep&lastName=HV
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          String firstName,
                                          String lastName){
        return new Student(id,firstName,lastName);
    }
}
