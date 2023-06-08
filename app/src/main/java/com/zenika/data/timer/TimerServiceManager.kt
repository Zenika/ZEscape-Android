package com.zenika.data.timer

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.zenika.data.state.GameState
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimerServiceManager @Inject constructor(
    @ApplicationContext
    private val context: Context,
    gameState: GameState
) {
    private val _remaining = MutableStateFlow(-1)
    val remaining = _remaining.asStateFlow()

    private val penalty = gameState.penaltyCount

    private val timerReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            _remaining.update { intent.getIntExtra(PARAM_REMAINING, -2) - (60000 * penalty.value) }
        }
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    fun startTimer() {
        val intent = Intent(context, TimerService::class.java)
        context.startService(intent)
        context.registerReceiver(timerReceiver, IntentFilter(ACTION_TIMER))
    }

    fun getTimer(): Int {
        return remaining.value
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    fun stopTimer() {
        val intent = Intent(context, TimerService::class.java)
        context.stopService(intent)
        context.unregisterReceiver(timerReceiver)
    }
}



