package com.example.picador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val botonInc: Button = findViewById(R.id.BotonIncremente)
        rollButton.setOnClickListener{ rollDice() }
        botonInc.setOnClickListener{ Cuenta() }

    }
    private fun rollDice(){
        val randomInt = (1..6).random()
        val resultText: TextView = findViewById(R.id.result_text)

        Toast.makeText(this,"Boton presionado",
        Toast.LENGTH_SHORT).show()
        resultText.text = randomInt.toString()
    }
    private fun Cuenta(){
        val resulText: TextView = findViewById(R.id.result_text)
        if (resulText.text == "Hola mundo"){
            resulText.text = "1"
        }
        else{
            var resultInt = resulText.text.toString().toInt()
            if(resultInt < 6){
                ++resultInt
                resulText.text = resultInt.toString()
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}