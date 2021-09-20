package com.lazymindapps.morningwalk.viewModels

import androidx.lifecycle.ViewModel
import com.lazymindapps.morningwalk.repo.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatViewModel @Inject constructor(
    val repo:MainRepo
) :ViewModel(){
}