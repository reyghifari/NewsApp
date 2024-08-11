package com.loc.newsapp

import androidx.lifecycle.ViewModel
import com.loc.newsapp.domain.usecase.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    useCases: AppEntryUseCases
) : ViewModel() {


}
