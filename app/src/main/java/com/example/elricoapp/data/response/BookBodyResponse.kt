package com.example.elricoapp.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data  class BookBodyResponse (
    @SerializedName("results")
    @Expose
    val booksResultResponses: List<BooksResultsResponse>
 )
data class BooksResultsResponse(
 @SerializedName("book_details")
 @Expose
   val booksdetails: List<BooksDetails>
)
data class BooksDetails(
     @SerializedName("title")
     @Expose
     val title: String,

     @SerializedName("author")
     @Expose
     val author: String,

     @SerializedName("description")
     @Expose
     val description: String


)



