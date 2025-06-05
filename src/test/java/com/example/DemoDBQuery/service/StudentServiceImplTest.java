package com.example.DemoDBQuery.service;

import com.example.DemoDBQuery.pojo.Student;
import com.example.DemoDBQuery.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        student1 = new Student("John Doe", "john.doe", "password123");
        student1.setCode(1L);
        student2 = new Student("Jane Smith", "jane.smith", "password456");
        student2.setCode(2L);
    }

    @Test
    void testFind_StudentExists() {
        long studentId = 1L;
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student1));

        Optional<Student> result = studentService.find(studentId);

        assertTrue(result.isPresent(), "Student should be found");
        assertEquals(student1.getName(), result.get().getName(), "Student name should match");
    }

    @Test
    void testFind_StudentDoesNotExist() {
        long studentId = 3L;
        when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

        Optional<Student> result = studentService.find(studentId);

        assertFalse(result.isPresent(), "Student should not be found");
    }

    @Test
    void testFindAll_StudentsExist() {
        List<Student> students = List.of(student1, student2);
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.findAll();

        assertNotNull(result, "Result list should not be null");
        assertEquals(2, result.size(), "Result list size should be 2");
        assertEquals(students, result, "Returned list should match the mocked list");
    }

    @Test
    void testFindAll_NoStudentsExist() {
        when(studentRepository.findAll()).thenReturn(Collections.emptyList());

        List<Student> result = studentService.findAll();

        assertNotNull(result, "Result list should not be null");
        assertTrue(result.isEmpty(), "Result list should be empty");
    }

    @Test
    void testFindAll_RepositoryReturnsNull() {
        when(studentRepository.findAll()).thenReturn(null);

        List<Student> result = studentService.findAll();

        assertNotNull(result, "Result list should not be null");
        assertTrue(result.isEmpty(), "Result list should be empty when repository returns null");
    }
}
