package com.example.DemoDBQuery.service;

    import com.example.DemoDBQuery.pojo.Subjects;
    import com.example.DemoDBQuery.repository.SubjectRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;
    import java.util.Collections;

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
            List<Subjects> subjects = subjectRepository.findAll();
            return subjects == null ? Collections.emptyList() : subjects;
        }

        @Override
        public void delete(long subjectCode) {
            if (subjectRepository.existsById(subjectCode)) {
                subjectRepository.deleteById(subjectCode);
            }
        }

        @Override
        public void update(Subjects subject) {
            if (subjectRepository.existsById(subject.getSubjectCode())) {
                subjectRepository.save(subject);
            }
        }

        @Override
        public Optional<Subjects> find(long subjectCode) {
            return subjectRepository.findById(subjectCode);
        }
    }