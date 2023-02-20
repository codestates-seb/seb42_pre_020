package com.sof.Users.Service;

import com.sof.Exception.DataNotFoundException;
import com.sof.Exception.UnauthorizedException;
import com.sof.Exception.UserExistsException;
import com.sof.Security.Jwt.JwtTokenizer;
import com.sof.Users.Dto.UserDto;
import com.sof.Users.Entity.UserEntity;
import com.sof.Users.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final JwtTokenizer jwtTokenizer;

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public UserService(UserRepository userRepository, JwtTokenizer jwtTokenizer) {
        this.userRepository = userRepository;
        this.jwtTokenizer = jwtTokenizer;
    }

    public UserEntity create(UserDto.signup dto) {
        //이미 존재하는 이메일 확인
        verifyExistsEmail(dto.getEmail());

        UserEntity user = new UserEntity();
        String encryptedPassword = passwordEncoder.encode(dto.getPassword());

        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(encryptedPassword);
        user.setCreateDate(LocalDateTime.now());

        return this.userRepository.save(user);
    }

    public UserEntity createUser(UserEntity user) {
        return this.userRepository.save(user);
    }

    //회원가입 시 이미 존재하는 이메일인지 확인 후 예외처리
    private void verifyExistsEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent())
            throw new UserExistsException("이미 등록된 이메일입니다!");
    }

    //회원 정보 수정하기 전 로그인 확인 후 진행
    public UserEntity updateUser(UserEntity user, UserDto.update dto) {
        UserDto.login loginDto = new UserDto.login();

        loginDto.setEmail(dto.getEmail());
        loginDto.setPassword(dto.getPassword());

        //비밀번호가 틀린 경우 예외 출력
        if(verifyPassword(loginDto)) {
            throw new UnauthorizedException("사용자 정보가 일치하지 않습니다!");
        }
        user.setName(dto.getName());

        return this.userRepository.save(user);
    }

    //로그인 시 ID 존재여부 확인 후 예외처리
    public UserEntity findByEmail(String email) {
        Optional<UserEntity> findUser = this.userRepository.findByEmail(email);
        if (findUser.isPresent()) {
            return findUser.get();
        } else {
            throw new DataNotFoundException("사용자를 찾을 수 없습니다!");
        }
    }

    //액세스 토큰으로 사용자 찾기
    public UserEntity findByAccessToken(String AccessToken) {
        String jwt = AccessToken.replace("J ", "");
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

        Map<String, Object> claims = jwtTokenizer.getClaims(jwt, base64EncodedSecretKey).getBody();

        String email = (String) claims.get("email");
        UserEntity user = findByEmail(email);

        return user;
    }

    //사용자 정보가 등록된 액세스 토큰 생성
    public String makeAccessToken(UserDto.login dto) {
        String accessToken = "";

        if (verifyPassword(dto)){
            Map<String, Object> claims = new HashMap<>();
            claims.put("email", dto.getEmail());
            claims.put("userId",dto.getPassword());

            String subject = dto.getEmail();

            Date expiration = jwtTokenizer.getTokenExpiration(jwtTokenizer.getAccessTokenExpirationMinutes());

            String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());

            accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        }else{
            accessToken = null;
        }
        return accessToken;
    }

    //사용자 비밀번호에 대한 일치여부 확인
    public boolean verifyPassword(UserDto.login dto) {
        String email = dto.getEmail();
        String password = dto.getPassword();
        UserEntity user = findByEmail(email);

        if(passwordEncoder.matches(password, user.getPassword())) { return true; }

        return false;
    }
}
