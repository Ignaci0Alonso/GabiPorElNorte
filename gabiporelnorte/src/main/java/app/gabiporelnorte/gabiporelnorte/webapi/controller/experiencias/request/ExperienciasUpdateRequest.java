package app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias.request;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data 
@Builder
public class ExperienciasUpdateRequest {
    
    @NotNull 
    @Schema(description = "Título de la experiencia", example = "Tour por la ciudad")
    private String titulo;

    @NotNull 
    @Schema(description = "Resumen de la experiencia", example = "Un recorrido por los principales puntos turísticos de la ciudad")
    private String resumen;
    
    @NotNull 
    @Schema (description = "Descripción detallada de la experiencia", example = "Este tour incluye visitas a los museos, parques y monumentos más importantes de la ciudad, con guías expertos y transporte incluido.")
    private String descripcion;

    @NotNull 
    @Schema (description = "Localización de la experiencia", example = "Bilbao")
    private String localizacion;    

    @NotNull 
    @Schema (description = "Precio de la experiencia", example = "50.0")
    private Double precio;

    @NotNull 
    @Schema (description = "Duración de la experiencia en horas", example = "3")
    private Integer duracion;

    @NotNull 
    @Schema (description = "Lista de etiquetas asociadas a la experiencia", example = "[\"cultura\", \"gastronomía\", \"aventura\"]")
    private List<String> etiquetas;

    @NotNull 
    @Schema(description = "Imagen de la experiencia", example = "https://example.com/image.jpg")
    private String imagen;

    @NotNull 
    @Schema (description = "URL de la página de la experiencia", example = "https://example.com/landing-page.com")
    private String url;

    @NotNull 
    @Schema (description = "Indica si la experiencia está activa o no", example = "true")
    private Boolean activa;
}
