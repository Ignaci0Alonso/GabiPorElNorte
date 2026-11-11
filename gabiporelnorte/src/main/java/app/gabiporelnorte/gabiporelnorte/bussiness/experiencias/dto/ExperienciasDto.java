package app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class ExperienciasDto {
    private UUID id;
    private String titulo;
    private String resumen;
    private String descripcion;
    private String localizacion;
    private String imagen;
    private Double precio;
    private Integer duracion;
    private String url;
    private Boolean activa;
    private List<String> etiquetas;

}
