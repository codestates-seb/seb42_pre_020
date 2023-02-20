package com.sof.Users.Mapper;

import com.sof.Users.Dto.UserDto;
import com.sof.Users.Entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    default UserDto.response userToUserResponseDto(UserEntity user){
        UserDto.response response = new UserDto.response(
                user.getUserId(),
                user.getEmail(),
                user.getName(),
                user.getCreateDate()
        );
        return response;
    }

    default UserDto.accessTokenResponse accessTokenToUserResponseDto(UserEntity user, String accessToken) {
        UserDto.accessTokenResponse response = new UserDto.accessTokenResponse(
                accessToken,
                user.getUserId(),
                user.getEmail(),
                user.getName()
        );
        return response;
    }
}
