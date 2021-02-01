package br.com.library.service

import br.com.library.model.Book
import br.com.library.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository) {

    fun all(): List<Book> {
        return bookRepository.findAll().toList()
    }

    fun deleteById(id: Long) {
        bookRepository.deleteById(id);
    }

    fun existsById(id: Long): Boolean {
        return bookRepository.existsById(id)
    }

    fun save(book: Book): Book {
        return bookRepository.save(book)
    }

    fun alter(id: Long, book: Book): Book {
        var safeBook = book.copy(id = id)
        return save(safeBook)
    }
}