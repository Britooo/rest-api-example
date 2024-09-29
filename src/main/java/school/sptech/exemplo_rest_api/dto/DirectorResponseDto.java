package school.sptech.exemplo_rest_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Schema(description = "DTO que representa a resposta de um diretor com suas informações e filmes")
public class DirectorResponseDto {

    @Schema(description = "ID único do diretor", example = "1")
    private int id;

    @Schema(description = "Nome do diretor", example = "Steven Spielberg")
    private String name;

    @Schema(description = "Data de nascimento do diretor", example = "1946-12-18")
    private LocalDate birthDate;

    @Schema(description = "Indica se o diretor está vivo", example = "true")
    private boolean isAlive;

    @Schema(description = "Indica se o diretor já ganhou um Oscar", example = "true")
    private boolean isOscarWinner;

    @Schema(description = "Lista de filmes dirigidos pelo diretor")
    private List<MovieDirectorResponseDto> movies;

    @Data
    @Schema(description = "DTO que representa os filmes de um diretor")
    public static class MovieDirectorResponseDto {

        @Schema(description = "ID único do filme", example = "10")
        private int id;

        @Schema(description = "Nome do filme", example = "Jurassic Park")
        private String name;

        @Schema(description = "Gênero do filme", example = "Adventure")
        private String genre;

        @Schema(description = "Data de lançamento do filme", example = "1993-06-11")
        private LocalDate releaseDate;

        @Schema(description = "Classificação do filme", example = "8.2")
        private Double rating;
    }
}
