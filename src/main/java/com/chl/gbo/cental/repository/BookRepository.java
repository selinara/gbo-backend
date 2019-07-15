package com.chl.gbo.cental.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chl.gbo.cental.domain.Book;

/**
 * @Auther: BoYanG
 * @Describe interface
 * @Date 2019/6/12 15:46
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByName(String name);
}
