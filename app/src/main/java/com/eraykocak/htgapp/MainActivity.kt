package com.eraykocak.htgapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import com.eraykocak.htgapp.api.ServiceHexTech
import com.eraykocak.htgapp.model.ResponsePin
import com.google.android.material.switchmaterial.SwitchMaterial
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData(){

        var hexService= ServiceHexTech()

        hexService.getHexPin().enqueue(object : Callback<ResponsePin> {

            override fun onResponse(call: Call<ResponsePin>, response: Response<ResponsePin>) {
                var p1 = response.body()?.p1
                var p2 = response.body()?.p2
                var p3 = response.body()?.p3
                var p4 = response.body()?.p4

                //Log.e("successful", "" + p1.toString())
                //Log.e("successful", "" + p2.toString())
                //Log.e("successful", "" + p3.toString())
                //Log.e("successful", "" + p4.toString())
                //

                val pin1 = findViewById<SwitchMaterial>(R.id.Pin1)
                val pin2 = findViewById<SwitchMaterial>(R.id.Pin2)
                val pin3 = findViewById<SwitchMaterial>(R.id.Pin3)
                val pin4 = findViewById<SwitchMaterial>(R.id.Pin4)
                if (p1 == true) {
                    pin1.isChecked = true
                }
                if (p1 == false) {
                    pin1.isChecked = false
                }
                if (p2 == true) {
                    pin2.isChecked = true
                }
                if (p2 == false) {
                    pin2.isChecked = false
                }
                if (p3 == true) {
                    pin3.isChecked = true
                }
                if (p3 == false) {
                    pin3.isChecked = false
                }
                if (p4 == true) {
                    pin4.isChecked = true
                }
                if (p4 == false) {
                    pin4.isChecked = false
                }

                timeCounter()

            }

            override fun onFailure(call: Call<ResponsePin>, t: Throwable) {
                Log.e("error", "error has occurred")
            }

        })
    }

    fun timeCounter(){

        var timerHex=findViewById<TextView>(R.id.timerHex)

        object : CountDownTimer(15000,1000){
            override fun onTick(millisUntilFinished: Long) {
                timerHex.text=""+millisUntilFinished/1000
            }

            override fun onFinish() {
                getData()

            }

        }.start()
    }

}