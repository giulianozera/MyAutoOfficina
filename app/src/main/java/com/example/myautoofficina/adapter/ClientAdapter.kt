package com.example.officina.adapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myautoofficina.MainActivity
import com.example.myautoofficina.R
import com.example.myautoofficina.adapter.CarsAdapter
import com.example.myautoofficina.entities.Car
import com.example.myautoofficina.entities.Client

class ClientAdapter( val data: List<Client>) :
    RecyclerView.Adapter<ClientAdapter.ViewHolder>()
    {

        inner class ViewHolder(val v: View) : RecyclerView.ViewHolder(v) {

        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientAdapter.ViewHolder =
            ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.client_item, parent, false)
            )

        override fun getItemCount(): Int = data.size
        /*
          associare i dati alle viste in ogni riga della lista.
          Il blocco di codice recupera l'oggetto dati corrispondente
          alla posizione corrente usando la sintassi data[position]
           */
        override fun onBindViewHolder(holder: ClientAdapter.ViewHolder, position: Int) {
            val currentItem=data[position]
            holder?.v?.findViewById<TextView>(R.id.name)?.text=currentItem.name
            holder?.v?.findViewById<TextView>(R.id.surname)?.text=currentItem.surname
            holder?.v?.findViewById<TextView>(R.id.email)?.text=currentItem.email
        }
    }
