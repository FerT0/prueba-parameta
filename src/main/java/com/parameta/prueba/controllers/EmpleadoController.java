package com.parameta.prueba.controllers;

import com.parameta.prueba.controllers.request.AgregarEmpleadoDTO;
import com.parameta.prueba.controllers.response.ResponseEmpleadoDTO;
import com.parameta.prueba.services.IEmpleado;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    @Autowired
    private IEmpleado iEmpleado;

    @PostMapping("agregarEmpleado")
    public ResponseEntity<?> agregarEmpleado(@Valid @RequestBody AgregarEmpleadoDTO req){
        LocalDate today = LocalDate.now();

        Period periodVinculacion = Period.between(req.getFecha_vinculacion(), today);
        int yearsVinculacion = periodVinculacion.getYears();
        int monthsVinculacion = periodVinculacion.getMonths();
        int daysVinculacion = periodVinculacion.getDays();

        Period periodEdad = Period.between(req.getFecha_nacimiento(), today);
        int yearsEdad = periodEdad.getYears();
        int monthsEdad = periodEdad.getMonths();
        int daysEdad = periodEdad.getDays();

        if (yearsEdad < 18) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "El empleado debe ser mayor de edad");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        iEmpleado.save(req);

        ResponseEmpleadoDTO responseEmpleadoDTO = new ResponseEmpleadoDTO(
                new ResponseEmpleadoDTO.TiempoVinculado(
                        yearsVinculacion,
                        monthsVinculacion,
                        daysVinculacion
                ),
                new ResponseEmpleadoDTO.EdadEmpleado(
                        yearsEdad,
                        monthsEdad,
                        daysEdad
                )
        );

        return new ResponseEntity<>(responseEmpleadoDTO, HttpStatus.CREATED);
    }
}
