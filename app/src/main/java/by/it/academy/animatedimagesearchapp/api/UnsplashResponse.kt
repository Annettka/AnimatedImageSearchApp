package by.it.academy.animatedimagesearchapp.api

import by.it.academy.animatedimagesearchapp.data.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)