package app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.persistence;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Nationalized;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@EqualsAndHashCode(callSuper = false)
@Table(name = "EXPERIENCIAS")
public class Experiencias {

    @GeneratedValue(generator = "UUID")
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private UUID id;

    @NotNull
    @Size(max = 50)
    @Column(name = "TITULO", nullable = false)
    @Nationalized
    private String titulo;

    @NotNull
    @Size(max = 200)
    @Column(name = "RESUMEN", nullable = false)
    @Nationalized
    private String resumen;

    @NotNull
    @Size(max = 2000)
    @Column(name = "DESCRIPCION", nullable = false)
    @Nationalized
    private String descripcion;

    @NotNull
    @Size(max = 20)
    @Column(name = "LOCALIZACION", nullable = false)
    @Nationalized
    private String localizacion;

    @NotNull
    @Column(name = "IMAGEN", nullable = false)
    private String imagen;

    @Column(name = "PRECIO", nullable = true)
    private Double precio;

    @NotNull
    @Column(name = "DURACION", nullable = false)
    private Integer duracion;

    @ElementCollection
    @CollectionTable(name = "EXPERIENCIAS_ETIQUETAS", joinColumns = @JoinColumn(name = "EXPERIENCIA_ID"))
    @Column(name = "ETIQUETA")
    private List<String> etiquetas;

    @NotNull
    @Column(name = "URL", nullable = false)
    private String url;

    @NotNull
    @Column(name = "ACTIVA", nullable = false)
    private Boolean activa;

}
