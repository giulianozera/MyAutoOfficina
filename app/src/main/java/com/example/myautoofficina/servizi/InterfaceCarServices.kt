package com.example.myautoofficina.servizi

import com.example.myautoofficina.entities.Car
import com.example.myautoofficina.entities.Client
import com.example.myautoofficina.entities.Interventions
import com.example.myautoofficina.persistence.dao.ClientDao

interface InterfaceCarServices {

    fun setDao(dao: ClientDao)

    fun addCar(car: Car)

    fun getCar():List<Car>

    fun getCarById(id : Long): Car?
}