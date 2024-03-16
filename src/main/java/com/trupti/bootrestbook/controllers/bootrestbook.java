package com.trupti.bootrestbook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trupti.bootrestbook.entities.Book;

@RestController
public class bootrestbook {
  @GetMapping("/books")
  public Book getBooks() {
    Book book = new Book();
    book.setId(202401);
    book.setTitle("Java 21");
    book.setAuthor("Bishesh");
    return book;
  }

}
