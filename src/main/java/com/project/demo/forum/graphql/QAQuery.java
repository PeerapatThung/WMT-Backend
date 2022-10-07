package com.project.demo.forum.graphql;

import com.project.demo.forum.dto.AnswerDTO;
import com.project.demo.forum.dto.QuestionDTO;
import com.project.demo.forum.entity.Posts;
import com.project.demo.forum.entity.Question;
import com.project.demo.forum.service.QAService;
import com.project.demo.request.dto.RequestDTO;
import com.project.demo.request.entity.Request;
import com.project.demo.request.service.RequestService;
import com.project.demo.subject.entity.Category;
import com.project.demo.util.QueryFilter;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class QAQuery implements GraphQLQueryResolver {
    @Autowired
    QAService qaService;

    @Transactional
    Page<Question> getQuestions(Long categoryid, QueryFilter queryFilter) {
        return qaService.getQuestionsByCategory(categoryid,  queryFilter.getPageNo(), queryFilter.getPageSize());
    }

    @Transactional
    List<AnswerDTO> getAnswers(Long questionid) {
        return WMTMapper.INSTANCE.getAnswersDTO(qaService.getAnswers(questionid));
    }

    @Transactional
    Question getQuestion(Long questionid) {
        return qaService.getQuestion(questionid);
    }

    @Transactional
    Page<Posts> getPosts(QueryFilter queryFilter) {
        return qaService.getPosts(queryFilter.getPageNo(), queryFilter.getPageSize());
    }
}
