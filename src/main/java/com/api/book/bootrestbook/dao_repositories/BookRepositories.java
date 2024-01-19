package com.api.book.bootrestbook.dao_repositories;
import org.springframework.data.repository.CrudRepository;
import com.api.book.bootrestbook.entities_models.Book;

public interface BookRepositories extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
