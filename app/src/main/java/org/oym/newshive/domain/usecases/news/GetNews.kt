package org.oym.newshive.domain.usecases.news

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.oym.newshive.domain.model.Article
import org.oym.newshive.domain.repository.INewsRepository

/**
 * Created by oguzhan.yildirim on 30.03.2024.
 */
class GetNews(
    private val iNewsRepository: INewsRepository
) {

    operator fun invoke(sources: List<String>) : Flow<PagingData<Article>> {
        return iNewsRepository.getNews(sources = sources)
    }

}