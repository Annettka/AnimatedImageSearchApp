package by.it.academy.animatedimagesearchapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import by.it.academy.animatedimagesearchapp.api.UnsplashApi
import by.it.academy.animatedimagesearchapp.domain.PagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepository @Inject constructor(private val unsplashApi: UnsplashApi) {
    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PagingSource(unsplashApi, query) }
        ).liveData
}