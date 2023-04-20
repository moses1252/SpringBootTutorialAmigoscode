package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@PostMapping
	public void addNewStudent(Student student) {
		Optional<Student> studentByOptional = studentRepository
				.findStudentByEmail(student.getEmail());
		
		if (studentByOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exist = studentRepository.existsById(studentId);
		
		if (!exist) {
			throw new IllegalStateException(
					"student with id " + studentId + " does not exists");    
			
		}
		studentRepository.deleteById(studentId);
	}
}
