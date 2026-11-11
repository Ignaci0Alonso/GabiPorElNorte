package app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias.mapper;

import java.util.UUID;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.persistence.ExperienciasFilterSpecification;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias.request.ExperienciasCreateRequest;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias.request.ExperienciasFilterRequest;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias.request.ExperienciasUpdateRequest;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias.response.ExperienciasResponse;

@Mapper 
public interface ExperienciasControllerMapper {

    @BeanMapping (unmappedTargetPolicy = ReportingPolicy.ERROR)
    ExperienciasResponse toResponse(ExperienciasDto experienciasDto);

    @BeanMapping (unmappedSourcePolicy = ReportingPolicy.ERROR)
    ExperienciasFilterSpecification toDto(ExperienciasFilterRequest request);

    @BeanMapping (unmappedSourcePolicy = ReportingPolicy.ERROR)
    ExperienciasCreateDto toDto(ExperienciasCreateRequest request);

    @BeanMapping (unmappedSourcePolicy = ReportingPolicy.ERROR)
    @Mapping(target = "id", source = "id")
    ExperienciasUpdateDto toDto(UUID id, ExperienciasUpdateRequest request);

}
