package com.example.elricoapp.presentation.books

//import ...

class BooksViewModel(private val repository: BooksRepository): ViewModel {

    val booksLiveData = MutableLiveData<List<Book>>()

    fun getBooks() {
        repository.getBooksRetrofit {
            booksLiveData.postValue(it)
        }
    }

    fun getBooksCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val lsBooks = withContext(Dispatchers.Default) {
                repository.getBooksCoroutines()
            }

            booksLiveData.value = lsBooks
        }
    }

    class BooksViewModelFactory(
        private val repository: BooksRepository
    ) : ViewModelProvider.Factory{
        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
            return BooksViewModel(repository) as T
        }
    }

}