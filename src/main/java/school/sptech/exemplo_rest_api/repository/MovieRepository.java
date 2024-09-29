package school.sptech.exemplo_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import school.sptech.exemplo_rest_api.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Modifying
    @Query("DELETE FROM Movie m WHERE m.director.id = :directorId")
    void deleteByDirectorId(int directorId);
}
