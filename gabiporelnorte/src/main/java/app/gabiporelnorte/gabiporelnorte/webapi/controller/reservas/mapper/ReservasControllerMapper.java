package app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas.mapper;

import java.util.UUID;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.dto.ReservasUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.reservas.persistence.ReservasFilterSpecification;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas.request.ReservasCreateRequest;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas.request.ReservasFilterRequest;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas.request.ReservasUpdateRequest;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.reservas.response.ReservasResponse;

@Mapper
public interface ReservasControllerMapper {

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.ERROR)
    ReservasResponse toResponse(ReservasDto reservasDto);

    @BeanMapping(unmappedSourcePolicy = ReportingPolicy.ERROR)
    ReservasFilterSpecification toDto(ReservasFilterRequest request);

    @BeanMapping(unmappedSourcePolicy = ReportingPolicy.ERROR)
    ReservasCreateDto toDto(ReservasCreateRequest request);

    @BeanMapping(unmappedSourcePolicy = ReportingPolicy.ERROR)
    @Mapping(target = "id", source = "id")
    ReservasUpdateDto toDto(UUID id, ReservasUpdateRequest request);

}
