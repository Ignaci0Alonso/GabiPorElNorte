package app.gabiporelnorte.gabiporelnorte.bussiness.reservas.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestAttribute;

import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.mapper.ReservasDtoMapper;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.persistence.repository.ReservasRepository;
import app.gabiporelnorte.gabiporelnorte.bussiness.shared.anotations.Operation;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Data 
@Builder 
@Service 
public class ReservasService {
    private final ReservasRepository repository;

    private final ReservasDtoMapper mapper;

    @Operation(name = "Obtener reserva por id", description = "Obtiene una reserva por su id", entity = "Reservas")
    @Transactional(readOnly = true)
    public ReservasDto getReservaById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("La reserva no fue encontrada con id: " + id));
    }

    @Operation(name = "Obtener todas las reservas", description = "Obtiene todas las reservas", entity = "Reservas")
    @Transactional(readOnly = true)
    public Page<ReservasDto> getAllReservas(@RequestAttribute String localizacion, Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDto);
    }

    @Transactional
    public ReservasDto createReserva(ReservasCreateDto reservasCreateDto) {
        return mapper.toDto(repository.save(mapper.toEntity(reservasCreateDto)));
    }

    @Transactional
    public ReservasDto updateReserva(UUID id, ReservasUpdateDto reservasUpdateDto) {
        return repository.findById(id)
                .map(reserva -> {
                    mapper.updateEntity(reserva, reservasUpdateDto);
                    return mapper.toDto(repository.save(reserva));
                })
                .orElseThrow(() -> new RuntimeException("La reserva no fue encontrada con id: " + id));
    }

    @Transactional
    public void deleteReserva(UUID id) {
        repository.deleteById(id);
    }

    public long countAll() {
        return repository.count();
    }

}
