package com.trupti.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.trupti.bootrestbook.entities.Book;

@Component
public class BookService {

  private static List<Book> list = new ArrayList<>();
  static {
    list.add(new Book(11, "SpringBoot", "ABC"));
    list.add(new Book(12, "MySql", "Oracle14"));
    list.add(new Book(13, "Python", "SNAKE"));
  }

  // get all books
  public List<Book> getAllBooks() {
    return list;
  }

  // get sinle book id
  public Book getBookById(int id) {
    // used Stream Api java 8
    Book book = null;
    book = list.stream().filter(e -> e.getId() == id).findFirst().get();
    return book;
  }

  // adding book
  public Book addBook(Book b) {
    list.add(b);
    return b;
  }

  // delete book
  public void deleteBook(int bid) {
    list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
  }

  // update book
  public void updateBook(Book book, int bookId) {
    list.stream().map(b -> {
      if (b.getId() == bookId) {
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
      }
      return b;
    }).collect(Collectors.toList());
  }

}
