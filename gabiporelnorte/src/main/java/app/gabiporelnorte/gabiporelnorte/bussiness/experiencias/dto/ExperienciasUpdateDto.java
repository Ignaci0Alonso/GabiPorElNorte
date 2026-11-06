package app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class ExperienciasUpdateDto {
    private String id;
    private String titulo;
    private String resumen;
    private String descripcion;
    private String localizacion;
    private Double precio;
    private Integer duracion;
    private String url;
    private List<String> etiquetas;
    private String imagen;
    private Boolean activa;

}
