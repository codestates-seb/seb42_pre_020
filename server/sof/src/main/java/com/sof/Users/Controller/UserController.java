package com.sof.Users.Controller;

import com.sof.Respone.SingleResponseDto;
import com.sof.Users.Dto.UserPostDto;
import com.sof.Users.Dto.UserResponseDto;
import com.sof.Users.Entity.UserEntity;
import com.sof.Users.Mapper.UserMapper;
import com.sof.Users.Service.UserService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor //-> final 필드 에대한 생성자 생성해주는 어노테이션
@RequestMapping("/users")
@Validated
@Slf4j
public class UserController {
    @Autowired
    private final UserMapper mapper;
    private final UserService userService;


    //회원가입
    @PostMapping("/signup")
    public ResponseEntity postUser(@Valid @RequestBody UserPostDto userPostDto) {
        UserEntity user = mapper.userPostDtoToUser(userPostDto);
        UserEntity createdUser = userService.createUser(user);


        UserResponseDto response = mapper.userToUserResponseDto(createdUser);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED);
    }

    // 회원 정보 전부 출력
    @GetMapping()
    public List<UserResponseDto> userResponseDto() {
        return userService.findAllUsers();
    }

    //개인 회원 profile 요청
    @GetMapping("/{userId}")
    public ResponseEntity getUser(@PathVariable("userId") @Positive Long userId) {
        UserEntity user = userService.findUser(userId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.userToUserResponseDto(user)), HttpStatus.OK
        );
    }

    @GetMapping("/info")
    public String getUser(){
        return  userService.getLoginUser();
    }

    // 회원삭제
    @DeleteMapping("/delete/{user-id}")
    public ResponseEntity deleteUser(@PathVariable("user-id") @Positive Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
