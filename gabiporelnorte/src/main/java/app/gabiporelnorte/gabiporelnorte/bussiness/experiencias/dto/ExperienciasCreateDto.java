package app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
public class ExperienciasCreateDto {

    private String titulo;
    private String resumen;
    private String descripcion;
    private String localizacion;
    private Double precio;
    private Integer duracion;
    private List<String> etiquetas;
    private String imagen;
    private String url;

}
