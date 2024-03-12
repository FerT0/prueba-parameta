package com.parameta.prueba.controllers.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgregarEmpleadoDTO {

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombres;

    @NotBlank(message = "El apellido no puede estar vacío.")
    private String apellidos;

    @NotBlank(message = "El tipo de documento no puede estar vacío.")
    private String tipo_documento;

    @NotBlank(message = "El número de documento no puede estar vacío.")
    private String numero_documento;

    @Past(message = "La fecha de nacimiento debe estar en pasado.")
    @NotNull(message = "La fecha de nacimiento no puede estar vacía.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_nacimiento;

    @Past(message = "La fecha de nacimiento debe estar en pasado.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha de vinculación no puede estar vacía.")
    private LocalDate fecha_vinculacion;

    @NotBlank(message = "El cargo no puede estar vacío.")
    private String cargo;

    @NotNull(message = "El salario no puede estar vacío.")
    private Double salario;

}
