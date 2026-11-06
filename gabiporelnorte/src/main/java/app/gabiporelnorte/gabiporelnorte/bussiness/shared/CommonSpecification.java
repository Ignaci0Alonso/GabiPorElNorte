package app.gabiporelnorte.gabiporelnorte.bussiness.shared;

import java.util.Collection;
import java.util.function.Function;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import app.gabiporelnorte.gabiporelnorte.bussiness.shared.function.PathFunction;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.Generated;

public final class CommonSpecification {
    public static <T> Specification<T> distinct() {
        return (root, query, criteriaBuilder) -> {
            query.distinct(true);
            return null;
        };
    }

    public static <T, V> Specification<T> in(SingularAttribute<? super T, V> field, Collection<V> values) {
        return in((r) -> {
            return r.get(field);
        }, values);
    }

    public static <T, V> Specification<T> in(SingularAttribute<? super T, V> field, Expression<V> expression) {
        return in((r) -> {
            return r.get(field);
        }, expression);
    }

    public static <T, V> Specification<T> in(PathFunction<T, V> pathFunction, Collection<V> values) {
        return (root, query, criteriaBuilder) -> {
            return !CollectionUtils.isEmpty(values) ? ((Path) pathFunction.apply(root)).in(values) : null;
        };
    }

    public static <T, V> Specification<T> in(PathFunction<T, V> pathFunction, Expression<V> expression) {
        return (root, query, criteriaBuilder) -> {
            return expression != null ? ((Path) pathFunction.apply(root)).in(new Expression[] { expression }) : null;
        };
    }

    public static <T, V> Specification<T> notIn(SingularAttribute<? super T, V> field, Collection<V> values) {
        return notIn((r) -> {
            return r.get(field);
        }, values);
    }

    public static <T, V> Specification<T> notIn(SingularAttribute<? super T, V> field, Expression<V> expression) {
        return notIn((r) -> {
            return r.get(field);
        }, expression);
    }

    public static <T, V> Specification<T> notIn(PathFunction<T, V> pathFunction, Collection<V> values) {
        return (root, query, criteriaBuilder) -> {
            return !CollectionUtils.isEmpty(values) ? criteriaBuilder.not(((Path) pathFunction.apply(root)).in(values))
                    : null;
        };
    }

    public static <T, V> Specification<T> notIn(PathFunction<T, V> pathFunction, Expression<V> expression) {
        return (root, query, criteriaBuilder) -> {
            return expression != null
                    ? criteriaBuilder.not(((Path) pathFunction.apply(root)).in(new Expression[] { expression }))
                    : null;
        };
    }

    public static <T> Specification<T> like(SingularAttribute<? super T, String> field, String value) {
        return like((r) -> {
            return r.get(field);
        }, value);
    }

    public static <T> Specification<T> like(Function<Root<T>, Path<String>> pathFunction, String value) {
        return (root, query, criteriaBuilder) -> {
            return StringUtils.hasText(value)
                    ? criteriaBuilder.like((Expression) pathFunction.apply(root), "%" + value + "%")
                    : null;
        };
    }

    public static <T> Specification<T> startsWith(SingularAttribute<? super T, String> field, String prefix) {
        return startsWith((r) -> {
            return r.get(field);
        }, prefix);
    }

    public static <T> Specification<T> startsWith(Function<Root<T>, Path<String>> pathFunction, String prefix) {
        return (root, query, criteriaBuilder) -> {
            return StringUtils.hasText(prefix)
                    ? criteriaBuilder.like((Expression) pathFunction.apply(root), prefix + "%")
                    : null;
        };
    }

    public static <T> Specification<T> endsWith(SingularAttribute<? super T, String> field, String suffix) {
        return endsWith((r) -> {
            return r.get(field);
        }, suffix);
    }

    public static <T> Specification<T> endsWith(Function<Root<T>, Path<String>> pathFunction, String suffix) {
        return (root, query, criteriaBuilder) -> {
            return StringUtils.hasText(suffix)
                    ? criteriaBuilder.like((Expression) pathFunction.apply(root), "%" + suffix)
                    : null;
        };
    }

    /** @deprecated */
    @Deprecated(forRemoval = true)
    public static <T, V> Specification<T> equal(SingularAttribute<? super T, V> field, V value) {
        return isEqual(field, value);
    }

    public static <T, V> Specification<T> isEqual(SingularAttribute<? super T, V> field, V value) {
        return isEqual((r) -> {
            return r.get(field);
        }, value);
    }

