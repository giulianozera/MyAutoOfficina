package com.example.myautoofficina.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.myautoofficina.R
import com.example.myautoofficina.entities.Car
import com.example.myautoofficina.persistence.Database.OfficinaDatabase
import com.example.myautoofficina.persistence.Database.getAppDatabase
import com.example.myautoofficina.persistence.dao.ClientDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddCarFragment : Fragment() {

    //la variabile non viene inizializzata nel costruttore
    // della classe, ma solo in un secondo momento.
    private lateinit var editTextBrand: EditText
    private lateinit var editTextModel: EditText
    private lateinit var editTextPlate: EditText
    private lateinit var editTextChassisNumber: EditText
    private lateinit var buttonAddCar: Button
    //mi serve a passare dati tra activity o fragment
    private var bundle: Bundle? = null

    // Creiamo la vista del nostro Fragment




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = OfficinaDatabase.getAppDatabase(requireContext()).getCarDao()

        // Chiamata asincrona alla funzione getAll di ClientDao
        viewLifecycleOwner.lifecycleScope.launch {
            val clients = db.getAll()

            // Utilizzo dei dati restituiti dalla funzione getAll
            // per popolare lo spinner
            val spinner = view.findViewById<Spinner>(R.id.spinnerIdCliente)
            spinner.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                clients
            )
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_car, container, false)
        editTextBrand = view.findViewById(R.id.editTextBrand)
        editTextModel = view.findViewById(R.id.editTextModel)
        editTextPlate = view.findViewById(R.id.editTextPlate)
        editTextChassisNumber = view.findViewById(R.id.editTextChassisNumber)
        buttonAddCar = view.findViewById(R.id.buttonAddCar)

        buttonAddCar.setOnClickListener {

                // Recuperiamo i dati inseriti dall'utente
                val model = editTextModel.text.toString()
                val brand = editTextBrand.text.toString()
                val chassisNumber = editTextChassisNumber.text.toString()
                val plate = editTextPlate.text.toString()
                val car = Car(
                    0,
                    brand = brand,
                    model = model,
                    plate = plate,
                    chassisNumber = chassisNumber,
                    null
                )

                lifecycleScope.launch(Dispatchers.IO) {
                    OfficinaDatabase.getAppDatabase(requireContext()).getCarDao().save(car)

                }
            findNavController().popBackStack()

            }

            // Ritorna la vista del fragment

        return view
        }

    }




