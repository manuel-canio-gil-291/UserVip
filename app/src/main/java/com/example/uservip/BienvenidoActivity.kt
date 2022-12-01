package com.example.uservip

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.uservip.UserVipApplication.Companion.prefs

class BienvenidoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)
        val btClose: Button = findViewById(R.id.btClose)
        val tvName: TextView = findViewById(R.id.tvName)
        val container: LinearLayout = findViewById(R.id.container)
        btClose.setOnClickListener {
            prefs.wipe()
            onBackPressed() //metodo de android
        }
        val userName = prefs.getName()
        tvName.text="Bienvendo $userName"
        if(prefs.getVIP()){
             container.setBackgroundColor(ContextCompat.getColor(this, R.color.vip_color))
        }
    }
}