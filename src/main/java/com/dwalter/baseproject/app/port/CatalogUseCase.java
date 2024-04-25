package com.dwalter.baseproject.app.port;

import com.dwalter.baseproject.domain.Book;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

public interface CatalogUseCase {
    List<Book> findByTitle(String title);

    List<Book> findAll();

    Optional<Book> findOneByTitleAndAuthor(String title, String author);

    void addBook(CreateBookCommand command);

    void removeById(Long id);

    UpdateBookResponse updateBook(UpdateBookCommand command);

    record CreateBookCommand(String title, String author, Integer year) {
    }

    record UpdateBookCommand(Long id, String title, String author, Integer year) {
        public Book updateFields(Book book) {
            Book.BookBuilder builder = Book.builder();
            if (title != null) {
                builder.title(title);
            }
            if (author != null) {
                builder.author(author);
            }
            if (year != null) {
                builder.year(year);
            }
            return builder.build();
        }
    }

    record UpdateBookResponse(boolean success, List<String> errors) {
        public static UpdateBookResponse SUCCESS = new UpdateBookResponse(true, emptyList());
    }
}
