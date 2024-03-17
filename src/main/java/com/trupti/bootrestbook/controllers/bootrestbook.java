package com.trupti.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trupti.bootrestbook.entities.Book;
import com.trupti.bootrestbook.services.BookService;

@RestController
public class bootrestbook {

  @Autowired
  private BookService bookService;

  // get all books handler
  @GetMapping("/books")
  public List<Book> getBooks() {
    return this.bookService.getAllBooks();
  }

  // get single book handler
  @GetMapping("/books/{id}")
  public Book getBook(@PathVariable("id") int id) {
    return bookService.getBookById(id);
  }

  // create book handler
  @PostMapping("/books")
  public Book addBook(@RequestBody Book book) {
    Book b = this.bookService.addBook(book);
    System.out.println(book);
    return b;
  }

  // delete book handler
  @DeleteMapping("/books/{bookId}")
  public void deleteBook(@PathVariable("bookId") int bookId) {
    this.bookService.deleteBook(bookId);
  }

  // update book handler
  @PutMapping("/books/{bookId}")
  public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
    this.bookService.updateBook(book, bookId);
    return book;
  }

}
