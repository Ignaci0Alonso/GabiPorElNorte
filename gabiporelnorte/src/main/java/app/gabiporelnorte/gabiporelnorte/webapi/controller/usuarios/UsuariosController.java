package app.gabiporelnorte.gabiporelnorte.webapi.controller.usuarios;

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

import app.gabiporelnorte.gabiporelnorte.bussiness.shared.anotations.Operation;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto.UsuariosUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.service.UsuariosService;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.usuarios.mapper.UsuariosControllerMapper;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.usuarios.response.UsuariosResponse;
import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
@RequestMapping ("/webapi/usuarios")
public class UsuariosController {
    private final UsuariosService usuariosService;

    private final UsuariosControllerMapper mapper;

    @GetMapping 
    @ResponseStatus (HttpStatus.OK)
    @Operation(name = "Obtener todas las usuarios", description = "Obtiene todas las usuarios", entity = "Usuarios")
    public Page<UsuariosDto> getAllUsuarios(@RequestAttribute String localizacion, Pageable pageable) {
        return usuariosService.getAllUsuarios(localizacion, pageable);
    }

    @GetMapping ("/{id}")
    @ResponseStatus (HttpStatus.OK)
    @Operation(name = "Obtener una usuario por ID", description = "Obtiene una usuario por su ID", entity = "Usuarios")
    public UsuariosDto getUsuarioById(@PathVariable UUID id) {
        return usuariosService.getUsuarioById(id);
    }

    @PostMapping 
    @ResponseStatus (HttpStatus.CREATED)
    @Operation(name = "Crear una nueva usuario", description = "Crea una nueva usuario", entity = "Usuarios")
    public UsuariosResponse createUsuario(@RequestAttribute UsuariosCreateDto usuariosCreateDto) {
        return mapper.toResponse(usuariosService.createUsuario(usuariosCreateDto));
    }

    @PutMapping 
    @ResponseStatus (HttpStatus.OK)
    @Operation(name = "Actualizar una usuario existente", description = "Actualiza una usuario existente", entity = "Usuarios")
    public UsuariosDto updateUsuario(@RequestAttribute UUID id, @RequestAttribute UsuariosUpdateDto usuariosUpdateDto) {
        return usuariosService.updateUsuario(id, usuariosUpdateDto);
    }   

    @DeleteMapping 
    @ResponseStatus (HttpStatus.NO_CONTENT)
    @Operation(name = "Eliminar una usuario existente", description = "Elimina una usuario existente", entity = "Usuarios")
    public void deleteUsuario(@RequestAttribute UUID id) {
        usuariosService.deleteUsuario(id);
    }
}
