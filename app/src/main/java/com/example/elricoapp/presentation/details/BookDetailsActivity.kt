package com.example.elricoapp.presentation.details

import android.app.Notification.EXTRA_TITLE
import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import com.example.elricoapp.presentation.books.BooksViewModel
import androidx.lifecycle.Observer
import com.example.elricoapp.R
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.activity_books.toolbarMain
import kotlinx.android.synthetic.main.activity_books_details.*

class BookDetailsActivity : AppCompatActivity() {
    private lateinit var viewModel: BooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_details)

        toolbarMain2.apply {
        title = "New York Books"

    }
        setSupportActionBar(toolbarMain)

        tv_booksdesciption_title_content.text = intent.getStringExtra(EXTRA_TITLE)
        tv_booksdetails_description.text = intent.getStringArrayExtra((EXTRA_DESCRIPTION))
}

    companion object{
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(context: Context, title: String, description: String): Intent {
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }

    }
}
