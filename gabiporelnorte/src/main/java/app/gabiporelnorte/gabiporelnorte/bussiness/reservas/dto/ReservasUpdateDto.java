package app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class ReservasUpdateDto {
    
    private UUID id;

    private Long numeroReserva;

    private String nombreCliente;

    private String apellidoCliente;

    private String emailCliente;

    private Long telefonoCliente;

    private UUID experienciaId;

    private Long numeroPersonas;

    private LocalDate fechaReserva;
}
