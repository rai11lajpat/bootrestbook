package com.api.book.bootrestbook.controlers;

import java.util.List;
import java.util.Optional;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities_models.Book;
import com.api.book.bootrestbook.services.BookService;

//@Controller
@RestController
// @CrossOrigin(origins="*")
public class BookControlers {

    private final static Logger log=Logger.getLogger(BookControlers.class);


    // @RequestMapping(value = "/book",method =RequestMethod.GET)
    @GetMapping("/test")
    // @ResponseBody
    public String test() {

        String data="suceess";
        log.info("TestController test_cont ::"+data);

        return "this is test first book";
        
    }

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> list = bookService.getAllBook();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        log.info("BookController get all-Book ::"+ResponseEntity.of(Optional.of(list)));
        return ResponseEntity.of(Optional.of(list));
    }

    // /book?id==id
    // @GetMapping("/book")
    // public Book getSingleBook(int id){
    // return this.bookService.getSingleBook(id);
    // }


    // OR /book/id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getSingleBook(@PathVariable int id) {
        Book book = this.bookService.getSingleBook(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable int id) {
        try {
            this.bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book b, @PathVariable int id) {
        try {
            this.bookService.updateBook(b, id);
            return ResponseEntity.ok().body(b);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
