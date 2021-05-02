package by.it.academy.animatedimagesearchapp.domain

import androidx.paging.PagingSource
import by.it.academy.animatedimagesearchapp.STARTING_PAGE_INDEX
import by.it.academy.animatedimagesearchapp.api.UnsplashApi
import by.it.academy.animatedimagesearchapp.data.UnsplashPhoto
import retrofit2.HttpException
import java.io.IOException

class PagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String
) : PagingSource<Int, UnsplashPhoto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = unsplashApi.searchPhotos(query, position, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

}