    /** @deprecated */
    @Deprecated(forRemoval = true)
    public static <T, V> Specification<T> equal(PathFunction<T, V> pathFunction, V value) {
        return isEqual(pathFunction, value);
    }

    public static <T, V> Specification<T> isEqual(PathFunction<T, V> pathFunction, V value) {
        return (root, query, criteriaBuilder) -> {
            return value != null ? criteriaBuilder.equal((Expression) pathFunction.apply(root), value) : null;
        };
    }

    /** @deprecated */
    @Deprecated(forRemoval = true)
    public static <T> Specification<T> equal(SingularAttribute<? super T, Boolean> field, Boolean value) {
        return isEqual(field, value);
    }

    public static <T> Specification<T> isEqual(SingularAttribute<? super T, Boolean> field, Boolean value) {
        return isBoolean(field, value);
    }

    /** @deprecated */
    @Deprecated(forRemoval = true)
    public static <T> Specification<T> equal(PathFunction<T, Boolean> pathFunction, Boolean value) {
        return isBoolean(pathFunction, value);
    }

    public static <T> Specification<T> isEqual(PathFunction<T, Boolean> pathFunction, Boolean value) {
        return isBoolean(pathFunction, value);
    }

    public static <T, V> Specification<T> notEqual(SingularAttribute<? super T, V> field, V value) {
        return notEqual((r) -> {
            return r.get(field);
        }, value);
    }

    public static <T, V> Specification<T> notEqual(PathFunction<T, V> pathFunction, V value) {
        return (root, query, criteriaBuilder) -> {
            return value != null ? criteriaBuilder.notEqual((Expression) pathFunction.apply(root), value) : null;
        };
    }

    public static <T, V extends Comparable<? super V>> Specification<T> between(SingularAttribute<? super T, V> field,
            V from, V to) {
        return between((r) -> {
            return r.get(field);
        }, from, to);
    }

    public static <T, V extends Comparable<? super V>> Specification<T> between(PathFunction<T, V> pathFunction, V from,
            V to) {
        return (root, query, criteriaBuilder) -> {
            return from != null && to != null ? criteriaBuilder.between((Expression) pathFunction.apply(root), from, to)
                    : null;
        };
    }

    public static <T, V extends Comparable<? super V>> Specification<T> between(
            SingularAttribute<? super T, V> fromField, SingularAttribute<? super T, V> toField, V value) {
        PathFunction<T, V> from = r -> r.get(fromField);
        PathFunction<T, V> to = r -> r.get(toField);
        return between(from, to, value);
    }

