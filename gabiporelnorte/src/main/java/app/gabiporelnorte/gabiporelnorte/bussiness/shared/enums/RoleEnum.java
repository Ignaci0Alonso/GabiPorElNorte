package app.gabiporelnorte.gabiporelnorte.bussiness.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter 
@NoArgsConstructor 
@AllArgsConstructor 
public enum RoleEnum {
    USER("USUARIO"),
    ADMIN("ADMINISTRADOR");

    String description;
}

