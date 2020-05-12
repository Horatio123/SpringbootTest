package com.baimahu;

import static org.junit.Assert.assertTrue;

import com.baimahu.bean.Book;
import com.baimahu.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Unit test for simple App.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ESApplicationTest
{
    @Autowired
    BookRepository bookRepository;

    @Test
    public void testES() {
        Book book = new Book(3, "Spring", 9.9);
        bookRepository.index(book);
    }

    @Test
    public void findES() {
        List<Book> books = bookRepository.findByNameLike("Tit");
        for (Book book: books) {
            System.out.println(book);
        }
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
