package com.example.busschedule.data

import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface BusDao {

    /**
     * O DAO oferece um método para extrair todos os itens do banco de dados e outro para extrair um único item com o nome do ponto de ônibus.
     * Não se esqueça de ordenar a programação por horário de chegada.
     */

    @Query("SELECT * from items WHERE id = :id")
    fun getBusScheduleFor (id: Int) : Flow<BusSchedule>

    @Query("SELECT * from items ORDER BY stopName ASC")
    fun getFullBusSchedule () : Flow<List<BusSchedule>>
}