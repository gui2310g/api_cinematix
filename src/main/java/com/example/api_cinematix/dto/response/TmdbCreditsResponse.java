package com.example.api_cinematix.dto.response;

import com.example.api_cinematix.domain.model.Actor;
import lombok.Data;

@Data
public class TmdbCreditsResponse {
    private String id;
    private Actor[] cast;
}
