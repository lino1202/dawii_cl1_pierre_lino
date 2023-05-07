package pe.edu.cibertec.dawii_cl1_pierre_lino.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResultadoResponse {

    private Boolean respuesta;
    private String mensaje;
}
