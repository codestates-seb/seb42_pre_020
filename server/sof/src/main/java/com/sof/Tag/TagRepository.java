package com.sof.Tag;

import com.sof.Tag.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
    Integer countByTag(String tag);
    TagEntity findByTag(String tag);
}
