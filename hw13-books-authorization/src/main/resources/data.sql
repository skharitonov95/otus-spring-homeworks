INSERT INTO AUTHORS (NAME, SURNAME)
VALUES ('Karen', 'Osborne');
INSERT INTO GENRES (NAME)
VALUES ('Fantasy');
INSERT INTO BOOKS (AUTHOR_ID, GENRE_ID, NAME, PUBLICATION_DATE, PRINT_LENGTH)
VALUES (AUTHORS_S.CURRVAL, GENRES_S.CURRVAL, 'Architects of Memory', SYSDATE, 345);

INSERT INTO BOOKS_COMMENTS (BOOK_ID, TEXT)
VALUES (BOOKS_S.CURRVAL, 'perfect book!');
INSERT INTO BOOKS_COMMENTS (BOOK_ID, TEXT)
VALUES (BOOKS_S.CURRVAL, 'amazing book!');
INSERT INTO BOOKS_COMMENTS (BOOK_ID, TEXT)
VALUES (BOOKS_S.CURRVAL, 'interesting book!');

INSERT INTO BOOKS (AUTHOR_ID, GENRE_ID, NAME, PUBLICATION_DATE, PRINT_LENGTH)
VALUES (AUTHORS_S.CURRVAL, GENRES_S.CURRVAL, 'Engines of Oblivion', SYSDATE, 500);

INSERT INTO AUTHORS (NAME, SURNAME)
VALUES ('Robert', 'Martin');
INSERT INTO GENRES (NAME)
VALUES ('Programming Languages');
INSERT INTO BOOKS (AUTHOR_ID, GENRE_ID, NAME, PUBLICATION_DATE, PRINT_LENGTH)
VALUES (AUTHORS_S.CURRVAL, GENRES_S.CURRVAL, 'Clean Code: A Handbook of Agile Software Craftsmanship', SYSDATE, 447);
INSERT INTO BOOKS (AUTHOR_ID, GENRE_ID, NAME, PUBLICATION_DATE, PRINT_LENGTH)
VALUES (AUTHORS_S.CURRVAL, GENRES_S.CURRVAL,
        'Clean Architecture: A Craftsman''s Guide to Software Structure and Design', SYSDATE, 430);

INSERT INTO AUTHORS (NAME, SURNAME)
VALUES ('Maxim', 'Loskutoff');
INSERT INTO GENRES (NAME)
VALUES ('Literature');
INSERT INTO BOOKS (AUTHOR_ID, GENRE_ID, NAME, PUBLICATION_DATE, PRINT_LENGTH)
VALUES (AUTHORS_S.CURRVAL, GENRES_S.CURRVAL, 'Ruthie Fear: A Novel', SYSDATE, 304);
INSERT INTO BOOKS (AUTHOR_ID, GENRE_ID, NAME, PUBLICATION_DATE, PRINT_LENGTH)
VALUES (AUTHORS_S.CURRVAL, GENRES_S.CURRVAL, 'Come West and See: Stories', SYSDATE, 240);

INSERT INTO AUTHORS (NAME, SURNAME)
VALUES ('Nicholas', 'Sparks');
INSERT INTO GENRES (NAME)
VALUES ('Romance');
INSERT INTO BOOKS (AUTHOR_ID, GENRE_ID, NAME, PUBLICATION_DATE, PRINT_LENGTH)
VALUES (AUTHORS_S.CURRVAL, GENRES_S.CURRVAL, 'The Return', SYSDATE, 368);
INSERT INTO BOOKS (AUTHOR_ID, GENRE_ID, NAME, PUBLICATION_DATE, PRINT_LENGTH)
VALUES (AUTHORS_S.CURRVAL, GENRES_S.CURRVAL, 'The Rescue', SYSDATE, 364);

INSERT INTO USERS (USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED)
VALUES ('s-kharitonov', '$2y$12$BWmimlJlt0jTF6VhMylA9uUwAxNd0tIhaUxPFtpJRnPzCpDMIfovu', true, true, true, true);

INSERT INTO AUTHORITIES (AUTHORITY)
VALUES ('ROLE_USER');

INSERT INTO USER_AUTHORITIES (USER_ID, AUTHORITY_ID)
VALUES (USERS_S.CURRVAL, AUTHORITIES_S.CURRVAL);