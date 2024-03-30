package org.oym.newshive.domain.usecases.app_entry

import kotlinx.coroutines.flow.Flow
import org.oym.newshive.domain.manager.ILocalUserManager

/**
 * Created by oguzhan.yildirim on 16.02.2024.
 */
class ReadAppEntry(private val iLocalUserManager : ILocalUserManager) {

    operator fun invoke() : Flow<Boolean> {
        return iLocalUserManager.readAppEntry()
    }

}