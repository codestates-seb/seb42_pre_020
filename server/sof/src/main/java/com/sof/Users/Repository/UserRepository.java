package com.sof.Users.Repository;

import com.sof.Users.Entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findByEmail(String email);

    public Optional<UserEntity> findByUserId(Long userId);

    public UserEntity findByEmailAndPassword(String email, String password);

    @Query(value = "SELECT email FROM user WHERE user.active != true",nativeQuery = true)
    public UserEntity getOnlyClosedUser(@Param("email") String email);

    Page<UserEntity> findAll(Pageable pageable);
}
