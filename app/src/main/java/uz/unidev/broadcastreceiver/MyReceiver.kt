package uz.unidev.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 *  Created by Nurlibay Koshkinbaev on 17/07/2022 13:27
 */

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            "loaded" -> {
                val percent = intent.getIntExtra("percent", 0)
                Toast.makeText(context, "Loaded $percent", Toast.LENGTH_SHORT).show()
            }
            ACTION_CLICKED -> {
                val count = intent.getIntExtra(EXTRA_COUNT, 0)
                Toast.makeText(context, "ACTION_CLICKED! $count", Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val turnedOn = intent.getBooleanExtra("state", false)
                Toast.makeText(
                    context,
                    "ACTION_AIRPLANE_MODE_CHANGED! $turnedOn",
                    Toast.LENGTH_LONG
                ).show()
            }
            Intent.ACTION_BATTERY_CHANGED -> {
                Toast.makeText(context, "ACTION_BATTERY_CHANGED!", Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_USER_UNLOCKED -> {
                Toast.makeText(context, "ACTION_USER_UNLOCKED!", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        const val ACTION_CLICKED = "Clicked"
        const val EXTRA_COUNT = "count"
    }
}