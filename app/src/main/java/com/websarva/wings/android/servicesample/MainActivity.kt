package com.websarva.wings.android.servicesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Intentから通知タップからの引き継ぎデータを取得
        val fromNotification = intent.getBooleanExtra("fromNotification", false)
        // 引き継ぎデータが存在（通知のタップからの場合）
        if (fromNotification) {
            // 再生ボタンをタップ不可に、停止ボタンをタップ可に変更
            val btPlay = findViewById<Button>(R.id.btPlay)
            val btStop = findViewById<Button>(R.id.btStop)
            btPlay.isEnabled = false
            btStop.isEnabled = true
        }
    }

    fun onPlayButtonClick(view: View) {
        // インテントオブジェクトを生成
        val intent = Intent(this@MainActivity, SoundManagedService::class.java)
        // サービスを起動
        startService(intent)
        // 再生ボタンをタップ不可に、停止ボタンをタップ可に変更
        val btPlay = findViewById<Button>(R.id.btPlay)
        val btStop = findViewById<Button>(R.id.btStop)
        btPlay.isEnabled = false
        btStop.isEnabled = true
    }

    fun onStopButtonClick(view: View) {
        // インテントオブジェクトを生成
        val intent = Intent(this@MainActivity, SoundManagedService::class.java)
        // サービスを起動
        stopService(intent)
        // 再生ボタンをタップ不可に、停止ボタンをタップ可に変更
        val btPlay = findViewById<Button>(R.id.btPlay)
        val btStop = findViewById<Button>(R.id.btStop)
        btPlay.isEnabled = true
        btStop.isEnabled = false

    }
}