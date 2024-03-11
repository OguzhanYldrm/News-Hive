package org.oym.newshive.domain.manager

import kotlinx.coroutines.flow.Flow
import org.oym.newshive.enums.EntryStatus

/**
 * Created by oguzhan.yildirim on 16.02.2024.
 */
interface ILocalUserManager {

    suspend fun saveAppEntry(entryStatus: EntryStatus)

    fun readAppEntry(): Flow<Boolean>

}