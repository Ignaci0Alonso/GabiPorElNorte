package app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class ExperienciasResponse {
    private String titulo;
    private String resumen;
    private String descripcion;
    private String localizacion;
    private Double precio;
    private Integer duracion;
    private String url;
    private Boolean activa;
    private List<String> etiquetas;
}
