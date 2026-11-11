package app.gabiporelnorte.gabiporelnorte.webapi.controller.usuarios.request;

import app.gabiporelnorte.gabiporelnorte.bussiness.shared.enums.RoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class UsuariosCreateRequest {
    
    @NotNull 
    @Schema (description = "Nombre del usuario", example = "username")
    private String username;
    
    @NotNull 
    @Schema (description = "Password del usuario", example = "password")
    private String password;

    @NotNull 
    @Schema (description = "Email del usuario", example = "email@example.com")
    private String email;

    @NotNull 
    @Schema (description = "Rol del usuario", example = "USUARIO")
    private RoleEnum rol;
}
