package org.oym.newshive.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.oym.newshive.domain.manager.ILocalUserManager
import org.oym.newshive.enums.EntryStatus
import org.oym.newshive.util.Constants
import org.oym.newshive.util.Constants.USER_SETTINGS

/**
 * Created by oguzhan.yildirim on 16.02.2024.
 */
class LocalUserManagerImpl(private val context: Context) : ILocalUserManager {

    override suspend fun saveAppEntry(entryStatus : EntryStatus) {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = entryStatus.value
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.APP_ENTRY] ?: EntryStatus.NOT_FIRST_TIME.value
        }
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

    private object PreferencesKeys {
        val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
    }

}