package school.sptech.exemplo_rest_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import school.sptech.exemplo_rest_api.dto.MovieRequestDto;
import school.sptech.exemplo_rest_api.dto.MovieResponseDto;
import school.sptech.exemplo_rest_api.entity.Movie;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieMapper {

    Movie toEntity(MovieRequestDto dto);

    MovieResponseDto toDto(Movie entity);
}
