package com.example.demo.book.db.repository;

import com.example.demo.book.db.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
