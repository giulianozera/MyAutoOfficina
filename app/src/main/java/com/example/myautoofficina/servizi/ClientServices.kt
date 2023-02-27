package com.example.myautoofficina.servizi

import com.example.myautoofficina.entities.Client
import com.example.myautoofficina.persistence.Database.OfficinaDatabase
import com.example.myautoofficina.persistence.Database.getAppDatabase
import com.example.myautoofficina.persistence.dao.ClientDao

import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors


object ClientServices : InterfaceClientServices {

    //private  var clientDao: ClientDao= OfficinaDatabase.getAppDatabase().getClientDao()

    private lateinit var DaoClienti: ClientDao

    fun setDao(dao: ClientDao) {
        DaoClienti = dao
    }


    override fun addClient(client: Client) {
        Executors.newSingleThreadExecutor().execute {
            DaoClienti.save(client)
        }
    }

    override fun getClient(): List<Client> {
        TODO("Not yet implemented")
    }

    override fun getClientById(id: Long): Client? {
        TODO("Not yet implemented")
    }
}



