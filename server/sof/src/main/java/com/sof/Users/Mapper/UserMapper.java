package com.sof.Users.Mapper;

import com.sof.Users.Dto.*;
import com.sof.Users.Entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity userPostDtoToUser(UserPostDto userPostDto);
    UserEntity userPatchDtoToUser(UserPatchDto userPatchDto);

    UserEntity userLoginDtoToUser(UserLoginDto userLoginDto);
    //UserEntity userEmailDtoToUser(UserEmailDto userEmailDto);
    UserResponseDto userToUserResponseDto(UserEntity user);
}
