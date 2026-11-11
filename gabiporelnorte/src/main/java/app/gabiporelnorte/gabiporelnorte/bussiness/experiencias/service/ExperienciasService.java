package app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestAttribute;

import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasCreateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.dto.ExperienciasUpdateDto;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.mapper.ExperienciasDtoMapper;
import app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.persistence.repository.ExperienciasRepository;
import app.gabiporelnorte.gabiporelnorte.bussiness.shared.anotations.Operation;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@Service
public class ExperienciasService {

    private final ExperienciasRepository repository;

    private final ExperienciasDtoMapper mapper;

    @Operation(name = "Obtener experiencia por id", description = "Obtiene una experiencia por su id", entity = "Experiencias")
    @Transactional(readOnly = true)
    public ExperienciasDto getExperienciaById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("La experiencia no fue encontrada con id: " + id));
    }

    @Operation(name = "Obtener todas las experiencias", description = "Obtiene todas las experiencias", entity = "Experiencias")
    @Transactional(readOnly = true)
    public Page<ExperienciasDto> getAllExperiencias(@RequestAttribute String localizacion, Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDto);
    }

    @Transactional
    public ExperienciasDto createExperiencia(ExperienciasCreateDto experienciasCreateDto) {
        return mapper.toDto(repository.save(mapper.toEntity(experienciasCreateDto)));
    }

    @Transactional
    public ExperienciasDto updateExperiencia(UUID id, ExperienciasUpdateDto experienciasUpdateDto) {
        return repository.findById(id)
                .map(experiencia -> {
                    mapper.updateEntity(experiencia, experienciasUpdateDto);
                    return mapper.toDto(repository.save(experiencia));
                })
                .orElseThrow(() -> new RuntimeException("La experiencia no fue encontrada con id: " + id));
    }

    @Transactional
    public void deleteExperiencia(UUID id) {
        repository.deleteById(id);
    }

    public long countAll() {
        return repository.count();
    }


}
