package com.example.bookstore.dao;

import com.example.bookstore.entity.BookStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookStoreRepository extends CrudRepository<BookStore, Long> {
}
