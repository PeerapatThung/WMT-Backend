package com.project.demo.forum.graphql;

import com.project.demo.forum.dto.AnswerDTO;
import com.project.demo.forum.dto.QuestionDTO;
import com.project.demo.forum.entity.Answer;
import com.project.demo.forum.entity.Question;
import com.project.demo.forum.service.QAService;
import com.project.demo.request.dto.RequestDTO;
import com.project.demo.request.entity.Request;
import com.project.demo.request.service.RequestService;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QAMutation implements GraphQLMutationResolver{
    @Autowired
    QAService qaService;

    public Question askQuestion(Long studentid, Question question){
        return qaService.askQuestion(studentid, question);
    }

    public QuestionDTO resolveQuestion(Question question, Long answerid){
        Question questionToSolve = qaService.resolveQuestion(question, answerid);
        return WMTMapper.INSTANCE.getQuestionDTO(questionToSolve);
    }

    public QuestionDTO lockQuestion(Question question){
        Question questionToLock = qaService.lockQuestion(question);
        return WMTMapper.INSTANCE.getQuestionDTO(questionToLock);
    }

    public AnswerDTO answerQuestion(Long tutorid, Long questionid, Answer answer){
        Answer answer1 = qaService.answerQuestion(tutorid,questionid,answer);
        return WMTMapper.INSTANCE.getAnswerDTO(answer1);
    }

    public AnswerDTO voteAnswer(Long studentid, Answer answer, Question question){
        Answer answer1 = qaService.voteAnswer(studentid, answer, question);
        return WMTMapper.INSTANCE.getAnswerDTO(answer1);
    }


}
