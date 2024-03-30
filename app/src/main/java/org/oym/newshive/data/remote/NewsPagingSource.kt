package org.oym.newshive.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.oym.newshive.BuildConfig
import org.oym.newshive.domain.model.Article
import java.lang.Exception

/**
 * Created by oguzhan.yildirim on 30.03.2024.
 */
class NewsPagingSource (
    private val iNewsApi: INewsApi,
    private val sources: String
) : PagingSource<Int, Article>() {

    private var totalNewsCount = 0

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1

        return try {
            val newsResponse = iNewsApi.getNews(sources = sources, page = page, apiKey = BuildConfig.NEWSKEY)
            totalNewsCount+= newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

}