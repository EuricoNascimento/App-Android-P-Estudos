package com.example.elricoapp.presentation.books

import com.example.elricoapp.data.model.Book
import com.example.elricoapp.data.network.APIService
import com.example.elricoapp.data.response.BookBodyResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksRepository {

    fun getBooksRetrofit(callback: (lsBooks: List<Book>) -> Unit) {
        APIService.services.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()
                    response.body()?.let { bookBodyResponse ->
                        for (result in bookBodyResponse.booksResultResponses) {
                            val book = Book(
                                title = result.booksdetails[0].title,
                                author = result.booksdetails[0].author,
                                description = result.booksdetails[0].description
                            )
                            books.add(book)
                        }
                        callback.invoke(books)
                    }
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    //coroutine usa suspensao de threads
    suspend fun getBookscoroutine(): List<Book> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Book("Title1", "Author1", ""),
                Book("Title2", "Author2", ""),
                Book("Title3", "Author3", ""),
                Book("Title4", "Author4", ""),
                Book("Title5", "Author5", ""),
            )
        }
    }
}