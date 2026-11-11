package app.gabiporelnorte.gabiporelnorte.bussiness.reservas.mapper;

import java.util.UUID;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.persistence.Reservas;

@Mapper 
public interface ReservasDtoMapper {

    @Mapping (target = "id", source = "id")
    Reservas toEntity(UUID id);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.ERROR)
    ReservasDto toDto(Reservas reservas);

        @BeanMapping(unmappedSourcePolicy = ReportingPolicy.ERROR)
    Reservas toEntity(ReservasCreateDto reservasCreateDto);

    @BeanMapping (unmappedSourcePolicy = ReportingPolicy.ERROR)
    void updateEntity( @MappingTarget Reservas reservas, ReservasUpdateDto reservasUpdateDto);

}
