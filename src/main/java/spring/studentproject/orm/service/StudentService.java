package spring.studentproject.orm.service;

import java.util.List;

import spring.studentproject.orm.entity.Student;

public interface StudentService {
    public Student addStudent(Student st);
    public List<Student> getAllStudent();
    public Student getStudentById(int id);
    public Student updateStudent(Student st);
    public void deleteStudent(int id);
}
