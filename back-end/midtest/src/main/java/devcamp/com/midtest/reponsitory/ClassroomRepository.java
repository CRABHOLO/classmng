package devcamp.com.midtest.reponsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devcamp.com.midtest.models.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long>{
    Optional<Classroom>  findByClassCode(String classCode);
    List<Classroom> findByClassName(String className);
} 