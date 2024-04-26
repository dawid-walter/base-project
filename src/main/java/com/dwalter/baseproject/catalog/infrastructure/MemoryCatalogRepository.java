package com.dwalter.baseproject.catalog.infrastructure;

import com.dwalter.baseproject.catalog.domain.Book;
import com.dwalter.baseproject.catalog.domain.CatalogRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
class MemoryCatalogRepository implements CatalogRepository {
    private final Map<Long, Book> storage = new ConcurrentHashMap<>();
    private final AtomicLong NEXT_ID_VALUE = new AtomicLong(0L);

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void save(Book book) {
        storage.put(NEXT_ID_VALUE.incrementAndGet(), book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void removeById(Long id) {
        storage.remove(id);
    }
}
