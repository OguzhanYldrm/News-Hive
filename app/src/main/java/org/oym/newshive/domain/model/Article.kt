package org.oym.newshive.domain.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Article(
    val author: String? = "",
    val content: String = "",
    val description: String? = "",
    val publishedAt: String = "",
    val source: Source = Source(),
    val title: String = "",
    val url: String = "",
    val urlToImage: String? = ""
) : Parcelable