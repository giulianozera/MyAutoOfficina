package com.example.myautoofficina.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index
import androidx.room.TypeConverters
import java.util.*



/*
Un'autofficina ha la necessità di gestire
gli interventi su veicoli di diversi clienti.
Ogni cliente(nome, cognome, email)
può avere diversi veicoli(marca, modello, targa, numero di telaio).
Per ogni veicolo occorre registrare la data di arrivo, quella di consegna e il numero di ore necessarie per l'intervento.
 */


@Entity(
    tableName = "Interventions",
  foreignKeys = [ForeignKey(
        entity = Car::class,
        parentColumns = ["id"],
        childColumns = ["car_id"],
        onDelete = ForeignKey.SET_NULL
    )]
)

data class Interventions (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val problem: String,
    val hours: String,
    val arrive: String,
    val departure: String,
   @ColumnInfo(name = "car_id", index = true)
    val carId: Long?
)