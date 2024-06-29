package spring.studentproject.orm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.studentproject.orm.dao.StudentRepository;
import spring.studentproject.orm.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{
    
	@Autowired
	StudentRepository studentRepository;
	 public Student addStudent(Student st)
	 {
		 return studentRepository.save(st); 
	 }
	 
	 public List<Student> getAllStudent()
	 {
		 return studentRepository.findAll();
	 }
	 
	 public Student getStudentById(int id)
	 {
		 Optional<Student>op= studentRepository.findById(id);
		 Student st=op.get();
		 return st;
	 }
	 public Student updateStudent(Student st)
	 {
		 return studentRepository.save(st);
	 }
	 public void deleteStudent(int id)
	 {
		 studentRepository.deleteById(id);
	 }
}
