package com.zenika.data.timer

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper

const val ACTION_TIMER = "ZEscape.Timer"
const val PARAM_ELAPSED = "Elapsed"

class TimerService : Service() {
    private val handler = Handler(Looper.getMainLooper())
    private var elapsed: Int = 0

    private var timerRunnable: Runnable = object : Runnable {
        override fun run() {
            notifyTimer(elapsed)
            elapsed += 1000
            handler.postDelayed(this, 1000)
        }
    }

    private fun notifyTimer(timer: Int) {
        val intent = Intent(ACTION_TIMER).apply {
            putExtra(PARAM_ELAPSED, timer)
        }
        sendBroadcast(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        handler.postDelayed(timerRunnable, 0)
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(timerRunnable)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}



