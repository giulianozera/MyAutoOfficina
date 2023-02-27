package com.example.myautoofficina.persistence.Database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase



/**
 * Costruisce un riferimento al database dell'applicazione.
 * @param ctx il contesto di applicazione.
 */
fun OfficinaDatabase.Companion.getAppDatabase(ctx: Context): OfficinaDatabase =
    Room
        // builder del database
        .databaseBuilder(ctx, name = "officina-db", klass = OfficinaDatabase::class.java)
        // distrugge i dati al cambio di versione
        .fallbackToDestructiveMigration()
        // ottiene il database creato
        .build()

