package app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.dto;

import java.util.UUID;

import app.gabiporelnorte.gabiporelnorte.bussiness.shared.enums.RoleEnum;
import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class UsuariosUpdateDto {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private RoleEnum rol;
}
