package com.example.thetdmproject

import androidx.room.TypeConverter
import java.util.*

public class DateConverter {

    @TypeConverter
    fun toDate(dateLong: Long ) : Date? {
        if (dateLong == null)
            return  null
        else
            return Date(dateLong);
    }

    @TypeConverter
    fun fromDate(date : Date): Long?{
        if (date == null)
            return null
        else
            return date.getTime();
    }
}
