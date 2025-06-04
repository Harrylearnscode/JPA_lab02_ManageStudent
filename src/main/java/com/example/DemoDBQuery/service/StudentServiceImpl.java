package com.example.DemoDBQuery.service;

    import com.example.DemoDBQuery.pojo.Student;
    import com.example.DemoDBQuery.repository.StudentRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class StudentServiceImpl implements StudentService {
        @Autowired
        private StudentRepository studentRepository;

        @Override
        public void save(Student student) {
            studentRepository.save(student);
        }

        @Override
        public Student find(int studentId) {
            return studentRepository.findById(studentId).orElse(null);
        }

        @Override
        public void delete(int studentId) {
            if (studentRepository.existsById(studentId)) {
                studentRepository.deleteById(studentId);
                System.out.println("Student with ID " + studentId + " has been deleted.");
            } else {
                System.out.println("Student with ID " + studentId + " does not exist.");
            }
        }

        @Override
        public void update(Student student) {
            if (studentRepository.existsById(student.getCode())) {
                studentRepository.save(student);
                System.out.println("Student with ID " + student.getCode() + " has been updated.");
            } else {
                System.out.println("Student with ID " + student.getCode() + " does not exist.");
            }
        }

        @Override
        public List<Student> findAll() {
            return studentRepository.findAll();
        }
    }