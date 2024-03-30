package org.oym.newshive.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.oym.newshive.data.remote.INewsApi
import org.oym.newshive.data.remote.NewsPagingSource
import org.oym.newshive.domain.model.Article
import org.oym.newshive.domain.repository.INewsRepository

/**
 * Created by oguzhan.yildirim on 30.03.2024.
 */
class NewsRepositoryImpl(
    private val iNewsApi: INewsApi
) : INewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
       return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    iNewsApi = iNewsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

}