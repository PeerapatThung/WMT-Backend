package com.project.demo.config;

import com.project.demo.security.entity.Authority;
import com.project.demo.security.entity.AuthorityName;
import com.project.demo.security.entity.User;
import com.project.demo.security.repository.UserRepository;
import com.project.demo.student.entity.Student;
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

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        User user1,user2;
        Student student,student2;
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authStudent = Authority.builder().name(AuthorityName.ROLE_STUDENT).build();
        Authority authTutor = Authority.builder().name(AuthorityName.ROLE_TUTOR).build();
        user1 = User.builder()
                .username("student1")
                .email("student1@admin.com")
                .password(encoder.encode("student1"))
                .firstname("student1")
                .lastname("student1")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user2 = User.builder()
                .username("student2")
                .email("student2@admin.com")
                .password(encoder.encode("student2"))
                .firstname("student2")
                .lastname("student2")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        student = Student.builder()
                .name(user1.getFirstname())
                .money(200.00)
                .buyLimit(5)
                .coinAmount(5).build();
        student2 = Student.builder()
                .name(user2.getFirstname())
                .money(200.00)
                .buyLimit(5)
                .coinAmount(10).build();
        authorityRepository.save(authUser);
        student.setAccount(user1);
        student2.setAccount(user2);
        user1.setMember(student);
        user1.getAuthorities().add(authUser);
        user2.setMember(student2);
        user2.getAuthorities().add(authUser);
        userRepository.save(user1);
        userRepository.save(user2);
        studentRepository.save(student);
        studentRepository.save(student2);
        coinStockRepository.save(stock);
    }
}
