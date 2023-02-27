package com.example.myautoofficina.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myautoofficina.entities.Car
import com.example.myautoofficina.entities.Client
/**
 * Funzionalità necessarie all'applicazione per funzionare.
 */
@Dao
public interface ClientDao {




    /**
     * Recupera tutti iclienti .
     * @return l'elenco delle persone desiderate.
     */
    @Query("SELECT * FROM Client ")
    public abstract suspend fun getAll(): List<Client>

    /**
     * Salva una persona.
     * @param client i dati della persona da salvare.
     * @return il valore della chiave dell'elemento inserito.
     */
    @Insert
    fun save(client : Client)


    @Query("SELECT * FROM Client WHERE id = :id")
    fun getClientId(id: Long): Client



}