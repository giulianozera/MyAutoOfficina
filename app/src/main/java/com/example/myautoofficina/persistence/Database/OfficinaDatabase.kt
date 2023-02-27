package com.example.myautoofficina.persistence.Database

import android.os.Build.VERSION
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myautoofficina.entities.Client
import com.example.myautoofficina.entities.Car
import com.example.myautoofficina.entities.Interventions
import com.example.myautoofficina.persistence.dao.CarDao
import com.example.myautoofficina.persistence.dao.ClientDao
import com.example.myautoofficina.persistence.dao.InterventionsDao


/**
 * Gestore del database con Room.
 */

@Database(
    version = OfficinaDatabase.VERSION,
    entities = [Client::class,Car::class,Interventions::class]
)

abstract class OfficinaDatabase : RoomDatabase(){

    companion object{
        /**
         * La versione corrente del database.
         */
        const val DATABASE_NAME = "officina_db"
        const val VERSION=6
    }
    /**
     * Accede al DAO delle persone.
     * @return il DAO delle persone.
     */
    abstract fun getClientDao(): ClientDao

    /**
     * Accede al DAO delle macchine.
     * @return il DAO delle macchine.
     */
    abstract fun getCarDao(): CarDao

    /**
     * Accede al DAO degli interventi.
     * @return il DAO degli interventi.
     */
    abstract fun getInterventionsDao(): InterventionsDao
}