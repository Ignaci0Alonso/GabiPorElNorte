package app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas.request;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

public class ReservasFilterRequest {

    @Schema (description = "Identificador de las resevas", example = "123")
    private Set<UUID> idIn;

    @Schema (description = "Que contenga en el numero de la reserva", example = "1234567890")
    private Long numeroReservaEq;

    @Schema (description = "Que contenga en el nombre del cliente", example = "Nombre")
    private String nombreClienteLike;

    @Schema (description = "Que contenga en el apellido del cliente", example = "Apellido")
    private String apellidoClienteLike;

    @Schema (description = "Identificador de la experiencia", example = "123")
    private UUID experienciaIdIn;

    @Schema (description = "Fecha de la reserva", example = "10-01-2002")
    private LocalDate fechaReservaEq;
}
