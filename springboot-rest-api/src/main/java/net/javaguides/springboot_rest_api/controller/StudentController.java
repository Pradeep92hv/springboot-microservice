package net.javaguides.springboot_rest_api.controller;

import net.javaguides.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student =new Student(
                1,
                "pradeep",
                "HV"
        );

       // return new ResponseEntity<>(student,HttpStatus.OK);
//        return  ResponseEntity.ok(student);

        return ResponseEntity.ok().header("custom-header","pradeep")
                .body(student);
    }


    //http://localhost:8080/students
@GetMapping("")
    public ResponseEntity<List<Student>>  getstudents(){

        List<Student> students=new ArrayList<>();

        students.add(new Student(1,"a","b"));
        students.add(new Student(2,"aa","bb"));

//        return  students;
    return ResponseEntity.ok(students);
    }

    // spring boot REST API that with path variable

    //http://localhost:8080/students/1/jyfh/try
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstNmae,
                                       @PathVariable("last-name") String lastname){
        Student student= new Student(studentId,firstNmae,lastname);
        return ResponseEntity.ok(student);
    }

    // create spring boot REST API that with Request variable , it extract the value from query paramter,  path varivale use value from url

    //http://localhost:8080/students/query?id=1&firstName=pradeep&lastName=HV
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          String firstName,
                                          String lastName){
        Student student = new Student(id,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //  create spring boot REST API that Handle HTTP POST request
    // @postMapping n @RequestPost -> it retrive the Http request body(json) and conerts it to java object

    // http://localhost:8080/students/create

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student,HttpStatus.CREATED);

    }

    // spring boot REST API that Handle HTTP PUT request
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable int id){

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }


    // spring boot REST API that Handle HTTP DELETE request

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        System.out.println(id);
//        return  "deleteed successfullly";
        return ResponseEntity.ok("deleted successfullly");
    }
}
