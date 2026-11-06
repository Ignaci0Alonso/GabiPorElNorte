package app.gabiporelnorte.gabiporelnorte.bussiness.shared.function;

import java.util.function.Function;

import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

@FunctionalInterface 
public interface PathFunction<T, V> extends Function<Root<T>, Path<V>> {

}
