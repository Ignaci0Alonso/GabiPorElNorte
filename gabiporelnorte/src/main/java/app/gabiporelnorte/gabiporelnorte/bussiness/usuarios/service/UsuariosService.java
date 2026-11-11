package app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestAttribute;

import app.gabiporelnorte.gabiporelnorte.bussiness.shared.anotations.Operation;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.mapper.UsuariosDtoMapper;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.persistence.repository.UsuariosRepository;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Data 
@Builder 
@Service 
public class UsuariosService {

    private final UsuariosRepository repository;

    private final UsuariosDtoMapper mapper;

    @Operation(name = "Obtener usuario por id", description = "Obtiene una usuario por su id", entity = "Usuarios")
    @Transactional(readOnly = true)
    public UsuariosDto getUsuarioById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("La usuario no fue encontrada con id: " + id));
    }

    @Operation(name = "Obtener todas las usuarios", description = "Obtiene todas las usuarios", entity = "Usuarios")
    @Transactional(readOnly = true)
    public Page<UsuariosDto> getAllUsuarios(@RequestAttribute String localizacion, Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDto);
    }

    @Transactional
    public UsuariosDto createUsuario(UsuariosCreateDto usuariosCreateDto) {
        return mapper.toDto(repository.save(mapper.toEntity(usuariosCreateDto)));
    }

    @Transactional
    public UsuariosDto updateUsuario(UUID id, UsuariosUpdateDto usuariosUpdateDto) {
        return repository.findById(id)
                .map(usuario -> {
                    mapper.updateEntity(usuario, usuariosUpdateDto);
                    return mapper.toDto(repository.save(usuario));
                })
                .orElseThrow(() -> new RuntimeException("La usuario no fue encontrada con id: " + id));
    }

    @Transactional
    public void deleteUsuario(UUID id) {
        repository.deleteById(id);
    }

    public long countAll() {
        return repository.count();
    }

}
