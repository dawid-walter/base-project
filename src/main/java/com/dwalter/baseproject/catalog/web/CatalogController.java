package com.dwalter.baseproject.catalog.web;

import com.dwalter.baseproject.catalog.app.port.CatalogUseCase;
import com.dwalter.baseproject.catalog.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
class CatalogController {
    private final CatalogUseCase catalog;

    @GetMapping
    public List<Book> getAll() {
        return catalog.findAll();
    }

    @GetMapping(params = {"title"})
    public List<Book> getAllFiltered(@RequestParam Optional<String> title) {
        return catalog.findByTitle(title.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        return catalog.
                findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
