package com.example.myautoofficina.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myautoofficina.R
import com.example.myautoofficina.adapter.CarsAdapter
import com.example.myautoofficina.persistence.Database.OfficinaDatabase
import com.example.myautoofficina.persistence.Database.getAppDatabase
import kotlinx.coroutines.launch

class ListCarFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?




        ): View? {

        val view=inflater.inflate(R.layout.fragment_list_car, container, false)

        lifecycleScope.launch {
            // Inflate the layout for this fragment
            val database = OfficinaDatabase.getAppDatabase(requireContext()).getCarDao()
            super.onViewCreated(view, savedInstanceState)
            view.findViewById<RecyclerView>(R.id.car_list).apply {
                layoutManager =
                    LinearLayoutManager(context).apply { orientation = RecyclerView.VERTICAL }
                adapter = CarsAdapter(database.getAll())
                /*
                RecyclerView recyclerView = findViewById(R.id.my_recyclerview);
                MyAdapter adapter = new MyAdapter(dataList);
                recyclerView.setAdapter(adapter);
                 */

            }

        }

            return view

        }


    }





