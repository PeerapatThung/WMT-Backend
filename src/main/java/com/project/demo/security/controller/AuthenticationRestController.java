package com.project.demo.security.controller;


import com.project.demo.student.entity.Student;
import com.project.demo.student.repository.StudentRepository;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.project.demo.security.JwtTokenUtil;
import com.project.demo.security.entity.Authority;
import com.project.demo.security.entity.AuthorityName;
import com.project.demo.security.entity.JwtUser;
import com.project.demo.security.entity.User;
import com.project.demo.security.repository.AuthorityRepository;
import com.project.demo.security.repository.UserRepository;
import com.project.demo.util.WMTMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TutorRepository tutorRepository;
    @PostMapping("${jwt.route.authentication.path}")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails, device);
        Map result = new HashMap();
        result.put("token", token);
        User user = userRepository.findById(((JwtUser) userDetails).getId()).orElse(null);
        if(user != null) {
            result.put("user", WMTMapper.INSTANCE.getUserDto(user));
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping(value = "${jwt.route.authentication.refresh}")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/register/{role}")
    public ResponseEntity<?> addUser(@PathVariable(value = "role", required = true) String role,
            @RequestBody JwtAuthenticationRequest authenticationRequest) {
        if(userRepository.findByUsername(authenticationRequest.getUsername()) == null){
            User user = new User();
            if(String.valueOf(role).equals("student")){
                Authority authUser = Authority.builder().name(AuthorityName.ROLE_STUDENT).build();
                authorityRepository.save(authUser);
                user.getAuthorities().add(authUser);
            }
            else if(String.valueOf(role).equals("tutor")){
                Authority authUser = Authority.builder().name(AuthorityName.ROLE_TUTOR).build();
                authorityRepository.save(authUser);
                user.getAuthorities().add(authUser);
            }
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(authenticationRequest.getPassword()));
            user.setEmail(authenticationRequest.getEmail());
            user.setUsername(authenticationRequest.getUsername());
            user.setFirstname(authenticationRequest.getFirstname());
            user.setLastname(authenticationRequest.getLastname());
            user.setDisplayname(authenticationRequest.getDisplayname());
            user.setEnabled(true);
            userRepository.save(user);
            if(String.valueOf(role).equals("student")) {
                Student student = Student.builder()
                        .build();
                student.setUser(user);
                studentRepository.save(student);
            }
            else if(String.valueOf(role).equals("tutor")){
                Tutor tutor = Tutor.builder()
                        .build();
                tutor.setUser(user);
                tutorRepository.save(tutor);
            }
            return ResponseEntity.ok(WMTMapper.INSTANCE.getUserDto(user));

        }
        else return (ResponseEntity<?>) ResponseEntity.badRequest();
    }
}
