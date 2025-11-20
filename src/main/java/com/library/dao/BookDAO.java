package com.library.dao;

import com.library.model.Book;
import java.util.*;

public class BookDAO {

    private final String filePath = "src/main/resources/books.txt";

    public List<Book> getAllBooks() {
        List<String> lines = FileDatabase.readData(filePath);
        List<Book> books = new ArrayList<>();
        for (String line : lines) {
            String[] arr = line.split(",");
            Book book = new Book(arr[0], arr[1], arr[2]);
            book.setIssued(Boolean.parseBoolean(arr[3]));
            books.add(book);
        }
        return books;
    }

    public void saveBooks(List<Book> books) {
        List<String> lines = new ArrayList<>();
        for (Book b : books) {
            lines.add(b.getBookId() + "," + b.getTitle() + "," + b.getAuthor() + "," + b.isIssued());
        }
        FileDatabase.writeData(filePath, lines);
    }

    public void addBook(Book book) {
        List<Book> books = getAllBooks();
        books.add(book);
        saveBooks(books);
    }
}
