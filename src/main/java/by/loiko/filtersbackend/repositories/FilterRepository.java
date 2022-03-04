package by.loiko.filtersbackend.repositories;

import by.loiko.filtersbackend.model.Filter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends CrudRepository<Filter, Long> {
    boolean existsByName(String name);
}
