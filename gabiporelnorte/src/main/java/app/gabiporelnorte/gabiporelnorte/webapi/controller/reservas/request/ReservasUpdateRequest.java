package app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas.request;

import java.time.LocalDate;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class ReservasUpdateRequest {
    
    @NotNull 
    @Schema (description = "Identificador de las resevas", example = "123")
    private UUID id;

    @NotNull 
    @Schema (description = "Numero de la reserva", example = "1234567890")
    private Long numeroReserva;

    @NotNull 
    @Schema (description = "Nombre del cliente", example = "Nombre")
    private String nombreCliente;

    @NotNull 
    @Schema (description = "Apellido del cliente", example = "Apellido")
    private String apellidoCliente;

    @NotNull 
    @Schema (description = "Email del cliente", example = "emailcliente@example.com")
    private String emailCliente;

    @Schema (description = "Telefono del cliente", example = "34123456789")
    private Long telefonoCliente;

    @NotNull 
    @Schema (description = "Identificador de la experiencia", example = "123")
    private UUID experienciaId;

    @NotNull 
    @Schema (description = "Numero de personas", example = "1")
    private Long numeroPersonas;

    @NotNull 
    @Schema (description = "Fecha de la reserva", example = "10-01-2002")
    private LocalDate fechaReserva;

}
