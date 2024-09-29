package school.sptech.exemplo_rest_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "DTO para criar um novo diretor")
public class DirectorRequestDto {

    @NotBlank
    @Schema(description = "Nome do diretor", example = "Steven Spielberg")
    private String name;

    @Past
    @Schema(description = "Data de nascimento do diretor, deve ser uma data passada", example = "1946-12-18")
    private LocalDate birthDate;

    @Schema(description = "Indica se o diretor está vivo", example = "true")
    private boolean isAlive;

    @Schema(description = "Indica se o diretor já ganhou um Oscar", example = "true")
    private boolean isOscarWinner;
}
