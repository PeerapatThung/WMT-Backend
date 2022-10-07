package com.project.demo.forum.dao;

import com.project.demo.forum.entity.Answer;
import com.project.demo.forum.entity.Posts;
import com.project.demo.forum.entity.Question;
import com.project.demo.forum.repository.AnswerRepository;
import com.project.demo.forum.repository.PostRepository;
import com.project.demo.forum.repository.QuestionRepository;
import com.project.demo.student.entity.Student;
import com.project.demo.student.repository.StudentRepository;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QADaoImpl implements QADao{
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TutorRepository tutorRepository;

    @Autowired
    PostRepository postRepository;
    @Override
    public Page<Question> getAllQuestions(Integer page, Integer pageSize) {
        return questionRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public Page<Question> getQuestionsByCategory(Long categoryid, Integer page, Integer pageSize) {
        return questionRepository.findByCategory_Id(categoryid, PageRequest.of(page-1,pageSize));
    }

    @Override
    public List<Answer> getAnswers(Long questionid) {
        return answerRepository.findByQuestion_Id(questionid);
    }

    @Override
    public Question askQuestion(Student student, Question question) {
        studentRepository.save(student);
        return questionRepository.save(question);
    }

    @Override
    public Answer answerQuestion(Tutor tutor, Long questionid, Answer answer) {
        tutorRepository.save(tutor);
        return answerRepository.save(answer);
    }

    @Override
    public Question resolveQuestion(Question question, Answer answer) {
        answerRepository.save(answer);
        return questionRepository.save(question);
    }

    @Override
    public Question lockQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Answer getAnswer(Long id) {
        return answerRepository.findById(id).orElse(null);
    }

    @Override
    public Answer voteAnswer(Student student, Tutor tutor, Answer answer) {
        studentRepository.save(student);
        tutorRepository.save(tutor);
        return answerRepository.save(answer);
    }

    @Override
    public Posts updatePost(Posts post) {
        return postRepository.save(post);
    }

    @Override
    public Posts closePost(Posts post) {
        return postRepository.save(post);
    }

    @Override
    public Page<Posts> getPosts(Integer page, Integer pageSize) {
        return postRepository.findAll(PageRequest.of(page-1,pageSize,Sort.by("lastOpened").descending()));
    }
}
