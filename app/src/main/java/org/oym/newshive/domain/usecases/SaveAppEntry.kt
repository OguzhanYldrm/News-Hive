package org.oym.newshive.domain.usecases

import org.oym.newshive.domain.manager.ILocalUserManager
import org.oym.newshive.enums.EntryStatus

/**
 * Created by oguzhan.yildirim on 16.02.2024.
 */
class SaveAppEntry(private val iLocalUserManager : ILocalUserManager) {

    suspend operator fun invoke(entryStatus: EntryStatus) {
        iLocalUserManager.saveAppEntry(entryStatus)
    }

}