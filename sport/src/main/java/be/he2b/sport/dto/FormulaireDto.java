package be.he2b.sport.dto;

import java.time.LocalDate;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormulaireDto {

    @NotBlank
    private String sportName;

    @Future(message = "il faut choisir une date après celle à ce jour")
    @NotNull
    private LocalDate date;
    @Pattern(regexp = "^(.+)@(\\S+)$", message = "il faut introduire un email de la forme text@text.com")
    @NotBlank()
    private String email;
}
