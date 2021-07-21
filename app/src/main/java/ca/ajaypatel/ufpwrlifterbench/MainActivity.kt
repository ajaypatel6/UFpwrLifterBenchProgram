package ca.ajaypatel.ufpwrlifterbench

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//new
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import ca.ajaypatel.ufpwrlifterbench.R

// need to add     id 'kotlin-android-extensions' to plugins, error
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.supportActionBar?.hide();

        calculateProgram.setOnClickListener(){
            if(editMaxBench!=null) {
                vibrateDevice(this)
//            val input = textMaxBench.text.toString();
                val inputWeight = editMaxBench.text.toString();
                textMaxBench.text = inputWeight
                Toast.makeText(this, "calculating weight", Toast.LENGTH_SHORT).show();
                calculateSets(inputWeight);
            }
            Toast.makeText(this, "no input weight", Toast.LENGTH_SHORT).show();

        }
    }

    private fun calculateSets(inputWeight: String) {
        val weight = inputWeight.toInt();

        mwSetOne.text= (weight*0.33).toString();
        mwSetTwo.text= (weight*0.56).toString();
        mwSetThree.text= (weight*0.79).toString();
        mwSetFour.text= (weight*0.86).toString();
        mwSetFive.text= (weight*0.91).toString();
        mwSetSix.text= (weight*0.96).toString();
        mwSetSeven.text= (weight*0.91).toString();
        mwSetEight.text= (weight*0.91).toString();
        mwSetNine.text= (weight*0.86).toString();
        mwSetTen.text= (weight*0.79).toString();

        fSetOne.text= (weight*0.33).toString();
        fSetTwo.text= (weight*0.56).toString();
        fSetThree.text= (weight*0.79).toString();
        fSetFour.text= (weight*0.86).toString();
        fSetFive.text= (weight*0.91).toString();
        fSetSix.text= (weight*0.91).toString();
        fSetSeven.text= (weight*0.91).toString();
        fSetEight.text= (weight*0.86).toString();
        fSetNine.text= (weight*0.79).toString();
        fSetTen.text= (weight*0.79).toString();
    }

}


fun vibrateDevice(context: Context) {
    val vibrator = getSystemService(context, Vibrator::class.java)
    vibrator?.let {
        if (Build.VERSION.SDK_INT >= 26) {
            it.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            @Suppress("DEPRECATION")
            it.vibrate(100)
        }
    }
}