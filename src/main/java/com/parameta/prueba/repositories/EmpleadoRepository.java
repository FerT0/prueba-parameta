package com.parameta.prueba.repositories;

import com.parameta.prueba.models.entity.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity, Long> {

}
