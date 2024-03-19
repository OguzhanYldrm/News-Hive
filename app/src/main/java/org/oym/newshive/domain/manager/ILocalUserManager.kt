package org.oym.newshive.domain.manager

import kotlinx.coroutines.flow.Flow

/**
 * Created by oguzhan.yildirim on 16.02.2024.
 */
interface ILocalUserManager {

    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>

}