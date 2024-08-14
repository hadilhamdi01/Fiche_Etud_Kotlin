package com.example.ficheetudiant

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.text.trimmedLength
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.time.Month
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var txt: TextView
    lateinit var Edit1: EditText
    lateinit var Edit2: EditText
    lateinit var Edit3: EditText
    lateinit var spinner: Spinner
    lateinit var select: TextView
    lateinit var bt: Button
    val spinners = arrayOf("DSI2", "DSI3", "SEM1", "SEM2", "RSI2", "RSI3")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        txt = findViewById(R.id.txt)
        Edit1 = findViewById(R.id.Edit1)
        Edit2 = findViewById(R.id.Edit2)
        Edit3 = findViewById(R.id.Edit3)
        bt = findViewById(R.id.bt)
        select = findViewById(R.id.select)

        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }
        bt.setOnClickListener {
            DatePickerDialog(
                this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()


    }





        val spinner=findViewById<Spinner>(R.id.spinner)
        val arrayAdapter=ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spinners)
        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener =object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected( parent: AdapterView<*>?,view: View?, position: Int, id: Long) {
                       select.text=spinners[position]


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }



        btn.setOnClickListener{

            if(Edit1.getText().trimmedLength()==0 ||Edit2.getText().trimmedLength()==0 ||Edit3.getText().trimmedLength()==0 || select.getText().trimmedLength()==0  ) {
                val builder= AlertDialog.Builder(this)
                builder.setTitle("Erreur !")
                builder.setMessage("Remplir les champs vides")
                builder.setNegativeButton("Exit",{ dialogInterface: DialogInterface, i:Int->})
                builder.setPositiveButton("Continue",{ dialogInterface: DialogInterface, i:Int->})

                val snackbar = Snackbar.make(it,"Remplir les champs vides",Snackbar.LENGTH_LONG)
                snackbar.show()
                builder.show()



            }
      else {

                val Intent = Intent(this, MainActivity2::class.java)
                Intent.putExtra("data",  "Etudiant(e):" + Edit1.text.toString() + "Né(e) le:" + Edit2.text.toString() + "Email:" + Edit3.text.toString() + "Classe" + select.text.toString())
                startActivity(Intent)
                //txt.setText()





            }

            }


    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        Edit2.setText(sdf.format(myCalendar.time))


    }
}
