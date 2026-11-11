package app.gabiporelnorte.gabiporelnorte.bussiness.reservas.persistence;

import static app.gabiporelnorte.gabiporelnorte.bussiness.shared.CommonSpecification.in;
import static app.gabiporelnorte.gabiporelnorte.bussiness.shared.CommonSpecification.isEqual;
import static app.gabiporelnorte.gabiporelnorte.bussiness.shared.CommonSpecification.like;

import java.time.LocalDate;
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
public class ReservasFilterSpecification {
    private Set<UUID> idIn;
    private Long numeroReservaEq;
    private String nombreClienteLike;
    private String apellidoClienteLike;
    private UUID experienciaIdIn;
    private LocalDate fechaReservaEq;

        public Predicate toPredicate(@NonNull Root<Reservas> root, @Nullable CriteriaQuery<?> query, @NonNull CriteriaBuilder criteriaBuilder) {
        return Specification.where(in(Reservas_.id, idIn))
                .and(isEqual(Reservas_.numeroReserva, numeroReservaEq))
                .and(like(Reservas_.nombreCliente, nombreClienteLike))
                .and(like(Reservas_.apellidoCliente, apellidoClienteLike))
                .and(isEqual(Reservas_.experienciaId, experienciaIdIn))
                .and(isEqual(Reservas_.fechaReserva, fechaReservaEq))
                .toPredicate(root, query, criteriaBuilder);

    }
}
