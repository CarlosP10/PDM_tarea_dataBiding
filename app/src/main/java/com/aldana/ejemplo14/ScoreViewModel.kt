package com.aldana.ejemplo14

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    var scoreTeamA = 0
    var scoreTeamB = 0

    @Bindable
    val _scoreTeamA = MutableLiveData<Int>()
    @Bindable
    val _scoreTeamB = MutableLiveData<Int>()

    fun onNewData(){
        _scoreTeamA.value = scoreTeamA
        _scoreTeamB.value = scoreTeamB
    }
}

