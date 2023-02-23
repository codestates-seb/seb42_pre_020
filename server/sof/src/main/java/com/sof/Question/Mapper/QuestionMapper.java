package com.sof.Question.Mapper;

//questionPostDtoToQuestion 기본형식

import com.sof.Answer.Dto.AnswerDto;
import com.sof.Answer.Entity.AnswerEntity;
import com.sof.Question.Dto.QuestionDto;
import com.sof.Question.Entity.QuestionEntity;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    default QuestionEntity questionPostDtoToQuestion(QuestionDto.Post post) {
        if (post == null) { return null; }
        else {
            QuestionEntity question = new QuestionEntity(); //변수선언
            question.setTitle(post.getTitle());
            question.setBody(post.getBody());

            return question;
        }
    }

    default QuestionDto.Response questionToQuestionResponse(QuestionEntity question)
    {
        QuestionDto.Response response = QuestionDto.Response
                .builder()
                .questionId(question.getQuestionId())
                .title(question.getTitle())
                .body(question.getBody())
                .tags(question.getTagStr())
                .isAnswered(question.isAnswered())
                .viewCount(question.getViewCount())
                .answerCount(question.getAnswerCount())
                .score(question.getScore())
                .creat_dt(question.getCrate_dt())
                .update_dt(question.getUpdate_dt())
                .build();
        return response;
    }

    default QuestionDto.QBodyResponse QBodyResponse(QuestionEntity question) {
        List<AnswerEntity> answers = question.getAnswers();

        QuestionDto.QBodyResponse QResponse = new QuestionDto.QBodyResponse();

        QResponse.setQuestionId(question.getQuestionId());
        QResponse.setTitle(question.getTitle());
        QResponse.setBody(question.getBody());
        QResponse.setTags(question.getTagStr());
        QResponse.setOwner(question.getOwner());
        QResponse.setAnswered(question.isAnswered());
        QResponse.setViewCount(question.getViewCount());
        QResponse.setAnswerCount(question.getAnswerCount());
        QResponse.setScore(question.getScore());
        QResponse.setCreateDate(question.getCrate_dt());
        QResponse.setUpdateDate(question.getUpdate_dt());
        QResponse.setAnswers(QAToQAResponse(answers));

        return QResponse;
    }

    //질문 상세 페이지
    default QuestionDto.QDetailResponse QDetailResponse(QuestionEntity question, Boolean write) {
        List<AnswerEntity> answers = question.getAnswers();

        QuestionDto.QDetailResponse QResponse = new QuestionDto.QDetailResponse();

        QResponse.setQuestionId(question.getQuestionId());
        QResponse.setTitle(question.getTitle());
        QResponse.setBody(question.getBody());
        QResponse.setTags(question.getTagStr());
        QResponse.setOwner(question.getOwner());
        QResponse.setAnswered(question.isAnswered());
        QResponse.setViewCount(question.getViewCount());
        QResponse.setAnswerCount(question.getAnswerCount());
        QResponse.setScore(question.getScore());
        QResponse.setCreateDate(question.getCrate_dt());
        QResponse.setUpdateDate(question.getUpdate_dt());
        QResponse.setAnswers(QAToQAResponse(answers));

        return QResponse;
    }

    //질문에 대한 답변
    default List<AnswerDto.Response> QAToQAResponse(List<AnswerEntity> answers) {
        return answers
                .stream()
                .map(questionAnswer -> AnswerDto.Response
                        .builder()
                        .isAccepted(questionAnswer.isAccepted())
                        .score(questionAnswer.getScore())
                        .createDate(questionAnswer.getCreateDate())
                        .answerId(questionAnswer.getAnswerId())
                        .detail(questionAnswer.getDetail())
                        .owner(questionAnswer.getOwner())
                        .build())
                .collect(Collectors.toList());
    }

    default List<QuestionDto.QBodyResponse> QToBodyResponses(List<QuestionEntity> questions){
        if (questions == null) {
            return null;
        } else {
            List<QuestionDto.QBodyResponse> list = new ArrayList(questions.size());
            Iterator var3 = questions.iterator();

            while(var3.hasNext()) {
                QuestionEntity question = (QuestionEntity) var3.next();
                if (question.getBody().length()>190){
                    question.setBody(question.getBody().substring(0,190));
                }
                list.add(this.QBodyResponse(question));
            }
            return list;
        }
    }
}