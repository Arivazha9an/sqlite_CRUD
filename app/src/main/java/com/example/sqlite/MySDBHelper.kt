package com.example.sqlite

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySDBHelper(context: Context):SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table USER (sid integer primary key autoincrement,email text,pwd text)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun getText(): Cursor? {
        val db = this.writableDatabase
        val cursor = db.rawQuery("select * from USER", null)
        return cursor
    }
}