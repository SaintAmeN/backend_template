package pl.sda.java.springdemo.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.java.springdemo.model.Student;
import pl.sda.java.springdemo.service.StudentService;

import java.util.List;

// REST == HTTP == ZAPYTANIA == REQUESTS (mają 'metody')
// Wyróżniamy metody HTTP:
//  - GET     (pobierz)
//  - POST    (wstaw, edytuj)
//  - DELETE  (usuń)
//  - PUT     (wstaw, podmień)
//  - PATCH   (edytuj fragment [nie cały])
//  RESTFUL API
// http://localhost:8080
//  - protokół http
//  - host localhost
//  - port 8080
//  - CTX - pusty
// jdbc:mysql://localhost:3306/arppl4_spring_demo?serverTimezone=Europe/Warsaw&createDatabaseIfNotExist=true
//  - protokół jdbc:mysql
//  - host localhost
//  - port 3306
//  - CTX - arppl4_spring_demo
@Slf4j
@CrossOrigin
@RequestMapping("/api/student")
@RestController()
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    //<editor-fold desc="CRUD>
    @GetMapping
    @CrossOrigin
    public List<Student> studentList() {
        log.info("Wywołano metodę studentList");

        List<Student> studentList = studentService.findAll();

        return studentList;
    }

    // PathVariable - Zmienna podana w ścieżce
    // http://localhost:8080/api/student/5
    @ApiOperation(value = "znajdzStudenta", notes = "Ten endpoint pozwala na znajdowanie studentów po ich identyfikatorach w bazie danych.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ten kod oznacza sukces operacji i poprawne załadowanie obiektów z tabeli 'student' w bazie."),
            @ApiResponse(code = 400, message = "Ten kod oznacza źle wpisaną wartość lub typ parametru."),
            @ApiResponse(code = 401, message = "Ten kod oznacza brak uprawnień do wykonywania tej operacji."),
            @ApiResponse(code = 403, message = "Ten kod oznacza dostęp zabroniony."),
            @ApiResponse(code = 500, message = "Ten kod oznacza błąd serwera."),
    })
    @CrossOrigin
    @GetMapping("/{identifier}")
    public Student findStudent(@ApiParam(name = "Identyfikator studenta", example = "1", type = "long", required = true) @PathVariable(name = "identifier") Long studentId) {
        log.info("Wywołano metodę findStudent: " + studentId);

        return studentService.findById(studentId);
    }

    // REST -> Representation State Transfer
    // Resource
    // PathVariable - Zmienna podana w ścieżce
    // http://localhost:8080/api/student/5
    @DeleteMapping("/{identifier}")
    @CrossOrigin
    public void deleteStudent(@PathVariable(name = "identifier") Long studentId) {
        log.info("Wywołano metodę deleteStudent: " + studentId);

        studentService.deleteById(studentId);
    }

    // Request Param - parametr zapytania
    // http://localhost:8080/api/student/find?studentId=5
    @GetMapping("/find")
    public Student findStudentById(@RequestParam(name = "studentId") Long studentId) {
        log.info("Wywołano metodę findStudentById: " + studentId);

        return studentService.findById(studentId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public void createStudent(@RequestBody Student student) {
        log.info("Wywołano metodę createStudent: " + student);

        studentService.save(student);
    }
    //</editor-fold>

    // Request Param - parametr zapytania
    // Select * from Student s where s.name LIKE %Gawel%
    // http://localhost:8080/api/student/findByName?name=Gawel
    @GetMapping("/findByName")
    @CrossOrigin
    public List<Student> findStudentByName(@RequestParam(name = "name") String searchedName) {
        log.info("Wywołano metodę findStudentByName: " + searchedName);

        return studentService.findAllByNameContaining(searchedName);
    }
}

// RestController -> Zwraca DANE!
// Controller     -> Zwraca HTML - zwraca wygląd strony
//
// [Controller] -> [ Service ] -> [Repository]