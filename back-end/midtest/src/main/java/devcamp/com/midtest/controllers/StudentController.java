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
import devcamp.com.midtest.models.Student;
import devcamp.com.midtest.reponsitory.ClassroomRepository;
import devcamp.com.midtest.reponsitory.StudentRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    
	@PostMapping("/student/{id}")
	public ResponseEntity<Object> createStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		try {
			Optional<Classroom> classroomData = classroomRepository.findById(id);
			if (classroomData.isPresent()) {
				Student newStudent = new Student();
				newStudent.setStudentCode(student.getStudentCode());
				newStudent.setStudentName(student.getStudentName());
				newStudent.setGender(student.getGender());
				newStudent.setAddress(student.getAddress());
				newStudent.setDateOfBirth(student.getDateOfBirth());
				newStudent.setPhoneNumber(student.getPhoneNumber());			
				Classroom _classroom = classroomData.get();
				newStudent.setClassroom(_classroom);				
				Student savedStudent = studentRepository.save(newStudent);
				return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			System.out.println("+++++++++++++++++++++::::: " + e.getCause().getCause().getMessage());
			return ResponseEntity.unprocessableEntity().body("Không thể tạo học sinh: " + e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
        @PutMapping("/student/{id}")
        public ResponseEntity<Object> updateRegion(@PathVariable("id") Long id, @RequestBody Student student) {
		Optional<Student> studentData = studentRepository.findById(id);
		if (studentData.isPresent()) {
			Student newStudent = studentData.get();
            newStudent.setStudentCode(student.getStudentCode());
            newStudent.setStudentName(student.getStudentName());
            newStudent.setClassroom(student.getClassroom());
            newStudent.setAddress(student.getAddress());
            newStudent.setGender(student.getGender());
            newStudent.setDateOfBirth(student.getDateOfBirth());
            newStudent.setPhoneNumber(student.getPhoneNumber());
			Student savedRegion = studentRepository.save(newStudent);
			return new ResponseEntity<>(savedRegion, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @DeleteMapping("/student/{id}")
	public ResponseEntity<Object> deleteRegionById(@PathVariable Long id) {
		try {
			studentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    @GetMapping("/region/{id}")
	public Student getStudentById(@PathVariable Long id) {
		if (studentRepository.findById(id).isPresent())
			return studentRepository.findById(id).get();
		else
			return null;
	}
    @GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
}
