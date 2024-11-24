package com.example.bookshelf
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment

@Composable
fun BookshelfScreen(viewModel: BooksViewModel = viewModel()) {
    val books = viewModel.books.collectAsState().value

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Déclencher la recherche au démarrage
        viewModel.searchBooks("android development")

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(books.size) { index ->
                val book = books[index]
                BookItem(book)
            }
        }
    }
}

@Composable
fun BookItem(book: BookItem) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = book.volumeInfo.imageLinks?.thumbnail?.replace("http", "https"),
            contentDescription = "Book Cover",
            modifier = Modifier.size(128.dp)
        )
        Text(
            text = book.volumeInfo.title,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
