package ru.otus.controllers;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.domain.Comment;
import ru.otus.domain.Constants;
import ru.otus.services.CommentsService;
import ru.otus.services.LocalizationService;
import ru.otus.services.facades.BookCommentsFacade;

import java.util.Objects;
import java.util.stream.Collectors;

@ShellComponent
public class CommentsController {

	private final CommentsService commentsService;
	private final LocalizationService localizationService;
	private final BookCommentsFacade bookCommentsFacade;

	public CommentsController(final CommentsService commentsService,
							  final LocalizationService localizationService,
							  final BookCommentsFacade bookCommentsFacade) {
		this.commentsService = commentsService;
		this.localizationService = localizationService;
		this.bookCommentsFacade = bookCommentsFacade;
	}

	@ShellMethod(value = "create comment", group = "comments", key = {"c-c", "create-comment"})
	public String create(@ShellOption(help = "enter comment") String text) {
		var comment = new Comment.Builder().text(text).build();

		commentsService.save(comment);

		if (Objects.nonNull(comment.getId())) {
			return String.valueOf(comment);
		} else {
			return localizationService.localizeMessage(Constants.COMMENT_UNSUCCESSFUL_CREATED_MSG_KEY, comment);
		}
	}

	@ShellMethod(value = "create book comment", group = "comments", key = {"c-b-c", "create-book-comment"})
	public String createBookComment(@ShellOption(help = "enter exist book id") long bookId,
									@ShellOption(help = "enter comment") String text) {
		var comment = new Comment.Builder().text(text).build();

		bookCommentsFacade.save(bookId, comment);

		if (Objects.nonNull(comment.getId())) {
			return String.valueOf(comment);
		} else {
			return localizationService.localizeMessage(Constants.COMMENT_UNSUCCESSFUL_CREATED_MSG_KEY, comment);
		}
	}

	@ShellMethod(value = "update comment", group = "comments", key = {"u-c", "update-comment"})
	public String update(@ShellOption(help = "enter comment id") long id,
						 @ShellOption(help = "enter comment") String text) {
		var comment = new Comment.Builder()
				.id(id)
				.text(text)
				.build();

		commentsService.save(comment);

		return String.valueOf(comment);
	}

	@ShellMethod(value = "get comment by id", group = "comments", key = {"r-c", "read-comment"})
	public String getById(@ShellOption(help = "enter comment id") long id) {
		return commentsService.getById(id)
				.map(String::valueOf)
				.orElse(localizationService.localizeMessage(Constants.COMMENT_NOT_FOUND_MSG_KEY, id));
	}

	@ShellMethod(value = "get all comments", group = "comments", key = {"r-a-c", "read-all-comments"})
	public String getAll() {
		return commentsService.getAll().stream()
				.map(Comment::toString)
				.collect(Collectors.joining(System.lineSeparator()));
	}

	@ShellMethod(value = "remove comment by id", group = "comments", key = {"d-c", "delete-comment"})
	public String removeById(@ShellOption(help = "delete comment by id") long id) {
		if (commentsService.removeById(id)) {
			return localizationService.localizeMessage(Constants.COMMENT_SUCCESSFUL_REMOVED_MSG_KEY, id);
		} else {
			return localizationService.localizeMessage(Constants.COMMENT_UNSUCCESSFUL_REMOVED_MSG_KEY, id);
		}
	}
}
