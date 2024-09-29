package school.sptech.exemplo_rest_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import school.sptech.exemplo_rest_api.dto.DirectorRequestDto;
import school.sptech.exemplo_rest_api.dto.DirectorResponseDto;
import school.sptech.exemplo_rest_api.entity.Director;
import school.sptech.exemplo_rest_api.mapper.DirectorMapper;
import school.sptech.exemplo_rest_api.service.DirectorService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/directors")
public class DirectorController {

    private final DirectorMapper directorMapper;
    private final DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<DirectorResponseDto>> findAll() {
        List<Director> directors = directorService.findAll();

        if (directors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<DirectorResponseDto> dtos = directors.stream()
                .map(directorMapper::toDto)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorResponseDto> findById(@PathVariable Integer id) {
        Director director = directorService.findById(id);

        if (director == null) {
            return ResponseEntity.notFound().build();
        }

        DirectorResponseDto dto = directorMapper.toDto(director);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DirectorResponseDto> save(
            @RequestBody @Valid DirectorRequestDto dto
    ) {
        Director director = directorMapper.toEntity(dto);
        Director saved = directorService.save(director);
        DirectorResponseDto responseDto = directorMapper.toDto(saved);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(responseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        directorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
