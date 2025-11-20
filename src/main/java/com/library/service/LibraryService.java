package com.library.service;

import com.library.dao.BookDAO;
import com.library.dao.UserDAO;
import com.library.exceptions.BookNotFoundException;
import com.library.exceptions.UserNotFoundException;
import com.library.model.Book;
import com.library.model.User;
import java.util.*;

public class LibraryService {

    private final BookDAO bookDAO = new BookDAO();
    private final UserDAO userDAO = new UserDAO();

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public Book findBookById(String bookId) {
        return bookDAO.getAllBooks().stream()
                .filter(b -> b.getBookId().equals(bookId))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    public User findUserById(String userId) {
        return userDAO.getAllUsers().stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public void issueBook(String bookId, String userId) {
        Book book = findBookById(bookId);
        if (book.isIssued()) throw new RuntimeException("Book already issued");
        findUserById(userId);
        book.setIssued(true);
        updateBook(book);
    }

    public void returnBook(String bookId) {
        Book book = findBookById(bookId);
        if (!book.isIssued()) throw new RuntimeException("Book is not issued");
        book.setIssued(false);
        updateBook(book);
    }

    private void updateBook(Book updatedBook) {
        List<Book> books = bookDAO.getAllBooks();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(updatedBook.getBookId())) {
                books.set(i, updatedBook);
                break;
            }
        }
        bookDAO.saveBooks(books);
    }
}
