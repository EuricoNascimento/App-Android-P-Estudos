package com.example.elricoapp.presentation.details

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.elricoapp.R
import kotlinx.android.synthetic.main.activity_book_details.*
import kotlinx.android.synthetic.main.activity_books.*


class BookDetailsActivity {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        toolbarMain2.apply {
            title = "New York Books"
        }setSupportActionBar(toolbarMain)

        tv_booksdescription_title_content.text = intent.getStringExtra(EXTRA_TITLE)
        tv_bookdetails_description_content.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(context: Context, title: String, description: String)
        : Intent{

            return Intent(Context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }

        }
    }    
}
