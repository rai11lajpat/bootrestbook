package com.api.book.bootrestbook.services;
import com.api.book.bootrestbook.dao_repositories.BookRepositories;
import com.api.book.bootrestbook.entities_models.Book;
// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    @Autowired
    private BookRepositories bookRepositories;
    // private static List<Book> list=new ArrayList<>();
    // static{
    //     list.add(new Book(1, "java", "james"));
    //     list.add(new Book(2, "c", "xy"));
    //     list.add(new Book(3, "python", "asd"));
    // }

    //get All book
    public List<Book> getAllBook(){

        // type cast
        List<Book> list=(List<Book>)this.bookRepositories.findAll();
       return list;
    }

    //get sinle particular book
    public Book getSingleBook(int id){

        Book book=null;
        try{
        // book=list.stream().filter(e->e.getId()==id).findFirst().get();
        book=this.bookRepositories.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book book){
        // list.add(book);
        Book b= this.bookRepositories.save(book);
        return b;
    }

    public void deleteBook(int id){
        // b=list.stream().filter(e->e.getId()==id).findFirst().get();
        // list.remove(b);
        this.bookRepositories.deleteById(id);
    }

    public void updateBook(Book b,int id){
        // list = list.stream().map(e->{
        //     if(e.getId()==id){
        //         e.setAuthor(b.getAuthor());
        //         e.setBoookName(b.getBoookName());
        //     }
        //     return e;
        // }).collect(Collectors.toList());
        b.setId(id);
        bookRepositories.save(b);
    }
}
