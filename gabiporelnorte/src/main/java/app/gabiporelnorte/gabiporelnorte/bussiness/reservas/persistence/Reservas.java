package app.gabiporelnorte.gabiporelnorte.bussiness.reservas.persistence;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@EqualsAndHashCode (callSuper = false)
@Table (name = "RESERVAS")
public class Reservas {

    @Id 
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Size(max = 10)
    @Column(name = "NUMERO_RESERVA", nullable = false, unique = true)
    private Long numeroReserva;

    @Size(max = 20)
    @Column(name = "NOMBRE_CLIENTE", nullable = false)
    @Nationalized 
    private String nombreCliente;

    @Size(max = 20)
    @Column (name = "APELLIDO_CLIENTE", nullable = false)
    @Nationalized
    private String apellidoCliente;

    @Size(max = 50)
    @Column (name = "EMAIL_CLIENTE", nullable = false)
    @Nationalized
    private String emailCliente;

    @Size(max = 15)
    @Column(name = "TELEFONO_CLIENTE", nullable = true)
    private Long telefonoCliente;

    @JoinColumn (name = "EXPERIENCIA_ID", nullable = false)
    private UUID experienciaId;

    @Column(name = "NUMERO_PERSONAS", nullable = false)
    private Long numeroPersonas;

    @Column(name = "FECHA_RESERVA", nullable = false)
    private LocalDate fechaReserva;
    
}
