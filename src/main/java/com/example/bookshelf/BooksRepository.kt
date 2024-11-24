package com.example.bookshelf

class BooksRepository(private val api: GoogleBooksApiService) {
    suspend fun searchBooks(query: String): List<BookItem> {
        val response = api.searchBooks(query)
        return response.items
    }
}
