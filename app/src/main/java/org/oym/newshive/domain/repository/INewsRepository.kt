package org.oym.newshive.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.oym.newshive.domain.model.Article

/**
 * Created by oguzhan.yildirim on 30.03.2024.
 */
interface INewsRepository {

    fun getNews(sources: List<String>) : Flow<PagingData<Article>>

}