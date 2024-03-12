package com.parameta.prueba.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "empleados")
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellidos;
    private String tipo_documento;
    private String numero_documento;
    private LocalDate fecha_nacimiento;
    private LocalDate fecha_vinculacion;
    private String cargo;
    private Double salario;
}
