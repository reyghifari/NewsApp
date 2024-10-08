package com.loc.newsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.usecase.app_entry.AppEntryUseCases
import com.loc.newsapp.view.nvgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    useCases: AppEntryUseCases
) : ViewModel() {

     var splashCondition by mutableStateOf(true)
         private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        useCases.readAppEntry().onEach { shouldStartFromHome ->
            startDestination = if (shouldStartFromHome){
                Route.NewsNavigation.route
            }else{
                Route.AppStartNavigation.route
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }

}
