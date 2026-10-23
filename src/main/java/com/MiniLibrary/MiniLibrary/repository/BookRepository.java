
package com.MiniLibrary.MiniLibrary.repository;

import com.MiniLibrary.MiniLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByGoogleBooksId(String googleBooksId);

}

