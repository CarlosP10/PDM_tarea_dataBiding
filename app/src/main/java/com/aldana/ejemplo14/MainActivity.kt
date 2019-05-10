package com.aldana.ejemplo14

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            this.lifecycleOwner = this@MainActivity
            this.score = scoreViewModel
        }

        scoreViewModel._scoreTeamA.observe(this, Observer {tv_score_team_a.text = it.toString()})
        scoreViewModel._scoreTeamB.observe(this, Observer {tv_score_team_b.text = it.toString()})


        // TODO: El ViewModel es restaurado si ya existía, si no, se crea uno nuevo.
        // TODO: Recuerde que el ViewModel solo sobrevive a cambios de configuración y no a la destrucción de la aplicación
    }
    // TODO: Accediendo y modificando datos almacenados en el ViewModel según el método utilizado

    fun addOneTeamA(v: View) {
        scoreViewModel.scoreTeamA += 1
        scoreViewModel.onNewData()
    }

    fun addOneTeamB(v: View) {
        scoreViewModel.scoreTeamB += 1
        scoreViewModel.onNewData()
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA += 2
        scoreViewModel.onNewData()
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB += 2
        scoreViewModel.onNewData()
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA += 3
        scoreViewModel.onNewData()
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB += 3
        scoreViewModel.onNewData()
    }

    fun resetScores(v: View) {
        scoreViewModel.scoreTeamA = 0
        scoreViewModel.scoreTeamB = 0

        scoreViewModel.onNewData()
    } // TODO: Limpiando datos

}
