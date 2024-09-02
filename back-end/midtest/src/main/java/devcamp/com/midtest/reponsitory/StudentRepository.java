package devcamp.com.midtest.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devcamp.com.midtest.models.Student;
import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    Optional<Student>  findByStudentCode(String studentCode);
    List<Student> findByStudentName(String studentName);
}
