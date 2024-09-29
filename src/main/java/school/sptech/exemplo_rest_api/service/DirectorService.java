package school.sptech.exemplo_rest_api.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.exemplo_rest_api.entity.Director;
import school.sptech.exemplo_rest_api.exception.EntityNotFoundException;
import school.sptech.exemplo_rest_api.repository.DirectorRepository;
import school.sptech.exemplo_rest_api.repository.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    public Director findById(int id) {
        return directorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Director not found"));
    }

    public Director save(Director director) {
        return directorRepository.save(director);
    }

    @Transactional
    public void delete(int id) {
        if (directorRepository.existsById(id)) {
            movieRepository.deleteByDirectorId(id);
            directorRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Director not found");
        }
    }
}
