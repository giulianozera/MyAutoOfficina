package com.example.myautoofficina.persistence.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myautoofficina.entities.Car
import com.example.myautoofficina.entities.Client
import com.example.myautoofficina.entities.Interventions

/**
 * Funzionalità necessarie all'applicazione per funzionare.
 */
@Dao
interface InterventionsDao {

    /**
     * Recupera tutti gli interventi .
     * @return l'elenco degli interventi  desiderati.
     */
    @Query("SELECT * FROM Interventions ")
    suspend fun getAll(): List<Interventions>

    /**
     * Salva un intervento .
     * @param inter i dati della macchina da salvare.
     * @return il valore della chiave dell'elemento inserito.
     */
    @Insert
    fun save(inter : Interventions)


    @Query("SELECT * FROM Interventions WHERE id = :id")
    fun getInterventionId(id: Long): Interventions


}