package net.javaguides.springboot_rest_api.controller;

import net.javaguides.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    //  create spring boot REST API that Handle HTTP POST request
    // @postMapping n @RequestPost -> it retrive the Http request body(json) and conerts it to java object

    // http://localhost:8080/students/create

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return  student;

    }

    // spring boot REST API that Handle HTTP PUT request
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable int id){

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return  student;
    }


    // spring boot REST API that Handle HTTP DELETE request

    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable int id){
        System.out.println(id);
        return  "deleteed successfullly";
    }
}
