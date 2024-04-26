package com.dwalter.baseproject.catalog.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogRepository {
    List<Book> findAll();

    void save(Book book);

    Optional<Book> findById(Long id);

    void removeById(Long id);
}
