package com.sof.Users.Mapper;

import java.util.List;

import com.sof.Users.Dto.*;
import com.sof.Users.Entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    UserEntity userPostDtoToUser(UserPostDto userPostDto);
    UserEntity userPatchDtoToUser(UserPatchDto userPatchDto);

    UserEntity userLoginDtoToUser(UserLoginDto userLoginDto);
    //UserEntity userEmailDtoToUser(UserEmailDto userEmailDto);
    UserResponseDto userToUserResponseDto(UserEntity user);

    //회원 전체 조회User
    List<UserResponseDto> userListToUserResponseDtoList(List<UserEntity> userEntityList);
}