package net.javaguides.springbootrestapi.controller;

import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students") // defines base URL at class level
public class StudentController {

    // http://localhost:8080/students/student

    /*
    @ResponseEntity - a type that represents a full HTTP response, including headers, body, and status. It is used in Spring to provide a convenient way to build and return a complete HTTP response in a single line of code. The ResponseEntity class is a generic type that takes two parameters: the type of the response body, and the HTTP status code.

     This method returns Response Entity object with the Student object and a HttpStatus of OK. The ResponseEntity class is used to represent the HTTP response, which includes the Student object as the body, and the HTTP status code OK indicating that the request was successful.
     */

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Ramesh",
                "Fadatare"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student); // same thing as above
        return ResponseEntity.ok()
                .header("custom-header","ramesh") // add custom headers with key/value pairs
                .body(student);
    }

    // http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ramesh", "Fadatare"));
        students.add(new Student(2, "Umesh", "Fadatare"));
        students.add(new Student(3, "Ram", "Jadhav"));
        students.add(new Student(4, "Sanjay", "Pawar"));
        return ResponseEntity.ok(students);
    }

    // Spring Boot REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        //@PathVariable used to bind to value of URI template variable (in this case {id})
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Ramesh&lastName=Fadatare // parameter
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam() int id,
                                          @RequestParam() String firstName,
                                          @RequestParam() String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP POST Request - creating new resource
    // @PostMapping used for mapping HTTP POST requests onto specific handler methods
    // @RequestBody responsible for retrieving HTTP request body (JSON object) and automatically converting it to a java object for posting -- uses Spring pvovided HttpMessageConverter to convert JSON into java object
    // ***** ATTRIBUTES OF JSON OBJECT AND JAVA OBJECT HAVE TO BE THE SAME *****
    // @ResponseStatus allows you to specify the http response that should be sent. Since this is a post reqeust response should be 201 created
    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED) // (should return status code 201 - returns 200 by default - needs to be set)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring boot REST API that handles HTTP PUT Request - updating existing resource
    // @PutMapping used for mapping HTTP PUT requests onto specific handler methods
    @PutMapping("{id}/update") // should return status code 200 (does by default)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP DELETE Request - deleting existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
