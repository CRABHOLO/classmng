package devcamp.com.midtest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devcamp.com.midtest.models.Classroom;
import devcamp.com.midtest.reponsitory.ClassroomRepository;
import devcamp.com.midtest.reponsitory.StudentRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ClassroomController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    @PostMapping("/classroom")
    public ResponseEntity<Object> createClassroom(@RequestBody Classroom classroom) {
        try {
            Classroom newClassroom = classroomRepository.save(classroom);
            return new ResponseEntity<>(newClassroom, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("Failed to create Classroom: " + e.getMessage());
        }
    }

    @PutMapping("/classroom/{id}")
    public ResponseEntity<Object> updateClassroom(@PathVariable("id") Long id, @RequestBody Classroom classroom) {
        Optional<Classroom> classroomData = classroomRepository.findById(id);
        if (classroomData.isPresent()) {
            Classroom updatedClassroom = classroomData.get();
            updatedClassroom.setClassCode(classroom.getClassCode());
            updatedClassroom.setClassName(classroom.getClassName());
            updatedClassroom.setTeacherName(classroom.getTeacherName());
            updatedClassroom.setTeacherPhoneNumber(classroom.getTeacherPhoneNumber());

            Classroom savedClassroom = classroomRepository.save(updatedClassroom);
            return new ResponseEntity<>(savedClassroom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Classroom not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/classroom/{id}")
    public ResponseEntity<Object> deleteClassroomById(@PathVariable Long id) {
        try {
            classroomRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/classroom/{id}")
    public ResponseEntity<Object> getClassroomById(@PathVariable Long id) {
        Optional<Classroom> classroomData = classroomRepository.findById(id);
        if (classroomData.isPresent()) {
            return new ResponseEntity<>(classroomData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Classroom not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/classrooms")
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }
	

}
