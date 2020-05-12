package com.baimahu.repository;

import com.baimahu.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
    List<Book> findByNameLike(String bookName);
}
