package com.project.demo.config;

import com.project.demo.preference.entity.Preference;
import com.project.demo.preference.repository.PreferenceRepository;
import com.project.demo.request.entity.Request;
import com.project.demo.request.entity.RequestStatus;
import com.project.demo.request.repository.RequestRepository;
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

    @Autowired
    RequestRepository requestRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        User user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12,user13;
        Preference competitive, grading;
        Category physics, maths, biology, computer, social, chemistry, languages, others;
        Subject thermo, force, calculus, algebra;
        Student student1,student2,student3,student4,student5;
        Tutor tutor1,tutor2,tutor3,tutor4,tutor5;
        Request request1, request2;

        //Student init
        student1 = Student.builder()
                .description("I'm a very good student")
                .build();
        student2 = Student.builder()
                .description("I'm a student sending request")
                .build();
        student3 = Student.builder()
                .description("I'm a student reviewing tutor")
                .build();
        student4 = Student.builder()
                .description("I'm a student for search and fetch Tutor Request")
                .build();
        student5 = Student.builder()
                .description("I'm a restricted student")
                .active(false)
                .build();

        //Tutor init
        tutor1 = Tutor.builder()
                .description("I'm a very good tutor")
                .build();
        tutor2 = Tutor.builder()
                .description("I'm a tutor receiving request")
                .build();
        tutor3 = Tutor.builder()
                .description("I'm a tutor being reviewed")
                .build();
        tutor4 = Tutor.builder()
                .description("I'm a tutor for search and fetch Tutor Request")
                .build();
        tutor5 = Tutor.builder()
                .description("I'm a restricted tutor")
                .active(false)
                .build();

        //Request init
        request1 = Request.builder()
                .message("This is a test request")
                .reply("This is a test reply")
                .status(RequestStatus.Rejected)
                .build();
        request2 = Request.builder()
                .message("This is also a test request")
                .status(RequestStatus.Pending)
                .build();
        request1.setTutor(tutor4);
        request1.setStudent(student4);
        request2.setTutor(tutor4);
        request2.setStudent(student2);
        requestRepository.save(request1);
        requestRepository.save(request2);

        //Category + subject init
        physics = Category.builder().name("Physics").build();
        maths = Category.builder().name("Mathematics").build();
        biology = Category.builder().name("Biology").build();
        computer = Category.builder().name("Computer").build();
        social = Category.builder().name("Social Studies").build();
        chemistry = Category.builder().name("Chemistry").build();
        languages = Category.builder().name("Languages").build();
        others = Category.builder().name("Others").build();

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
        categoryRepository.save(biology);
        categoryRepository.save(computer);
        categoryRepository.save(social);
        categoryRepository.save(chemistry);
        categoryRepository.save(languages);
        categoryRepository.save(others);

        thermo.getTutors().add(tutor1);
        subjectRepository.save(thermo);
        subjectRepository.save(force);
        subjectRepository.save(calculus);
        subjectRepository.save(algebra);

        //Preferences init
        competitive = Preference.builder().name("Competitive Course").build();
        grading = Preference.builder().name("Grading Course").build();

        preferenceRepository.save(competitive);
        grading.getTutors().add(tutor1);
        preferenceRepository.save(grading);
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        //Authorities
        Authority authStudent = Authority.builder().name(AuthorityName.ROLE_STUDENT).build();
        Authority authTutor = Authority.builder().name(AuthorityName.ROLE_TUTOR).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();

        //Mock Users Creation Zone
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
        user4 = User.builder()
                .username("request@student.com")
                .email("request@student.com")
                .password(encoder.encode("student"))
                .firstname("John")
                .lastname("Doe")
                .displayname("StudentTest1")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user5 = User.builder()
                .username("review@student.com")
                .email("review@student.com")
                .password(encoder.encode("student"))
                .firstname("Johnny")
                .lastname("Eod")
                .displayname("StudentTest2")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user6 = User.builder()
                .username("search@student.com")
                .email("search@student.com")
                .password(encoder.encode("student"))
                .firstname("Jon")
                .lastname("Ode")
                .displayname("StudentTest3")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user7 = User.builder()
                .username("request@tutor.com")
                .email("request@tutor.com")
                .password(encoder.encode("tutor"))
                .firstname("Nok")
                .lastname("Krajib")
                .displayname("TutorTest1")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user8 = User.builder()
                .username("review@tutor.com")
                .email("review@tutor.com")
                .password(encoder.encode("tutor"))
                .firstname("Kai")
                .lastname("Kukkuk")
                .displayname("TutorTest2")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user9 = User.builder()
                .username("search@tutor.com")
                .email("search@tutor.com")
                .password(encoder.encode("tutor"))
                .firstname("Moo")
                .lastname("Oodood")
                .displayname("TutorTest3")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user10 = User.builder()
                .username("restricted@student.com")
                .email("restricted@student.com")
                .password(encoder.encode("banned"))
                .firstname("baddie")
                .lastname("student")
                .displayname("StudentTest4")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user11 = User.builder()
                .username("restricted@tutor.com")
                .email("restricted@tutor.com")
                .password(encoder.encode("banned"))
                .firstname("baddie")
                .lastname("tutor")
                .displayname("TutorTest4")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user12 = User.builder()
                .username("user1@user.com")
                .email("user1@user.com")
                .password(encoder.encode("password"))
                .firstname("test")
                .lastname("user")
                .displayname("UserTest1")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user13 = User.builder()
                .username("user2@user.com")
                .email("user2@user.com")
                .password(encoder.encode("password"))
                .firstname("test2")
                .lastname("user")
                .displayname("UserTest2")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        authorityRepository.save(authStudent);
        authorityRepository.save(authTutor);
        authorityRepository.save(authAdmin);

        student1.setUser(user1);
        student2.setUser(user4);
        student3.setUser(user5);
        student4.setUser(user6);
        student5.setUser(user10);
        tutor1.setUser(user2);
        tutor2.setUser(user7);
        tutor3.setUser(user8);
        tutor4.setUser(user9);
        tutor5.setUser(user11);
        tutor1.getPreferences().add(grading);
        tutor1.getSubjects().add(thermo);
        tutor4.getPreferences().add(competitive);
        tutor4.getSubjects().add(calculus);
        tutor4.getRequests().add(request1);
        tutor4.getRequests().add(request2);
        student4.getRequests().add(request1);
        student2.getRequests().add(request2);
        tutor3.getStudents().add(student3);
        user1.getAuthorities().add(authStudent);
        user1.setStudent(student1);
        user2.getAuthorities().add(authTutor);
        user2.setTutor(tutor1);
        user3.getAuthorities().add(authAdmin);
        user4.getAuthorities().add(authStudent);
        user4.setStudent(student2);
        user5.getAuthorities().add(authStudent);
        user5.setStudent(student3);
        user6.getAuthorities().add(authStudent);
        user6.setStudent(student4);
        user7.getAuthorities().add(authTutor);
        user7.setTutor(tutor2);
        user8.getAuthorities().add(authTutor);
        user8.setTutor(tutor3);
        user9.getAuthorities().add(authTutor);
        user9.setTutor(tutor4);
        user10.getAuthorities().add(authStudent);
        user10.setStudent(student5);
        user11.getAuthorities().add(authTutor);
        user11.setTutor(tutor5);
        user12.getAuthorities().add(authStudent);
        user13.getAuthorities().add(authTutor);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user9);
        userRepository.save(user10);
        userRepository.save(user11);
        userRepository.save(user12);
        userRepository.save(user13);
        studentRepository.save(student1);
        studentRepository.save(student2);
        tutorRepository.save(tutor1);
        tutorRepository.save(tutor2);
        tutorRepository.save(tutor3);
        tutorRepository.save(tutor4);
        tutorRepository.save(tutor5);
        student3.getTutors().add(tutor3);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);   
    }
}
