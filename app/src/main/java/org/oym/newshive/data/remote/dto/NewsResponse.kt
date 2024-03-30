package org.oym.newshive.data.remote.dto


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import org.oym.newshive.domain.model.Article

@Parcelize
data class NewsResponse(
    val articles: List<Article> = listOf(),
    val status: String = "",
    val totalResults: Int = 0
) : Parcelable