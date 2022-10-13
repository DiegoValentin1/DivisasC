package com.utez.edu.mx.divisasc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.utez.edu.mx.divisasc.databinding.ActivityMainBinding
import java.net.HttpCookie.parse
import java.text.DecimalFormat
import java.time.Duration.parse
import java.util.logging.Level.parse

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var decision: Int = 0
    var decision2: Int = 0
    lateinit var spinner1:Spinner
    lateinit var spinner2:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spinner1 = binding.spinner1
        spinner2 = binding.spinner2
        val resultado =binding.resultado
        val cantidad = binding.cantidad.text

        val boton = binding.btnEnviar
        var total : Double = 0.0

        ArrayAdapter.createFromResource(
            this,
            R.array.divisas,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner1.adapter = adapter
            spinner2.adapter = adapter
        }
        spinner1.onItemSelectedListener = this
        spinner2.onItemSelectedListener = this
        boton.setOnClickListener {
            if (cantidad.toString().isNotEmpty()){
                val cantidad2: Double = cantidad.toString().toDouble()
                when(decision){
                    0->{
                        when(decision2){
                            0->{
                                total = cantidad2
                            }
                            1->{
                                total = cantidad2 * 0.050
                            }
                            2->{
                                total = cantidad2 * 0.057
                            }
                        }
                    }
                    1->{
                        when(decision2){
                            0->{
                                total = cantidad2 * 20
                            }
                            1->{
                                total = cantidad2
                            }
                            2->{
                                total = cantidad2 * 1.02
                            }
                        }
                    }
                    2->{
                        when(decision2){
                            0->{
                                total = cantidad2 * 19.54
                            }
                            1->{
                                total = cantidad2 * 0.98
                            }
                            2->{
                                total = cantidad2
                            }
                        }
                    }
                }//cierra when
                resultado.text = String.format("El total convertido es: %.2f", total)
            }
        }



    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p0 != null) {
            if ( p0.id == spinner1.id) {
                decision = p2
            } else if (p0.id == spinner2.id) {
                decision2 = p2
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}