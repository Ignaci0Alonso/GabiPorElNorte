package app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.mapper;

import java.util.UUID;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.persistence.Experiencias;

@Mapper
public interface ExperienciasDtoMapper {

    @Mapping (target = "id", source = "id")
    Experiencias toEntity(UUID id);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.ERROR)
    ExperienciasDto toDto(Experiencias experiencias);

    @BeanMapping(unmappedSourcePolicy = ReportingPolicy.ERROR)
    Experiencias toEntity(ExperienciasCreateDto experienciasCreateDto);

    @BeanMapping (unmappedSourcePolicy = ReportingPolicy.ERROR)
    void updateEntity( @MappingTarget Experiencias experiencias, ExperienciasUpdateDto experienciasUpdateDto);

}
