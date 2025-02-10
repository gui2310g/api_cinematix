package com.example.api_cinematix.domain.service;

import com.example.api_cinematix.domain.exception.ResourceBadRequestException;
import com.example.api_cinematix.domain.exception.ResourceNotFoundException;
import com.example.api_cinematix.domain.model.User;
import com.example.api_cinematix.domain.model.movieDetails.Movie;
import com.example.api_cinematix.domain.repository.UserRepository;
import com.example.api_cinematix.dto.request.MovieRequest;
import com.example.api_cinematix.dto.request.UserRequest;
import com.example.api_cinematix.mappers.UserMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserRequest createUser(UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent())
            throw new ResourceBadRequestException("This email still exists");

        if (userRepository.findByUsername(userRequest.getUsername()).isPresent())
            throw new ResourceBadRequestException("This username still exists");

        User user = userMapper.toEntity(userRequest);
        user.setCreated_at(new Date());
        User createdUser = userRepository.save(user);
        return userMapper.toRequest(createdUser);
    }

    public List<UserRequest> findAll()  {
        return userRepository.findAll().stream().map(userMapper::toRequest).toList();
    }

    public UserRequest findById(Long id) {
        return userRepository.findById(id).map(userMapper::toRequest)
                .orElseThrow(() -> new ResourceNotFoundException("Not found a user with id " + id));
    }

    public UserRequest updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found a user with id " + id));

        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        User updatedUser = userRepository.save(user);
        return userMapper.toRequest(updatedUser);
    }

    public void delete(Long id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found a user with id" + id));
        userRepository.deleteById(id);
    }
}
