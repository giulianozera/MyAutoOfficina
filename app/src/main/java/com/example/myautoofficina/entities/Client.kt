package com.example.myautoofficina.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


/*
Un'autofficina ha la necessità di gestire
gli interventi su veicoli di diversi clienti.
Ogni cliente(nome, cognome, email)
può avere diversi veicoli(marca, modello, targa, numero di telaio).
Per ogni veicolo occorre registrare la data di arrivo, quella di consegna e il numero di ore necessarie per l'intervento.
 */

@Entity(
    tableName = "Client"
)
data class Client(

    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val surname:String,
    val email:String


)
