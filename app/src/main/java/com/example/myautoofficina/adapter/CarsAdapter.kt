package com.example.myautoofficina.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myautoofficina.R
import com.example.myautoofficina.entities.Car
import com.example.myautoofficina.persistence.Database.OfficinaDatabase
import com.example.myautoofficina.persistence.dao.CarDao
import com.example.myautoofficina.persistence.dao.CarDao_Impl


class CarsAdapter( private val data: List<Car>) :
    RecyclerView.Adapter<CarsAdapter.ViewHolder>() {

    /**
     * La classe che gestisce il pattern di ViewHolder.
     * Si tratta di una "inner" class perché deve accedere a membri della classe "outer".
     */
    inner class ViewHolder(val v: View) : RecyclerView.ViewHolder(v) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        )

    override fun getItemCount(): Int = data.size


    /*
    associare i dati alle viste in ogni riga della lista.
    Il blocco di codice recupera l'oggetto dati corrispondente
    alla posizione corrente usando la sintassi data[position]
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem=data[position]
        holder?.v?.findViewById<TextView>(R.id.brand)?.text=currentItem.brand
        holder?.v?.findViewById<TextView>(R.id.model)?.text=currentItem.model
        holder?.v?.findViewById<TextView>(R.id.plate)?.text=currentItem.plate
        holder?.v?.findViewById<TextView>(R.id.chassis)?.text=currentItem.chassisNumber
            }



}