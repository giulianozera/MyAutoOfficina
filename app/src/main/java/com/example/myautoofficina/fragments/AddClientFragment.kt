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
import com.example.myautoofficina.entities.Client
import com.example.myautoofficina.persistence.Database.OfficinaDatabase
import com.example.myautoofficina.persistence.Database.getAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddClientFragment : Fragment() {




    private lateinit var editTextName: EditText
    private lateinit var editTextSurname: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonAddClient: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_client, container, false)
        editTextName = view.findViewById(R.id.editTextName)
        editTextSurname = view.findViewById(R.id.editTextSurname)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        buttonAddClient = view.findViewById(R.id.buttonAddClient)

        buttonAddClient.setOnClickListener {

            // Recuperiamo i dati inseriti dall'utente
            val name = editTextName.text.toString()
            val surname = editTextSurname.text.toString()
            val email = editTextEmail.text.toString()
            val client = Client(
                0,
                name = name,
                surname = surname,
                email = email,
            )

            lifecycleScope.launch(Dispatchers.IO) {
                OfficinaDatabase.getAppDatabase(requireContext()).getClientDao().save(client)


            }
            findNavController().popBackStack()

        }

        // Ritorna la vista del fragment

        return view
    }

}