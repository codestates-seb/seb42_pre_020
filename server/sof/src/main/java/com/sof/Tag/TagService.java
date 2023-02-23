package com.sof.Tag;

import com.sof.Question.Entity.QuestionEntity;
import com.sof.Question.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;

    public TagService(QuestionRepository questionRepository, TagRepository tagRepository) {
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
    }

    //입력받은 스트링(string)을 태그로 변환하고 db에 저장
    public List<TagEntity> stringTags(QuestionEntity question, List<String> tagList) {
        List<TagEntity> tags = new ArrayList<>();

        for(String tagStr : tagList) {
            TagEntity tag = new TagEntity();

            if(this.tagRepository.countByTag(tagStr) == 0) {
                tag = new TagEntity(tagStr, question);
                this.tagRepository.save(tag);
            }
            else {
                tag = tagRepository.findByTag(tagStr);
                List<QuestionEntity> questions = tag.getQuestions();
                questions.add(question);
                tag.setQuestions(questions);
                this.tagRepository.save(tag);
            }
            tags.add(tag);
        }
        return tags;
    }

    public TagEntity stringTag(String tagStr) {
        return this.tagRepository.findByTag(tagStr);
    }

    //질문에서 태그 삭제하기
    public void deleteTagQ(QuestionEntity question) {
        List<TagEntity> tags = question.getTags();

        for(int i = 0; i < tags.size(); i++) {
            TagEntity tag = tags.get(i);

            if(this.questionRepository.countByTags(tag) == 0) { tagRepository.delete(tag); }
        }
    }
}
