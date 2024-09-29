package school.sptech.exemplo_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exemplo_rest_api.entity.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
