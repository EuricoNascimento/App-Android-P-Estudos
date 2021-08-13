package com.example.elricoapp.presentation.details

import android.content.Context
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

        /*toolbarMain2.apply {
            title = "New York Books"
        }*/
        setSupportActionBar(toolbarMain)

        tv_booksdescription_title_content.text = intent.getStringExtra(EXTRA_TITLE)
        tv_bookdetails_description_content.text = intent.getStringExtra(EXTRA_DESCRIPTION)
    }

}