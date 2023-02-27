package com.example.myautoofficina.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.navigation.findNavController
import com.example.myautoofficina.R


class HomePageFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view:View=inflater.inflate(R.layout.fragment_home_page,container,false)
        view.findViewById<Button>(R.id.View_Clients).setOnClickListener {view.findNavController().navigate(
            R.id.action_homePageFragment_to_listViewClientFragment
        )}
        view.findViewById<Button>(R.id.Add_Clients).setOnClickListener { view.findNavController().navigate(
            R.id.action_homePageFragment_to_addClientFragment
        )}
        view.findViewById<Button>(R.id.view_cars).setOnClickListener {  view.findNavController().navigate(
            R.id.action_homePageFragment_to_listCarFragment
        )}
        view.findViewById<Button>(R.id.add_cars).setOnClickListener { view.findNavController().navigate(
            R.id.action_homePageFragment_to_addCarFragment
        ) }
        view.findViewById<Button>(R.id.vedi_interventi).setOnClickListener {  view.findNavController().navigate(
            R.id.action_homePageFragment_to_listInterventionsFragment
        )}
        view.findViewById<Button>(R.id.add_interventions).setOnClickListener { view.findNavController().navigate(
            R.id.action_homePageFragment_to_addInterventionsFragment
        ) }
        return view
    }

    companion object{

    }

}