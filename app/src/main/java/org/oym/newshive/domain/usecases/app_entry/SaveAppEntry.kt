package org.oym.newshive.domain.usecases.app_entry

import org.oym.newshive.domain.manager.ILocalUserManager

/**
 * Created by oguzhan.yildirim on 16.02.2024.
 */
class SaveAppEntry(private val iLocalUserManager : ILocalUserManager) {

    suspend operator fun invoke() {
        iLocalUserManager.saveAppEntry()
    }

}