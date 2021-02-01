package br.com.library

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleLibraryApplication

fun main(args: Array<String>) {
	runApplication<SimpleLibraryApplication>(*args)
}
