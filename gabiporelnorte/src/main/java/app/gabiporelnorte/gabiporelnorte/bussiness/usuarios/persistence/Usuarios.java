package app.gabiporelnorte.gabiporelnorte.bussiness.usuarios.persistence;

import java.util.UUID;

import org.hibernate.annotations.Nationalized;

import app.gabiporelnorte.gabiporelnorte.bussiness.shared.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumeratedValue;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@Entity 
@NoArgsConstructor 
@AllArgsConstructor 
@EqualsAndHashCode (callSuper = false)
public class Usuarios {

    @Id 
    @GeneratedValue (generator = "UUID")
    @Column(name = "ID", nullable = false)
    private UUID id;
    
    @Size (max = 20)
    @Column (name = "USERNAME", nullable = false, unique = true)
    @Nationalized 
    private String username;

    @Size(min = 8, max = 20)
    @Column (name = "PASSWORD", nullable = false)
    @Nationalized 
    private String password;

    @Size (max = 50)
    @Column (name = "EMAIL", nullable = false)
    @Nationalized 
    private String email;

    @EnumeratedValue 
    @Column (name = "ROL", nullable = false)
    private RoleEnum rol;

}
