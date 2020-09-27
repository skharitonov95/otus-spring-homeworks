package ru.otus.dao;

import ru.otus.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorsDao {
	Optional<Long> saveAuthor(Author author);

	Optional<Author> findAuthorById(long id);

	List<Author> findAllAuthors();

	void removeAuthor(long id);

	void updateAuthor(Author author);
}
