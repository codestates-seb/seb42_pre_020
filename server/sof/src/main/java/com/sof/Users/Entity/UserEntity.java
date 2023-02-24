package com.sof.Users.Entity;

import com.sof.baseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter
    private Long userId; //회원 ID -> 관리를 위한 회원 ID

    @Column(nullable = false)
    private String email; //회원 Email

    @Column
    private String name; //회원 닉네임

    @Column(length = 100, nullable = false)
    private String password; //회원 비밀번호


    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public enum UserStatus {
        USER_EXIST("이미 가입한 회원"),
        USER_NOT_EXIST("가입하지 않은 회원");

        @Getter
        private String status;

        UserStatus(String status) {
            this.status = status;
        }
    }
}
