package com.sof.Users.Controller;

import com.sof.Exception.InvalidPasswordException;
import com.sof.Exception.UnauthorizedException;
import com.sof.Users.Entity.UserEntity;
import com.sof.Users.Mapper.UserMapper;
import com.sof.Users.Dto.UserDto;
import com.sof.Users.Repository.UserRepository;
import com.sof.Users.Service.UserService;
import com.sof.Users.exception.BusinessLogicException;
import com.sof.Users.exception.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity signup(@Validated @RequestBody UserDto.signup dto) {
        userService.create(dto);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity login(@Validated @RequestBody UserDto.login dto) {
        String accessToken = "bearer " + userService.makeAccessToken(dto);
        //ID 존재 여부 확인
        UserEntity user = userService.findByEmail(dto.getEmail());

        if (accessToken == null) {
            throw new InvalidPasswordException("비밀번호가 틀렸습니다!");
        } else {
            UserDto.accessTokenResponse response = mapper.accessTokenToUserResponseDto(user, accessToken);

            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    //회원정보 조회
    @GetMapping("/profile/{userId}")
    public ResponseEntity getProfile(@RequestHeader(value = "accessToken") String accessToken) {
        if (accessToken.equals("not")) {
            throw new UnauthorizedException("로그인이 필요합니다!");
        }

        UserEntity user = this.userService.findByAccessToken(accessToken);

        UserDto.response response = this.mapper.userToUserResponseDto(user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //회원정보 수정
    @PatchMapping("/profile/{userId}/edit")
    public ResponseEntity updateProfile(@RequestHeader(value = "accessToken") String accessToken,
                                       @RequestBody UserDto.update dto) {
        if (accessToken.equals("not")) {
            throw new UnauthorizedException("로그인이 필요합니다!");
        }
        UserEntity user = this.userService.findByAccessToken(accessToken);
        UserEntity updateUser = userService.updateUser(user, dto);

        UserDto.response response = this.mapper.userToUserResponseDto(updateUser);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity get(@Validated @RequestBody String accessToken) {
        UserEntity user = userService.findByAccessToken(accessToken);

        return new ResponseEntity(mapper.userToUserResponseDto(user), HttpStatus.OK);
    }
}
