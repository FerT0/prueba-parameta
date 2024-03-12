package com.parameta.prueba.controllers.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmpleadoDTO {
    private TiempoVinculado tiempo_vinculado;
    private EdadEmpleado edad_empleado;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class TiempoVinculado {
        private int years;
        private int months;
        private int days;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class EdadEmpleado {
        private int years;
        private int months;
        private int days;
    }
}
