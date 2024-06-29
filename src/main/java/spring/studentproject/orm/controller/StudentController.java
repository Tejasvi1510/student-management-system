package spring.studentproject.orm.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.studentproject.orm.entity.Student;
import spring.studentproject.orm.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public String getAllStudent(Model m)
	{
		List<Student> studentList=studentService.getAllStudent();
		m.addAttribute("students", studentList);
		return "all_students";
	}
	@GetMapping("/students/add_student_form")
	public String createStudentForm(Model m)
	{
		Student s=new Student();
		m.addAttribute("student", s);
		return "add_student_form";
	}
	@PostMapping("/students/add")
	public String addStudent(@ModelAttribute("student") Student student)
	{
		studentService.addStudent(student);
         return "redirect:/students";
	}
	@GetMapping("/students/editStudent/{id}")
	public String editStudentForm(@PathVariable("id") int id,Model m)
	{
		Student st=studentService.getStudentById(id);
		m.addAttribute("st", st);
		return "editStudentForm";
	}
	@PostMapping("/students/update/{id}")
	public String saveEdit(@PathVariable("id") int id,@ModelAttribute("st") Student st)
	{
		Student student=studentService.getStudentById(id);
		student.setFirstName(st.getFirstName());
		student.setLastName(st.getLastName());
		student.setEmailId(st.getEmailId());
		studentService.updateStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	
}
    
	