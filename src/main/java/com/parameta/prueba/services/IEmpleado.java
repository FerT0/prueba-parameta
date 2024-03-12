package com.parameta.prueba.services;

import com.parameta.prueba.controllers.request.AgregarEmpleadoDTO;
import com.parameta.prueba.models.entity.EmpleadoEntity;

public interface IEmpleado {
    EmpleadoEntity save(AgregarEmpleadoDTO agregarEmpleadoDTO);
}
