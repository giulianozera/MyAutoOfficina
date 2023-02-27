package com.example.myautoofficina.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/*
Un'autofficina ha la necessità di gestire
gli interventi su veicoli di diversi clienti.
Ogni cliente(nome, cognome, email)
può avere diversi veicoli(marca, modello, targa, numero di telaio).
Per ogni veicolo occorre registrare la data di arrivo, quella di consegna e il numero di ore necessarie per l'intervento.
 */



@Entity(
    tableName = "Car",
      foreignKeys = [ForeignKey(
        entity = Client::class,
        parentColumns = ["id"],
        childColumns=["Owner_id"],
        onDelete = ForeignKey.SET_NULL
    )]

)data class Car(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val brand:String,
    val model:String,
    val plate:String,
    val chassisNumber: String,
    @ColumnInfo(name="Owner_id",index=true)
    val Owner_id:Long?
)