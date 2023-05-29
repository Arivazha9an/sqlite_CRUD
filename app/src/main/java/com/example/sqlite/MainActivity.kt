package com.example.sqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val helper=MySDBHelper(applicationContext)
        var mydb=MySDBHelper(this)
        val mail=findViewById<EditText>(R.id.email)
        val pwd=findViewById<EditText>(R.id.pwd)
        val ins =findViewById<Button>(R.id.ins)
        val view=findViewById<Button>(R.id.view)
        val db1=helper.readableDatabase
        val db2=helper.writableDatabase

        ins.setOnClickListener{
            var cv=ContentValues()
            cv.put("email",mail.text.toString())
            cv.put("pwd",pwd.text.toString())
            db1.insert("USER",null,cv)
            Toast.makeText(this,"Successfully Inserted",Toast.LENGTH_LONG).show()
        }
        view.setOnClickListener {
            val cursor = mydb.getText()
            if (cursor?.count == -1) {
                Toast.makeText(this,"No data",Toast.LENGTH_LONG).show()
            }
            val bf=StringBuffer()
            while (cursor!!.moveToNext()){

                bf.append("sid :",cursor.getString(0)+"\n")
                bf.append("email :",cursor.getString(1)+"\n")
                bf.append("pwd :",cursor.getString(2)+"\n")
            }
            val builder=AlertDialog.Builder(this)
            builder.setCancelable(true)
            builder.setTitle("VIEW")
            builder.setMessage(bf.toString())
            builder.show()
        }



    }
}