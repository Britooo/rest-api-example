package school.sptech.exemplo_rest_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import school.sptech.exemplo_rest_api.dto.DirectorRequestDto;
import school.sptech.exemplo_rest_api.dto.DirectorResponseDto;
import school.sptech.exemplo_rest_api.entity.Director;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DirectorMapper {

    Director toEntity(DirectorRequestDto dto);

    DirectorResponseDto toDto(Director entity);
}
