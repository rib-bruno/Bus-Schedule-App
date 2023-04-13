package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(BusSchedule::class), version = 1)
abstract class BusScheduleDataBase : RoomDatabase() {

    abstract fun busDao() : BusDao

    companion object {
        @Volatile
        //mantendo uma única instância de banco de dados
        private var INSTANCE: BusScheduleDataBase? = null

        fun getDataBase(context: Context) : BusScheduleDataBase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, BusScheduleDataBase::class.java, "bus_database")
                    .createFromAsset("database/bus_schedule.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }

}