package com.project.demo.forum.service;

import com.project.demo.forum.dao.QADao;
import com.project.demo.forum.entity.Answer;
import com.project.demo.forum.entity.ForumStatus;
import com.project.demo.forum.entity.Posts;
import com.project.demo.forum.entity.Question;
import com.project.demo.forum.repository.PostRepository;
import com.project.demo.request.entity.Request;
import com.project.demo.request.entity.RequestStatus;
import com.project.demo.student.dao.StudentDao;
import com.project.demo.student.entity.Student;
import com.project.demo.subject.entity.Category;
import com.project.demo.subject.repository.CategoryRepository;
import com.project.demo.tutor.dao.TutorDao;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class QAServiceImpl implements QAService{
    @Autowired
    QADao qaDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    TutorDao tutorDao;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    TutorRepository tutorRepository;
    @Override
    public Page<Question> getAllQuestions(Integer page, Integer pageSize) {
        return qaDao.getAllQuestions(page, pageSize);
    }

    @Override
    public Page<Question> getQuestionsByCategory(Long categoryid, Integer page, Integer pageSize) {
        if(categoryid == null){
            return qaDao.getAllQuestions(page, pageSize);
        }
        else return qaDao.getQuestionsByCategory(categoryid,page,pageSize);
    }

    @Override
    public List<Answer> getAnswers(Long questionid) {
        return qaDao.getAnswers(questionid);
    }

    @Override
    public Question askQuestion(Long studentid, Question question) {
        Student studentAsking = studentDao.getStudent(studentid);
        Category category = categoryRepository.findById(question.getCategory().getId()).orElse(null);
        Question newQuestion = Question.builder()
                .title(question.getTitle())
                .description(question.getDescription())
                .build();
        category.getQuestions().add(newQuestion);
        studentAsking.setRewardPoints(studentAsking.getRewardPoints() + 1);
//        studentAsking.getQuestions().add(newQuestion);
        newQuestion.setStudent(studentAsking);
        newQuestion.setCategory(category);
        return qaDao.askQuestion(studentAsking, newQuestion);
    }

    @Override
    public Answer answerQuestion(Long tutorid, Long questionid, Answer answer) {
        Tutor tutorAnswering = tutorDao.getTutor(tutorid);
        Question question = qaDao.getQuestion(questionid);
        Answer answer1 = Answer.builder()
                .description(answer.getDescription())
                .build();
        tutorAnswering.setRewardPoints(tutorAnswering.getRewardPoints() +1);
        tutorAnswering.getAnswers().add(answer1);
        answer1.setTutor(tutorAnswering);
        question.getAnswers().add(answer1);
        answer1.setQuestion(question);
        return qaDao.answerQuestion(tutorAnswering, questionid, answer1);
    }

//    @Override
//    public Question resolveQuestion(Question question, Long answerid) {
//        Question question1 = qaDao.getQuestion(question.getId());
//        Answer answer = qaDao.getAnswer(question.getId());
//
//        question1.setStatus(ForumStatus.Resolved);
//        answer.setStatus(ForumStatus.Resolved);
//        return qaDao.resolveQuestion(question1, answer);
//    }
//
//    @Override
//    public Question lockQuestion(Question question) {
//        Question question1 = qaDao.getQuestion(question.getId());
//
//        question1.setStatus(ForumStatus.Locked);
//        return qaDao.lockQuestion(question1);
//    }

    @Override
    public Question getQuestion(Long questionid) {
        return qaDao.getQuestion(questionid);
    }

    @Override
    public Answer voteAnswer(Long studentid, Answer answer, Question question) {
        Answer answer1 = qaDao.getAnswer(answer.getId());
        Student student = studentDao.getStudent(studentid);
        Question question1 = qaDao.getQuestion(question.getId());
        Tutor tutor = tutorDao.getTutor(answer1.getTutor().getId());

        student.getVotes().add(answer1);
        student.setRewardPoints(student.getRewardPoints() + 1);
        answer1.getVotedBy().add(student);
        if(question1.getStudent().getId() == studentid){
            answer1.setVotes(answer1.getVotes()+3);
            tutor.setRewardPoints(tutor.getRewardPoints()+3);
        }
        else {
            answer1.setVotes(answer1.getVotes()+1);
            tutor.setRewardPoints(tutor.getRewardPoints()+1);
        }
        return qaDao.voteAnswer(student, tutor, answer1);
    }

    @Override
    public Posts updatePost(Long tutorid, Posts post) {
        Tutor tutorToPost = tutorDao.getTutor(tutorid);
        if(tutorToPost.getPosts() == null){
            Posts newPost = Posts.builder()
                    .description(post.getDescription()).build();
            newPost.setTutor(tutorToPost);
            tutorToPost.setRewardPoints(tutorToPost.getRewardPoints() + 20);
            tutorRepository.save(tutorToPost);
            return qaDao.updatePost(newPost);
        }
        else {
            Posts postToUpdate = postRepository.findById(tutorToPost.getPosts().getId()).orElse(null);
            postToUpdate.setDescription(post.getDescription());
            postToUpdate.setLastOpened(LocalDateTime.now(ZoneId.of("GMT+07")));
            postToUpdate.setStatus(ForumStatus.Open);
            tutorToPost.setRewardPoints(tutorToPost.getRewardPoints() + 10);
            tutorRepository.save(tutorToPost);
            return qaDao.updatePost(postToUpdate);
        }
    }

    @Override
    public Posts closePost(Posts post) {
        Posts postToClose = postRepository.findById(post.getId()).orElse(null);
        postToClose.setDescription(post.getDescription());
        postToClose.setStatus(ForumStatus.Closed);
        return qaDao.closePost(postToClose);
    }

    @Override
    public Page<Posts> getPosts(Integer page, Integer pageSize) {
        return qaDao.getPosts(page, pageSize);
    }
}
