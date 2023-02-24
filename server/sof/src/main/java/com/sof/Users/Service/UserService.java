package com.sof.Users.Service;

import com.sof.Exception.BusinessLogicException;
import com.sof.Exception.ExceptionCode;
import com.sof.Security.CustomAuthorityUtils;
import com.sof.Users.Dto.UserResponseDto;
import com.sof.Users.Entity.UserEntity;
import com.sof.Users.Mapper.UserMapper;
import com.sof.Users.Repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, CustomAuthorityUtils authorityUtils, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
        this.userMapper = userMapper;
    }

    public UserEntity createUser(UserEntity user) {

        //등록된 이메일 확인
        verifyExistsEmail(user.getEmail());
        //Password 암호화
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        // DB에 User Role 저장
//        List<String> roles = authorityUtils.createRoles(user.getEmail());
//        user.setRoles(roles);
        return userRepository.save(user);
    }

    public UserEntity findUser(Long userId) {
        return findVerifiedUserById(userId);
    }

    // 전체조회 service
    public List<UserResponseDto> findAllUsers() {
        List<UserEntity> userList = userRepository.findAll();
        List<UserResponseDto> userDtoList = new ArrayList<>();
        for (UserEntity user : userList){
            UserResponseDto userResponseDto = userMapper.userToUserResponseDto(user);
            userDtoList.add(userResponseDto);
        }
        return userDtoList;
    }
    
    public UserEntity getUser(Long userId) {
        Optional<UserEntity> optionalUser = userRepository.findByUserId(userId);
        return optionalUser
                .orElseThrow(() -> new RuntimeException("멤버가 없음"));

    }

    public void deleteUser(Long userId) {
        UserEntity user = findVerifiedUserById(userId);
        verifyUserAuthorization(userId, findUser(user.getUserId()).getUserId());

        userRepository.delete(user);
    }

    private UserEntity findVerifiedUserById(Long userId) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        UserEntity foundUser = optionalUser.orElseThrow(() -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));

        return foundUser;
    }

    public void verifyUserAuthorization(Long authorizedUserId, Long tryingUserId) {
        //user의 권한 확인
        if (!Objects.equals(authorizedUserId, tryingUserId))
            throw new BusinessLogicException(ExceptionCode.UNAUTHORIZED_USER);
    }

    private void verifyExistsEmail(String email) {

        Optional<UserEntity> user = userRepository.findByEmail(email);

        if (user.isPresent())
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
    }

    public String getLoginUser() {
        return getUserByToken();
    }

    public String getUserByToken() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = (String) principal;
        return username;
    }

    public Page<UserEntity> getUsers(Pageable pageable) {
        PageRequest of = PageRequest.of(pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                pageable.getSort());
        return userRepository.findAll(of);
    }
}
