
package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialiser le repository et le ViewModel
        val repository = BooksRepository(RetrofitInstance.api)

        setContent {
            val factory = BooksViewModelFactory(repository)
            val viewModel: BooksViewModel = viewModel(factory = factory)


            BookshelfScreen(viewModel = viewModel)
        }
    }
}
