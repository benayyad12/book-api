package com.example.bookstore.service;

import com.example.bookstore.dao.BookStoreRepository;
import com.example.bookstore.entity.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreService {
    @Autowired
    private BookStoreRepository bookStoreRepository;

    public Iterable<BookStore> getBooks(){
        return bookStoreRepository.findAll();
    }

    public Optional<BookStore> getBook(Long id)
    {
        return bookStoreRepository.findById(id);
    }

    public BookStore create(BookStore bookStore) {
        BookStore savedStore = bookStoreRepository.save(bookStore);
        return savedStore;
    }

    public void deleteBook(Long id)
    {
        bookStoreRepository.deleteById(id);
    }

    public BookStore modifier(Long id, BookStore bookStore)
    {
        return bookStoreRepository.findById(id).map(
                e->{
                    e.setAuthor(bookStore.getAuthor());
                    e.setTitle(bookStore.getTitle());
                    return bookStoreRepository.save(e);
                }).orElseThrow(() -> new RuntimeException("Book Not found !!!"));
    }
}
