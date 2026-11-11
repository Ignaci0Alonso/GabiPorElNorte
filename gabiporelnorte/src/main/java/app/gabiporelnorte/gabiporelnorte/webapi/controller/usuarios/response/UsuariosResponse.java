package app.gabiporelnorte.gabiporelnorte.webapi.controller.usuarios.response;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class UsuariosResponse {
    private String username;
    private String email;
}
