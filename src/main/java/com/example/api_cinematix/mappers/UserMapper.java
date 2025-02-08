package com.example.api_cinematix.mappers;

import com.example.api_cinematix.domain.model.User;
import com.example.api_cinematix.dto.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserRequest toRequest(User user);

    User toEntity(UserRequest userRequest);
}
