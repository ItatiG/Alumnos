package com.example.alumnos.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Se crea una tabla alumno con todos los campos
@Entity(tableName = "datos_alumno")
data class Alumno(
    @PrimaryKey val ncontrol:String,
    val nombre: String,
    @ColumnInfo(name = "apellido_paterno") val appaterno: String,
    @ColumnInfo(name = "apellido_materno") val apmaterno: String,
    val carrera: String,
    val semestre: Int,
    val promedio: Double,
    val sexo: String,
    val telefono: String,
    val correo: String
)
{
}