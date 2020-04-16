package com.example.alumnos.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//Interface para hacer los métodos relacionados a la clase
@Dao
interface AlumnoDao
{
    //Insertar en la base de datos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarDatosAlumno(alumno: Alumno)

    @Query("SELECT * FROM datos_alumno WHERE ncontrol = :ncontrol")
    //suspend fun obtenerDatosAlumno(ncontrol: String): Alumno
    fun obtenerDatosAlumno(ncontrol: String): LiveData<Alumno>
}