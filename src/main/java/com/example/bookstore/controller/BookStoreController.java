package com.example.bookstore.controller;


import com.example.bookstore.entity.BookStore;
import com.example.bookstore.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class BookStoreController {
      @Autowired
      private BookStoreService bookStoreService;

      @GetMapping("/books/")
      public Iterable<BookStore> getAllBooks()
      {
          return  bookStoreService.getBooks();
      }

      @GetMapping("/book/{id}")
      public Optional<BookStore> getBookByid(@PathVariable("id") Long id)
      {
            return bookStoreService.getBook(id);
      }

      @DeleteMapping("/delete/{id}")
      public String DeleteById(@PathVariable("id") Long id)
      {
          bookStoreService.deleteBook(id);
          return "Book "+id+" deleted !";
      }

      @PostMapping("/create/")
      public String createNewBook(@RequestBody  BookStore bookStore)
      {
          bookStoreService.create(bookStore);
          return "Book Created Successfully";
      }

      @PutMapping("/modifier/{id}")
      public BookStore modifyBookInfo(@PathVariable("id") Long id, @RequestBody  BookStore bookStore)
      {
          return bookStoreService.modifier(id, bookStore);
      }
}