    public static <T, V extends Comparable<? super V>> Specification<T> between(PathFunction<T, V> fromField,
            PathFunction<T, V> toField, V value) {
        return (root, query, criteriaBuilder) -> {
            return value == null ? null
                    : criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo((Expression) fromField.apply(root), value),
                            criteriaBuilder.greaterThanOrEqualTo((Expression) toField.apply(root), value));
        };
    }

    public static <T, V extends Comparable<? super V>> Specification<T> betweenNullable(
            SingularAttribute<? super T, V> fromField, SingularAttribute<? super T, V> toField, V value) {
        return betweenNullable((r) -> {
            return r.get(fromField);
        }, (r) -> {
            return r.get(toField);
        }, value);
    }

    public static <T, V extends Comparable<? super V>> Specification<T> betweenNullable(PathFunction<T, V> fromField,
            PathFunction<T, V> toField, V value) {
        return (root, query, criteriaBuilder) -> {
            return value == null ? null
                    : criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo((Expression) fromField.apply(root), value),
                            criteriaBuilder.or(
                                    criteriaBuilder.greaterThanOrEqualTo((Expression) toField.apply(root), value),
                                    criteriaBuilder.isNull((Expression) toField.apply(root))));
        };
    }

    public static <T, V extends Comparable<? super V>> Specification<T> greaterThan(
            SingularAttribute<? super T, V> field, V value, boolean includeEqual) {
        return greaterThan((r) -> {
            return r.get(field);
        }, value, includeEqual);
    }

    public static <T, V extends Comparable<? super V>> Specification<T> greaterThan(PathFunction<T, V> pathFunction,
            V value, boolean includeEqual) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return null;
            } else {
                return includeEqual ? criteriaBuilder.greaterThanOrEqualTo((Expression) pathFunction.apply(root), value)
                        : criteriaBuilder.greaterThan((Expression) pathFunction.apply(root), value);
            }
        };
    }

    public static <T, V extends Comparable<? super V>> Specification<T> lowerThan(SingularAttribute<? super T, V> field,
            V value, boolean includeEqual) {
        return lowerThan((r) -> {
            return r.get(field);
        }, value, includeEqual);
    }

    public static <T, V extends Comparable<? super V>> Specification<T> lowerThan(PathFunction<T, V> pathFunction,
            V value, boolean includeEqual) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return null;
            } else {
                return includeEqual ? criteriaBuilder.lessThanOrEqualTo((Expression) pathFunction.apply(root), value)
                        : criteriaBuilder.lessThan((Expression) pathFunction.apply(root), value);
            }
        };
    }

    public static <T> Specification<T> isBoolean(SingularAttribute<? super T, Boolean> field, Boolean isTrue) {
        return isBoolean((r) -> {
            return r.get(field);
        }, isTrue);
    }

    public static <T> Specification<T> isBoolean(PathFunction<T, Boolean> pathFunction, Boolean isTrue) {
        return (root, query, criteriaBuilder) -> {
            if (isTrue == null) {
                return null;
            } else {
                return isTrue ? criteriaBuilder.isTrue((Expression) pathFunction.apply(root))
                        : criteriaBuilder.isFalse((Expression) pathFunction.apply(root));
            }
        };
    }

    public static <T> Specification<T> isTrue(SingularAttribute<? super T, Boolean> field) {
        return isBoolean(field, true);
    }

    public static <T> Specification<T> isTrue(PathFunction<T, Boolean> pathFunction) {
        return isBoolean(pathFunction, true);
    }

    public static <T> Specification<T> isFalse(SingularAttribute<? super T, Boolean> field) {
        return isBoolean(field, false);
    }

    public static <T> Specification<T> isFalse(PathFunction<T, Boolean> pathFunction) {
        return isBoolean(pathFunction, false);
    }

    public static <T, V> Specification<T> isNull(SingularAttribute<? super T, V> field, Boolean isNull) {
        return isNull((r) -> {
            return r.get(field);
        }, isNull);
    }

    public static <T, V> Specification<T> isNull(PathFunction<T, V> pathFunction, Boolean isNull) {
        return (root, query, criteriaBuilder) -> {
            if (isNull == null) {
                return null;
            } else {
                return isNull ? criteriaBuilder.isNull((Expression) pathFunction.apply(root))
                        : criteriaBuilder.isNotNull((Expression) pathFunction.apply(root));
            }
        };
    }

    public static <T, V> Specification<T> isNull(SingularAttribute<? super T, V> field) {
        return isNull(field, true);
    }

    public static <T, V> Specification<T> isNull(PathFunction<T, V> pathFunction) {
        return isNull(pathFunction, true);
    }

    public static <T, V> Specification<T> isNotNull(SingularAttribute<? super T, V> field) {
        return isNull(field, false);
    }

    public static <T, V> Specification<T> isNotNull(PathFunction<T, V> pathFunction) {
        return isNull(pathFunction, false);
    }

    public static <T> Specification<T> anyBit(SingularAttribute<? super T, Integer> field, Integer value) {
        return anyBit((r) -> {
            return r.get(field);
        }, value);
    }

    public static <T> Specification<T> anyBit(PathFunction<T, Integer> pathFunction, Integer value) {
        return (root, query, criteriaBuilder) -> {
            return value == null ? null
                    : criteriaBuilder
                            .greaterThan(
                                    criteriaBuilder
                                            .function("BITAND", Integer.class,
                                                    new Expression[] { (Expression) pathFunction.apply(root),
                                                            criteriaBuilder.literal(value) }),
                                    criteriaBuilder.literal(0));
        };
    }

    public static <T> Specification<T> notAnyBit(SingularAttribute<? super T, Integer> field, Integer value) {
        return notAnyBit((r) -> {
            return r.get(field);
        }, value);
    }

    public static <T> Specification<T> notAnyBit(PathFunction<T, Integer> pathFunction, Integer value) {
        return (root, query, criteriaBuilder) -> {
            return value == null ? null
                    : criteriaBuilder.equal(criteriaBuilder.function("BITAND", Integer.class,
                            new Expression[] { (Expression) pathFunction.apply(root), criteriaBuilder.literal(value) }),
                            criteriaBuilder.literal(0));
        };
    }

    @Generated
    private CommonSpecification() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
