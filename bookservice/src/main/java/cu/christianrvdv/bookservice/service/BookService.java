package cu.christianrvdv.bookservice.service;

import cu.christianrvdv.bookservice.domain.Book;
import cu.christianrvdv.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailableTrue();
    }

    public Book updateBookAvailability(UUID id, boolean available) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setAvailable(available);
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
