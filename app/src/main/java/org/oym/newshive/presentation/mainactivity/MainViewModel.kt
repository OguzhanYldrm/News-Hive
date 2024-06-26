package org.oym.newshive.presentation.mainactivity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.oym.newshive.domain.usecases.app_entry.AppEntryUseCases
import org.oym.newshive.presentation.navgrph.Route
import javax.inject.Inject

/**
 * Created by oguzhan.yildirim on 19.03.2024.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        viewModelScope.launch {
            appEntryUseCases.readAppEntry().onEach {shouldStartFromHomeScreen ->
                if (shouldStartFromHomeScreen) {
                    startDestination = Route.NewsNavigation.route
                } else {
                    startDestination = Route.AppStartNavigation.route
                }
                delay(300)
                splashCondition = false
            }.launchIn(viewModelScope)
        }
    }

}