package org.oym.newshive.domain.usecases

import kotlinx.coroutines.flow.Flow
import org.oym.newshive.domain.manager.ILocalUserManager

/**
 * Created by oguzhan.yildirim on 16.02.2024.
 */
class ReadAppEntry(private val iLocalUserManager : ILocalUserManager) {

    suspend operator fun invoke() : Flow<Boolean> {
        return iLocalUserManager.readAppEntry()
    }

}