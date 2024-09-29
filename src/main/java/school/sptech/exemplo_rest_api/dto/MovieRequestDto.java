package school.sptech.exemplo_rest_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "DTO para solicitar a criação de um novo filme")
public class MovieRequestDto {

    @NotBlank
    @Schema(description = "Nome do filme", example = "Jurassic Park")
    private String name;

    @NotBlank
    @Schema(description = "Gênero do filme", example = "Adventure")
    private String genre;

    @Past
    @NotNull
    @Schema(description = "Data de lançamento do filme, deve ser uma data passada", example = "1993-06-11")
    private LocalDate releaseDate;

    @NotNull
    @DecimalMax("10")
    @DecimalMin("0")
    @Schema(description = "Classificação do filme, deve ser um valor entre 0 e 10", example = "8.2")
    private Double rating;

    @NotNull
    @Positive
    @Schema(description = "ID do diretor responsável pelo filme", example = "1")
    private Integer directorId;
}
