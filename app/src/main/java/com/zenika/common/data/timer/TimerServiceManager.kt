package com.zenika.common.data.timer

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimerServiceManager @Inject constructor(
    @ApplicationContext
    private val context: Context
) {
    private val _elapsed = MutableStateFlow(-1)
    val elapsed = _elapsed.asStateFlow()

    private val timerReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            _elapsed.update { intent.getIntExtra(PARAM_ELAPSED, -2) }
        }
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    fun startTimer() {
        val intent = Intent(context, TimerService::class.java)
        context.startService(intent)
        context.registerReceiver(timerReceiver, IntentFilter(ACTION_TIMER))
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    fun stopTimer() {
        val intent = Intent(context, TimerService::class.java)
        context.stopService(intent)
        context.unregisterReceiver(timerReceiver)
    }
}



