package app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.service.ExperienciasService;
import app.gabiporelnorte.gabiporelnorte.bussiness.shared.anotations.Operation;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias.mapper.ExperienciasControllerMapper;
import app.gabiporelnorte.gabiporelnorte.webapi.controller.experiencias.response.ExperienciasResponse;
import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
@RequestMapping("/webapi/experiencias")
public class ExperienciasController {

    private final ExperienciasService experienciasService;

    private final ExperienciasControllerMapper mapper;

    @GetMapping 
    @ResponseStatus (HttpStatus.OK)
    @Operation(name = "Obtener todas las experiencias", description = "Obtiene todas las experiencias", entity = "Experiencias")
    public Page<ExperienciasDto> getAllExperiencias(@RequestAttribute String localizacion, Pageable pageable) {
        return experienciasService.getAllExperiencias(localizacion, pageable);
    }

    @GetMapping ("/{id}")
    @ResponseStatus (HttpStatus.OK)
    @Operation(name = "Obtener una experiencia por ID", description = "Obtiene una experiencia por su ID", entity = "Experiencias")
    public ExperienciasDto getExperienciaById(@PathVariable UUID id) {
        return experienciasService.getExperienciaById(id);
    }

    @PostMapping 
    @ResponseStatus (HttpStatus.CREATED)
    @Operation(name = "Crear una nueva experiencia", description = "Crea una nueva experiencia", entity = "Experiencias")
    public ExperienciasResponse createExperiencia(@RequestAttribute ExperienciasCreateDto experienciasCreateDto) {
        return mapper.toResponse(experienciasService.createExperiencia(experienciasCreateDto));
    }

    @PutMapping 
    @ResponseStatus (HttpStatus.OK)
    @Operation(name = "Actualizar una experiencia existente", description = "Actualiza una experiencia existente", entity = "Experiencias")
    public ExperienciasDto updateExperiencia(@RequestAttribute UUID id, @RequestAttribute ExperienciasUpdateDto experienciasUpdateDto) {
        return experienciasService.updateExperiencia(id, experienciasUpdateDto);
    }   

    @DeleteMapping 
    @ResponseStatus (HttpStatus.NO_CONTENT)
    @Operation(name = "Eliminar una experiencia existente", description = "Elimina una experiencia existente", entity = "Experiencias")
    public void deleteExperiencia(@RequestAttribute UUID id) {
        experienciasService.deleteExperiencia(id);
    }

}
