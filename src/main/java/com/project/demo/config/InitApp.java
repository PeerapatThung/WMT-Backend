package com.project.demo.config;

import com.project.demo.preference.entity.Preference;
import com.project.demo.preference.repository.PreferenceRepository;
import com.project.demo.security.entity.Authority;
import com.project.demo.security.entity.AuthorityName;
import com.project.demo.security.entity.User;
import com.project.demo.security.repository.AuthorityRepository;
import com.project.demo.security.repository.UserRepository;
import com.project.demo.student.entity.Student;
import com.project.demo.student.repository.StudentRepository;
import com.project.demo.subject.entity.Category;
import com.project.demo.subject.entity.Subject;
import com.project.demo.subject.repository.CategoryRepository;
import com.project.demo.subject.repository.SubjectRepository;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    PreferenceRepository preferenceRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TutorRepository tutorRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        User user1,user2, user3;
        Preference competitive, grading;
        Category physics, maths;
        Subject thermo, force, calculus, algebra;
        Student student;
        Tutor tutor;
        physics = Category.builder().name("Physics").build();
        maths = Category.builder().name("Mathematics").build();
        thermo = Subject.builder().name("Thermodynamics").build();
        force = Subject.builder().name("Force").build();
        calculus = Subject.builder().name("Calculus").build();
        algebra = Subject.builder().name("Algebra").build();

        physics.getSubjects().add(thermo);
        physics.getSubjects().add(force);
        maths.getSubjects().add(calculus);
        maths.getSubjects().add(algebra);

        calculus.setCategory(maths);
        algebra.setCategory(maths);
        force.setCategory(physics);
        thermo.setCategory(physics);

        categoryRepository.save(physics);
        categoryRepository.save(maths);

        subjectRepository.save(thermo);
        subjectRepository.save(force);
        subjectRepository.save(calculus);
        subjectRepository.save(algebra);

        competitive = Preference.builder().name("Competitive Course").build();
        grading = Preference.builder().name("Grading Course").build();

        preferenceRepository.save(competitive);
        preferenceRepository.save(grading);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authStudent = Authority.builder().name(AuthorityName.ROLE_STUDENT).build();
        Authority authTutor = Authority.builder().name(AuthorityName.ROLE_TUTOR).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        user1 = User.builder()
                .username("student@admin.com")
                .email("student@admin.com")
                .password(encoder.encode("student"))
                .firstname("student1")
                .lastname("student1")
                .displayname("Mock Student")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user2 = User.builder()
                .username("tutor@admin.com")
                .email("tutor@admin.com")
                .password(encoder.encode("tutor"))
                .firstname("tutor")
                .lastname("tutor")
                .displayname("Mock Tutor")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("admin@admin.com")
                .email("admin@admin.com")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .displayname("Administrator")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        student = Student.builder()
                .build();
        tutor = Tutor.builder()
                .build();
        authorityRepository.save(authStudent);
        authorityRepository.save(authTutor);
        authorityRepository.save(authAdmin);
        student.setUser(user1);
        tutor.setUser(user2);
        tutor.getPreferences().add(grading);
        tutor.getSubjects().add(thermo);
        user1.getAuthorities().add(authStudent);
        user1.setStudent(student);
        user2.getAuthorities().add(authTutor);
        user2.setTutor(tutor);
        user3.getAuthorities().add(authAdmin);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        studentRepository.save(student);
        tutorRepository.save(tutor);
    }
}
