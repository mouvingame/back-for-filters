package by.loiko.filtersbackend.services;

import by.loiko.filtersbackend.exceptions.NotUniqueDataException;
import by.loiko.filtersbackend.model.Filter;
import by.loiko.filtersbackend.repositories.FilterRepository;
import org.springframework.stereotype.Service;

@Service
public class FilterService {
    private FilterRepository filterRepository;

    public FilterService(FilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    public Filter create(Filter newest) throws NotUniqueDataException {
        if (filterRepository.existsByName(newest.getName()))
            throw new NotUniqueDataException("Filter with name '" + newest.getName() + "' already exists");

        return filterRepository.save(newest);
    }

    public Iterable<Filter> getAll() {
        return filterRepository.findAll();
    }
}
