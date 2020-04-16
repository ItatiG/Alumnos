package com.example.alumnos.data

//Mediador,
class AlumnoRepository(val alumnoDao: AlumnoDao)
{
    suspend fun guardarDatosAlumno(alumno: Alumno) = alumnoDao.guardarDatosAlumno(alumno)
    //suspend fun obtenerDatosAlumno(ncontrol: String): Alumno = alumnoDao.obtenerDatosAlumno(ncontrol)
    fun obtenerDatosAlumno(ncontrol: String) = alumnoDao.obtenerDatosAlumno(ncontrol)
}