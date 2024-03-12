package com.parameta.prueba.services.impl;

import com.parameta.prueba.controllers.request.AgregarEmpleadoDTO;
import com.parameta.prueba.models.entity.EmpleadoEntity;
import com.parameta.prueba.repositories.EmpleadoRepository;
import com.parameta.prueba.services.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoImpl implements IEmpleado {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public EmpleadoEntity save(AgregarEmpleadoDTO agregarEmpleadoDTO) {
        EmpleadoEntity empleado = EmpleadoEntity.builder()
                .nombres(agregarEmpleadoDTO.getNombres())
                .apellidos(agregarEmpleadoDTO.getApellidos())
                .tipo_documento(agregarEmpleadoDTO.getTipo_documento())
                .numero_documento(agregarEmpleadoDTO.getNumero_documento())
                .fecha_nacimiento(agregarEmpleadoDTO.getFecha_nacimiento())
                .fecha_vinculacion(agregarEmpleadoDTO.getFecha_vinculacion())
                .cargo(agregarEmpleadoDTO.getCargo())
                .salario(agregarEmpleadoDTO.getSalario())
                .build();
        return empleadoRepository.save(empleado);
    }
}
