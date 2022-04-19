package com.example.superhero.data.model

import androidx.room.TypeConverter

class Converter {

    @TypeConverter
    fun convertImageToString(image: Image): String = image.url

    @TypeConverter
    fun convertStringToImage(string: String): Image {
        return Image(string)
    }

    @TypeConverter
    fun covertBiographyToString(biography: Biography): String {
        return "${biography.publisher}, ${biography.fullName}, ${biography.birthsPlace}, ${biography.firstAppearance}"
    }

    @TypeConverter
    fun convertStringToBiography(string: String): Biography {
        val array = string.split(", ")
        return Biography(array[0], array[1], array[2], array[3])
    }

    @TypeConverter
    fun covertPowerStatsToString(powerStats: Powerstats): String {
        return "${powerStats.intelligence}, ${powerStats.strength}, ${powerStats.speed}, ${powerStats.combat}"
    }

    @TypeConverter
    fun convertStringToPowerStats(string: String): Powerstats {
        val array = string.split(", ")
        return Powerstats(array[0], array[1], array[2], array[3])
    }

    @TypeConverter
    fun convertWorkToString(work: Work): String? = work.occupation

    @TypeConverter
    fun convertStringToWork(string: String): Work {
        return Work(string)
    }

    @TypeConverter
    fun convertConnectionsToString(connections: Connections): String? = connections.relatives

    @TypeConverter
    fun convertStringToConnections(string: String): Connections {
        return Connections(string)
    }
}