package devcamp.com.midtest.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "student_code")
    @NotBlank(message = "Mã học sinh không được để trống")
    private String studentCode; 
    @Column(name = "student_name" , unique = true)
    @NotBlank(message = "Tên học sinh không được để trống")
    private String studentName;
    @Column(name = "gender")
    @NotBlank(message = "Giới tính không được để trống")
    private String gender;
    
    @Column(name = "date_of_birth")
    @NotNull(message = "Ngày sinh không được để trống")
    private Date dateOfBirth;
    @Column(name = "address")
    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;
    @Column(name = "phone_number")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Số điện thoại không hợp lệ")
    private String phoneNumber;

    @ManyToOne
    @JsonIgnore
    private Classroom classroom;

    public Student() {
    }

    public Student(long id, String studentCode, String studentName, String gender, Date dateOfBirth, String address,
        String phoneNumber, Classroom classroom) {
        this.id = id;
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classroom = classroom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
    
}
