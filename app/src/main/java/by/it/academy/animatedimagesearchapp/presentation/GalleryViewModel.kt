package by.it.academy.animatedimagesearchapp.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import by.it.academy.animatedimagesearchapp.DEFAULT_QUERY
import by.it.academy.animatedimagesearchapp.data.PhotoRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: PhotoRepository
) : ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }
}