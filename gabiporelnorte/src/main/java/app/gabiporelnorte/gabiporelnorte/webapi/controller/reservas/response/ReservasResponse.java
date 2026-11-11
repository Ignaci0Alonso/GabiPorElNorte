package app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas.response;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class ReservasResponse {

    private Long numeroReserva;
    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private Long telefonoCliente;
    private UUID experienciaId;
    private Long numeroPersonas;
    private LocalDate fechaReserva;
}
