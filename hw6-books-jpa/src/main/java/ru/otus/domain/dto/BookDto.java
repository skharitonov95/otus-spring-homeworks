package ru.otus.domain.dto;

import ru.otus.domain.Book;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookDto {
	private final Long id;
	private final String name;
	private final Date publicationDate;
	private final int printLength;
	private final AuthorDto author;
	private final GenreDto genre;
	private final List<CommentDto> comments;

	public BookDto(final Book book) {
		this.id = book.getId();
		this.name = book.getName();
		this.publicationDate = book.getPublicationDate();
		this.printLength = book.getPrintLength();
		this.author = new AuthorDto(book.getAuthor());
		this.genre = new GenreDto(book.getGenre());
		this.comments = book.getComments()
				.stream()
				.map(CommentDto::new)
				.collect(Collectors.toList());
	}

	private BookDto(final Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.publicationDate = builder.publicationDate;
		this.printLength = builder.printLength;
		this.author = builder.author;
		this.genre = builder.genre;
		this.comments = builder.comments;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public int getPrintLength() {
		return printLength;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public GenreDto getGenre() {
		return genre;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	@Override
	public String toString() {
		return "BookDto{" +
				"id=" + id +
				", name='" + name + '\'' +
				", publicationDate=" + publicationDate +
				", printLength=" + printLength +
				", author=" + author +
				", genre=" + genre +
				", comments=" + comments +
				'}';
	}

	public static class Builder {
		private Long id;
		private String name;
		private Date publicationDate;
		private int printLength;
		private AuthorDto author;
		private GenreDto genre;
		private List<CommentDto> comments;

		public Builder id(final Long id) {
			this.id = id;
			return this;
		}

		public Builder name(final String name) {
			this.name = name;
			return this;
		}

		public Builder publicationDate(final Date publicationDate) {
			this.publicationDate = publicationDate;
			return this;
		}

		public Builder printLength(final int printLength) {
			this.printLength = printLength;
			return this;
		}

		public Builder author(final AuthorDto author) {
			this.author = author;
			return this;
		}

		public Builder genre(final GenreDto genre) {
			this.genre = genre;
			return this;
		}

		public Builder comments(final List<CommentDto> comments) {
			this.comments = comments;
			return this;
		}

		public BookDto build() {
			return new BookDto(this);
		}
	}
}
