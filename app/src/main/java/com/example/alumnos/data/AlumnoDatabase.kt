package com.example.alumnos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Definir las tablas que conforman la base da datos
@Database(entities = arrayOf(Alumno::class), version = 1, exportSchema = false)
abstract class AlumnoDatabase: RoomDatabase()
{
    //Definir cuales son los Dao
    abstract fun alumnoDao(): AlumnoDao

    //Definir variables o propiedades estaticas
    companion object
    {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        //Singleron para tener solo una instancia
        private var INSTANCE: AlumnoDatabase? = null

        fun getDatabase(context: Context): AlumnoDatabase
        {
            val tempInstance = INSTANCE
            if (tempInstance != null)
            {
                return tempInstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AlumnoDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}