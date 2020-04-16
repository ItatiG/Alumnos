package com.example.alumnos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alumnos.data.AlumnoRepository

//REcibe como parametro el repositorio,
class AlumnoViewModelFactory(private val alumnoRepository: AlumnoRepository, private val ncontrol: String) : ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        return AlumnoViewModel(alumnoRepository, ncontrol) as T
    }
}