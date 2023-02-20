package com.sof.Users.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId; //회원 ID -> 관리를 위한 회원 ID

    @Column(nullable = false)
    private String email; //회원 Email

    @Column
    private String name; //회원 닉네임

    @Column(length = 100, nullable = false)
    private String password; //회원 비밀번호

    @Column(name = "create_dt")
    private LocalDateTime createDate; //회원 생성 날짜

    public enum UserStatus {
        USER_ACTIVE("활동중"),
        USER_SLEEP("휴면상태"),
        USER_DELETE("탈퇴");

        private String status; //회원 상태

        UserStatus(String status) {
            this.status = status;
        }
    }
}
