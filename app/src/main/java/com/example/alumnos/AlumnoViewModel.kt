package com.example.alumnos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alumnos.data.Alumno
import com.example.alumnos.data.AlumnoRepository
import kotlinx.coroutines.launch

class AlumnoViewModel(private val alumnoRepository: AlumnoRepository, private val ncontrol: String): ViewModel()
{
    val alumno = alumnoRepository.obtenerDatosAlumno(ncontrol)

    fun guardarDatosAlumno(alumno: Alumno)
    {
        //Corutina
        viewModelScope.launch {
            alumnoRepository.guardarDatosAlumno(alumno)
        }
    }
}