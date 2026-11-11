package app.gabiporelnorte.gabiporelnorte.bussiness.experiencias.persistence;

import static app.gabiporelnorte.gabiporelnorte.bussiness.shared.CommonSpecification.in;
import static app.gabiporelnorte.gabiporelnorte.bussiness.shared.CommonSpecification.isEqual;
import static app.gabiporelnorte.gabiporelnorte.bussiness.shared.CommonSpecification.like;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExperienciasFilterSpecification {

    private Set<UUID> idIn;
    private String tituloLike;
    private String resumenLike;
    private String localizacionLike;
    private Double eqPrecio;
    private Integer eqDuracion;
    private List<String> etiquetasLike;
    private Boolean isActiva;

    public Predicate toPredicate(@NonNull Root<Experiencias> root, @Nullable CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
        return Specification.where(in(Experiencias_.id, idIn))
                .and(like(Experiencias_.titulo, tituloLike))
                .and(like(Experiencias_.resumen, resumenLike))
                .and(like(Experiencias_.localizacion, localizacionLike))
                .and(isEqual(Experiencias_.precio, eqPrecio))
                .and(isEqual(Experiencias_.duracion, eqDuracion))
                .and(tieneEtiquetas(etiquetasLike))
                .and(isEqual(Experiencias_.activa, isActiva))
                .toPredicate(root, query, criteriaBuilder);

    }

    private static Specification<Experiencias> tieneEtiquetas(List<String> etiquetas) {
    return (root, query, cb) -> {
        if (etiquetas == null || etiquetas.isEmpty()) return null;
        query.distinct(true);
        return root.join(Experiencias_.etiquetas).in(etiquetas);
    };
}
}