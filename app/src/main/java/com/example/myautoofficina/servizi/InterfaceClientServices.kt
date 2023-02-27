package com.example.myautoofficina.servizi

import com.example.myautoofficina.entities.Client

interface InterfaceClientServices {

    fun addClient(client: Client)

    fun getClient():List<Client>

    fun getClientById(id : Long):Client?
}