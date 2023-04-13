package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusDao {

    /**
     * O DAO oferece um método para extrair todos os itens do banco de dados e outro para extrair um único item com o nome do ponto de ônibus.
     * Não se esqueça de ordenar a programação por horário de chegada.
     */

    @Query("SELECT * from schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getBusScheduleByStopName (stopName: String) : Flow<List<BusSchedule>>

    @Query("SELECT * from schedule ORDER BY arrival_time ASC")
    fun getAllBusSchedule () : Flow<List<BusSchedule>>
}