package com.example.elricoapp.presentation.books
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.elricoapp.R
import com.example.elricoapp.data.model.Book

class BooksAdapter (
    private val books: List<Book>,
    val onItemClickListener: ((book: Book) -> Unit)
): RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_books, parent, false)
        return BooksViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(Viewholder: BooksViewHolder, position: Int) {
        val book = books[position]
        RecyclerView.ViewHolder.bindView(book)
    }

    override fun getItemCount() = books.count()

    class BooksViewHolder(itemView: View, val onItemClickListener: (book: Book) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val title = itemView.tv_title
        private val author = itemView.tv_autor

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author

            itemView.setOnClickListener {
                onItemClickListener.invoke(book)
            }
        }
    }
}