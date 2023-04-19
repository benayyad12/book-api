package com.example.bookstore.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="bookstore")
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;

}
