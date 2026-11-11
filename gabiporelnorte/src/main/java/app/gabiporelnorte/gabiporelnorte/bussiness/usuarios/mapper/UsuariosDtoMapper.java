package app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.mapper;

import java.util.UUID;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.persistence.Usuarios;

@Mapper 
public interface UsuariosDtoMapper {
    
    @Mapping (target = "id", source = "id")
    Usuarios toEntity(UUID id);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.ERROR)
    UsuariosDto toDto(Usuarios usuarios);

        @BeanMapping(unmappedSourcePolicy = ReportingPolicy.ERROR)
    Usuarios toEntity(UsuariosCreateDto usuariosCreateDto);

    @BeanMapping (unmappedSourcePolicy = ReportingPolicy.ERROR)
    void updateEntity( @MappingTarget Usuarios usuarios, UsuariosUpdateDto usuariosUpdateDto);

}
