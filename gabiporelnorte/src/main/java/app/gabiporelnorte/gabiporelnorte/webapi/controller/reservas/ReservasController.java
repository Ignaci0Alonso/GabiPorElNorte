package app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.service.ReservasService;
import app.gabiporelnorte.gabiporelnorte.bussiness.shared.anotations.Operation;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas.mapper.ReservasControllerMapper;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas.response.ReservasResponse;
import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
@RequestMapping ("/webapi/reservas")
public class ReservasController {

    private final ReservasService reservasService;

    private final ReservasControllerMapper mapper;

    @GetMapping 
    @ResponseStatus (HttpStatus.OK)
    @Operation(name = "Obtener todas las reservas", description = "Obtiene todas las reservas", entity = "Reservas")
    public Page<ReservasDto> getAllReservas(@RequestAttribute String localizacion, Pageable pageable) {
        return reservasService.getAllReservas(localizacion, pageable);
    }

    @GetMapping ("/{id}")
    @ResponseStatus (HttpStatus.OK)
    @Operation(name = "Obtener una reserva por ID", description = "Obtiene una reserva por su ID", entity = "Reservas")
    public ReservasDto getReservaById(@PathVariable UUID id) {
        return reservasService.getReservaById(id);
    }

    @PostMapping 
    @ResponseStatus (HttpStatus.CREATED)
    @Operation(name = "Crear una nueva reserva", description = "Crea una nueva reserva", entity = "Reservas")
    public ReservasResponse createReserva(@RequestAttribute ReservasCreateDto reservasCreateDto) {
        return mapper.toResponse(reservasService.createReserva(reservasCreateDto));
    }

    @PutMapping 
    @ResponseStatus (HttpStatus.OK)
    @Operation(name = "Actualizar una reserva existente", description = "Actualiza una reserva existente", entity = "Reservas")
    public ReservasDto updateReserva(@RequestAttribute UUID id, @RequestAttribute ReservasUpdateDto reservasUpdateDto) {
        return reservasService.updateReserva(id, reservasUpdateDto);
    }   

    @DeleteMapping 
    @ResponseStatus (HttpStatus.NO_CONTENT)
    @Operation(name = "Eliminar una reserva existente", description = "Elimina una reserva existente", entity = "Reservas")
    public void deleteReserva(@RequestAttribute UUID id) {
        reservasService.deleteReserva(id);
    }

}
