package app.gabiporelnorte.gabiporelnorte.webapi.controller.usuarios.mapper;

import java.util.UUID;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosUpdateDto;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.usuarios.request.UsuariosCreateRequest;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.usuarios.request.UsuariosUpdateRequest;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.usuarios.response.UsuariosResponse;

@Mapper
public interface UsuariosControllerMapper {

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.ERROR)
    UsuariosResponse toResponse(UsuariosDto usuariosDto);

    @BeanMapping(unmappedSourcePolicy = ReportingPolicy.ERROR)
    UsuariosCreateDto toDto(UsuariosCreateRequest request);

    @BeanMapping(unmappedSourcePolicy = ReportingPolicy.ERROR)
    @Mapping(target = "id", source = "id")
    UsuariosUpdateDto toDto(UUID id, UsuariosUpdateRequest request);

}
