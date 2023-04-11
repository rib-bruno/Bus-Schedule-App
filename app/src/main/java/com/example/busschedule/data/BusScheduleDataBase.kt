package com.example.busschedule.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BusSchedule::class], version = 1, exportSchema = false)
abstract class BusScheduleDataBase : RoomDatabase() {

    abstract fun busDao() : BusDao

}