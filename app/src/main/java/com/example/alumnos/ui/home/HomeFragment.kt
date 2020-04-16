package com.example.alumnos.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.alumnos.AlumnoViewModel
import com.example.alumnos.AlumnoViewModelFactory
import com.example.alumnos.R
import com.example.alumnos.Singleton
import com.example.alumnos.data.AlumnoDatabase
import com.example.alumnos.data.AlumnoRepository

class HomeFragment : Fragment()
{
    //private lateinit var homeViewModel: HomeViewModel

    private val alumnoViewModel: AlumnoViewModel by viewModels {
        AlumnoViewModelFactory(
            //Repositorio
            AlumnoRepository(AlumnoDatabase.getDatabase(requireContext()).alumnoDao()),
            //Número de control
            Singleton.ncontrol
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val tvNombre = root.findViewById<TextView>(R.id.tvNombre)
        val tvCorreo = root.findViewById<TextView>(R.id.tvCorreo)

        alumnoViewModel.alumno.observe(viewLifecycleOwner, Observer { datos_alumno ->
            tvNombre.text = "${datos_alumno.nombre} ${datos_alumno.appaterno} ${datos_alumno.apmaterno}"
            tvCorreo.text = "${datos_alumno.correo}"
        })

        //val textView: TextView = root.findViewById(R.id.text_home)
        /*homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}
