package com.example.elricoapp.presentation.books

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elricoapp.R
import com.example.elricoapp.presentation.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books.*


class BooksActivity: AppCompatActivity() {

    private lateinit var viewModel: BooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toolbarMain.apply {
            title = getString("New York Books")
        }setSupportActionBar(toolbarMain)


        viewModel = ViewModelProvider(this,
        BooksViewModel.BooksViewModelFactory(BooksRepository())
        ).get((BooksViewModel::class.java))


        viewModel.booksLiveData.observe(this, {
            it?.let {books -> with(rv_books) {

                    layoutManager = LinearLayoutManager(
                        this@BooksActivity,
                        androidx.recyclerview.widget.RecyclerView.VERTICAL,
                        false
                    )

                    adapter = BooksAdapter(books) {book -> 
                        val intent = BookDetailsActivity.getStartIntent(
                            this@BooksActivity,book.title,book.description
                        )

                        this@BooksActivity.startActivity(intent)
                    }
                    
                    setHasFixedSize(true)
                }
            }
        })
        
        viewModel.getBooks()
    }
}
