package com.example.uservip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.example.uservip.UserVipApplication.Companion.prefs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(prefs.getName().isNotEmpty()) {
            startActivity(Intent(this, BienvenidoActivity::class.java))
        }
        val btContinue: Button =  findViewById(R.id.boton_continuar)
        val etName: EditText = findViewById(R.id.etNombre)
        val chVip: CheckBox = findViewById(R.id.cbVip)
        btContinue.setOnClickListener {
            if(etName.text.toString().isNotEmpty()) {
                prefs.saveName(etName.text.toString())
                prefs.saveVIP(chVip.isChecked)
                startActivity(Intent(this, BienvenidoActivity::class.java))
            }
        }
    }
}