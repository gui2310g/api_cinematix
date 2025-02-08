package com.example.api_cinematix.dto.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class UserRequest {
    private long id;

    private String username;

    private String password;

    private String email;

    private Date created_at;
}
