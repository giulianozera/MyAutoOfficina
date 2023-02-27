package com.example.myautoofficina.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myautoofficina.entities.Car


/**
 * Funzionalità necessarie all'applicazione per funzionare.
 */

@Dao
public interface CarDao {


    /**
     * Recupera tutte le macchine .
     * @return l'elenco delle macchine desiderate.
     */
    @Query("SELECT * FROM Car ")
    suspend fun getAll(): List<Car>

    /**
     * Salva una macchina.
     * @param car i dati della macchina da salvare.
     * @return il valore della chiave dell'elemento inserito.
     */
    @Insert
     fun save(car : Car)


    @Query("SELECT * FROM Car WHERE id = :id")
    fun getCarId(id: Long): Car



}