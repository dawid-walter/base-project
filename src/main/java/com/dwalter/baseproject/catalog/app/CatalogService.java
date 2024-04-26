package com.dwalter.baseproject.catalog.app;

import com.dwalter.baseproject.catalog.app.port.CatalogUseCase;
import com.dwalter.baseproject.catalog.domain.Book;
import com.dwalter.baseproject.catalog.domain.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class CatalogService implements CatalogUseCase {
    private final CatalogRepository repository;

    @Override
    public List<Book> findByTitle(String title) {
        return repository.findAll()
                .stream()
                .filter(book -> book.getTitle().startsWith(title))
                .toList();
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> findOneByTitleAndAuthor(String title, String author) {
        return repository.findAll()
                .stream()
                .filter(book -> book.getTitle().startsWith(title))
                .filter(book -> book.getAuthor().startsWith(author))
                .findFirst();
    }

    @Override
    public void addBook(CreateBookCommand command) {
        Book bookToAdd = Book.builder()
                .title(command.title())
                .author(command.author())
                .year(command.year())
                .build();
        repository.save(bookToAdd);
    }

    @Override
    public void removeById(Long id) {
        repository.removeById(id);
    }

    @Override
    public UpdateBookResponse updateBook(UpdateBookCommand command) {
        return repository.findById(command.id())
                .map(book -> {
                    Book updatedBook = command.updateFields(book);
                    repository.save(updatedBook);
                    return UpdateBookResponse.SUCCESS;
                })
                .orElseGet(() -> new UpdateBookResponse(false, List.of("Book if id " + command.id() + " is not found")));
    }
}
