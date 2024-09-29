package school.sptech.exemplo_rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.exemplo_rest_api.entity.Director;
import school.sptech.exemplo_rest_api.entity.Movie;
import school.sptech.exemplo_rest_api.exception.EntityNotFoundException;
import school.sptech.exemplo_rest_api.repository.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(int id) {
        return movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie not found"));
    }

    public Movie save(Movie movie, int directorId) {
        Director byId = directorService.findById(directorId);
        movie.setDirector(byId);
        return movieRepository.save(movie);
    }

    public void delete(int id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Movie not found");
        }
    }
}
