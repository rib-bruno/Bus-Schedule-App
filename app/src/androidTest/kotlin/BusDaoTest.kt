import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.busschedule.data.BusDao
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.data.BusScheduleDataBase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class BusDaoTest {
    private lateinit var busDao: BusDao
    private lateinit var busScheduleDataBase : BusScheduleDataBase

    @Before
    fun createDB() {
        //usar database na memória
        val context: Context = ApplicationProvider.getApplicationContext()
        busScheduleDataBase = Room.inMemoryDatabaseBuilder(context, busScheduleDataBase::class.java)
            .allowMainThreadQueries()
            .build()
        busDao = busScheduleDataBase.busDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb () {
        busScheduleDataBase.close()
    }

    private var bus1 = BusSchedule(1,"recife", 15)
    private var bus2 = BusSchedule(2,"olinda", 45)


}