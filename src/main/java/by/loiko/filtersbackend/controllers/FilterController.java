package by.loiko.filtersbackend.controllers;

import by.loiko.filtersbackend.exceptions.NotUniqueDataException;
import by.loiko.filtersbackend.model.Filter;
import by.loiko.filtersbackend.services.FilterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping("api/filters")
public class FilterController {
    private FilterService filterService;

    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    @PostMapping
    public ResponseEntity<Filter> create(@RequestBody Filter newest) {
        try {
            return new ResponseEntity<>(filterService.create(newest), HttpStatus.CREATED);
        } catch (NotUniqueDataException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Filter>> getAll() {
        return ResponseEntity.ok(filterService.getAll());
    }
}
