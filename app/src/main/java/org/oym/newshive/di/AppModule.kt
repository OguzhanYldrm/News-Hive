package org.oym.newshive.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.oym.newshive.data.manager.LocalUserManagerImpl
import org.oym.newshive.domain.manager.ILocalUserManager
import org.oym.newshive.domain.usecases.app_entry.AppEntryUseCases
import org.oym.newshive.domain.usecases.app_entry.ReadAppEntry
import org.oym.newshive.domain.usecases.app_entry.SaveAppEntry
import javax.inject.Singleton

/**
 * Created by oguzhan.yildirim on 11.03.2024.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : ILocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        iLocalUserManager: ILocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(iLocalUserManager),
        saveAppEntry = SaveAppEntry(iLocalUserManager)
    )
}