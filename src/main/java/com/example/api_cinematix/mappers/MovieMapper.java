package com.example.api_cinematix.mappers;

import com.example.api_cinematix.domain.model.Movie;
import com.example.api_cinematix.dto.request.MovieRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {

        MovieRequest toRequest(Movie movie);
        Movie toEntity(MovieRequest movieRequest);
}
