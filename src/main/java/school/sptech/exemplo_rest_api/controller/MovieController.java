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
import school.sptech.exemplo_rest_api.dto.MovieRequestDto;
import school.sptech.exemplo_rest_api.dto.MovieResponseDto;
import school.sptech.exemplo_rest_api.entity.Movie;
import school.sptech.exemplo_rest_api.mapper.MovieMapper;
import school.sptech.exemplo_rest_api.service.MovieService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieMapper movieMapper;
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponseDto> save(
            @RequestBody @Valid MovieRequestDto dto
    ) {
        Movie movie = movieMapper.toEntity(dto);
        Movie saved = movieService.save(movie, dto.getDirectorId());
        MovieResponseDto responseDto = movieMapper.toDto(saved);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> findAll() {
        List<Movie> movies = movieService.findAll();

        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<MovieResponseDto> dtos = movies.stream()
                .map(movieMapper::toDto)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> findById(@PathVariable Integer id) {
        Movie movie = movieService.findById(id);
        MovieResponseDto dto = movieMapper.toDto(movie);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
