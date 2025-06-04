package com.example.DemoDBQuery.service;

        import com.example.DemoDBQuery.pojo.Subjects;
        import com.example.DemoDBQuery.repository.SubjectRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

        @Service
        public class SubjectServiceImpl implements SubjectService {
            @Autowired
            private SubjectRepository subjectRepository;

            @Override
            public void save(Subjects subject) {
                subjectRepository.save(subject);
            }

            @Override
            public List<Subjects> findAll() {
                return subjectRepository.findAll();
            }

            @Override
            public void delete(int subjectCode) {
                if (subjectRepository.existsById(subjectCode)) {
                    subjectRepository.deleteById(subjectCode);
                    System.out.println("Subject with code " + subjectCode + " deleted successfully.");
                } else {
                    System.out.println("Subject with code " + subjectCode + " not found.");
                }
            }

            @Override
            public void update(Subjects subject) {
                if (subjectRepository.existsById(subject.getSubjectCode())) {
                    subjectRepository.save(subject);
                    System.out.println("Subject with code " + subject.getSubjectCode() + " updated successfully.");
                } else {
                    System.out.println("Subject with code " + subject.getSubjectCode() + " not found.");
                }
            }

            @Override
            public Subjects find(int subjectCode) {
                return subjectRepository.findById(subjectCode).orElse(null);
            }
        }