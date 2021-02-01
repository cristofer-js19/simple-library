package br.com.library.controller

import br.com.library.model.Book
import br.com.library.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController(
    private val bookService: BookService) {

    @GetMapping
    fun list(): ResponseEntity<List<Book>> {
        return ResponseEntity.ok(bookService.all())
    }

    @PostMapping
    fun add(@RequestBody book: Book): ResponseEntity<Book> {
        return ResponseEntity.ok(bookService.save(book))
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody book: Book): ResponseEntity<Book> {
        if (bookService.existsById(id)) {
            return ResponseEntity.ok(bookService.alter(id, book))
        }

        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        if (bookService.existsById(id)) {
            bookService.deleteById(id)
            return ResponseEntity.ok().build()
        }

        return ResponseEntity.notFound().build()
    }
}