package spring.studentproject.orm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.studentproject.orm.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
