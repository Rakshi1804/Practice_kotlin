package com.example.practice_kotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var affirmBtn = findViewById<Button>(R.id.btnAffirm)
        affirmBtn.setOnClickListener {
            val afIntent = Intent(this,AffirmationsActivity::class.java)
            startActivity(afIntent)
        }

        var dialBtn = findViewById<Button>(R.id.btnDialer)
        dialBtn.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"))
            startActivity(dialIntent)
        }



        var alarmBtn = findViewById<Button>(R.id.btnAlarm)
        alarmBtn.setOnClickListener {
            createAlarm("b3 sync", 3,13)
            startActivity(intent)
        }
    }


}

class AffirmationsActivity {

}

fun createAlarm(message: String, hour: Int, minutes: Int) {

    val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
        putExtra(AlarmClock.EXTRA_MESSAGE, message)
        putExtra(AlarmClock.EXTRA_HOUR, hour)
        putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        //startActivity(intent)
    }
    //if (intent.resolveActivity(packageManager) != null) {
    startActivity(intent)
    //}
}

fun startActivity(intent: Intent) {

}


