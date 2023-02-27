package com.example.myautoofficina.servizi

import com.example.myautoofficina.entities.Interventions

interface InterfaceInterventionServices {


    fun addInter(interventions: Interventions)

    fun getInter():List<Interventions>

    fun getInterById(id : Long): Interventions?

}