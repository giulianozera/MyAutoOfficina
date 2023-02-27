package com.example.myautoofficina.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myautoofficina.R
import com.example.myautoofficina.entities.Interventions


 class InterventionAdapter( val data: List<Interventions>) :
    RecyclerView.Adapter<InterventionAdapter.ViewHolder>()
    {

        inner class ViewHolder(val v: View) : RecyclerView.ViewHolder(v) {

        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterventionAdapter.ViewHolder =
            ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.intervention_item, parent, false)
            )

        override fun getItemCount(): Int = data.size

        /*
  associare i dati alle viste in ogni riga della lista.
  Il blocco di codice recupera l'oggetto dati corrispondente
  alla posizione corrente usando la sintassi data[position]
   */
        override fun onBindViewHolder(holder: InterventionAdapter.ViewHolder, position: Int) {
            val currentItem=data[position]
            holder?.v?.findViewById<TextView>(R.id.arrive_date)?.text=currentItem.arrive
            holder?.v?.findViewById<TextView>(R.id.departure_date)?.text=currentItem.departure
            holder?.v?.findViewById<TextView>(R.id.hours)?.text=currentItem.hours
            holder?.v?.findViewById<TextView>(R.id.problem)?.text=currentItem.problem
        }

}