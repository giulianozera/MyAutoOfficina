package com.example.myautoofficina.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myautoofficina.R
import com.example.myautoofficina.entities.Interventions
import com.example.myautoofficina.persistence.Database.OfficinaDatabase
import com.example.myautoofficina.persistence.Database.getAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddInterventionsFragment : Fragment() {

    private lateinit var editTextArrive: EditText
    private lateinit var editTextDeparture: EditText
    private lateinit var editTextHours: EditText
    private lateinit var editTextProblems: EditText
    private lateinit var buttonAddInterventions: Button


    // Creiamo la vista del nostro Fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_interventions, container, false)
        editTextArrive = view.findViewById(R.id.editTextArriveDate)
        editTextDeparture= view.findViewById(R.id.editTextDepartureDate)
        editTextHours = view.findViewById(R.id.editHoursOfWork)
        editTextProblems = view.findViewById(R.id.editTextProblemDescription)
        buttonAddInterventions = view.findViewById(R.id.AddInterventions)
        buttonAddInterventions.setOnClickListener {
            // Recuperiamo i dati inseriti dall'utente
            val arrive = editTextArrive.text.toString()
            val departure = editTextDeparture.text.toString()
            val hours = editTextHours.text.toString()
            val problem = editTextProblems.text.toString()

            // Creiamo un nuovo oggetto Clients
            val intervent = Interventions(0,
                problem=problem,
                hours = hours ,
                arrive=arrive,
                departure = departure
            )

            lifecycleScope.launch(Dispatchers.IO) {
                OfficinaDatabase.getAppDatabase(requireContext()).getInterventionsDao().save(intervent)

            }
            findNavController().popBackStack()



        }

        // Ritorna la vista del fragment

        return view
    }



}