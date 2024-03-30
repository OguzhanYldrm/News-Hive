package org.oym.newshive.data.remote

import org.oym.newshive.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by oguzhan.yildirim on 30.03.2024.
 */
interface INewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ) : NewsResponse

}