package app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias.request;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder 
public class ExperienciasFilterRequest {
     
    @Schema(description = "Que contenga en el título de la experiencia", example = "Tour por la ciudad", nullable = true)
    private String tituloLike;

     
    @Schema(description = "Que contenga en el resumen de la experiencia", example = "Un recorrido por los principales puntos turísticos de la ciudad", nullable = true)
    private String resumenLike;
    
     
    @Schema (description = "Que contenga en la descripción detallada de la experiencia", example = "Este tour incluye visitas a los museos, parques y monumentos más importantes de la ciudad, con guías expertos y transporte incluido.", nullable = true)
    private String descripcionLike;

     
    @Schema (description = "Que contenga en la localización de la experiencia", example = "Bilbao", nullable = true)
    private String localizacionLike;    

     
    @Schema (description = "Que contenga en el precio de la experiencia", example = "50.0", nullable = true)
    private Double eqPrecio;

     
    @Schema (description = "Que contenga en la duración de la experiencia en horas", example = "3", nullable = true)
    private Integer eqDuracion;

     
    @Schema (description = "Que contenga en la lista de etiquetas asociadas a la experiencia", example = "[\"cultura\", \"gastronomía\", \"aventura\"]", nullable = true)
    private List<String> etiquetasLike;

     
    @Schema (description = "Que contenga en la URL de la página de la experiencia", example = "https://example.com/landing-page.com", nullable = true)
    private String urlLike;

     
    @Schema (description = "Que contenga en la indicación de si la experiencia está activa o no", example = "true", nullable = true)
    private Boolean isActiva;
}
