package com.lukianbat.weatherexpert.feature.weather.data.local

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.lukianbat.weatherexpert.feature.main.CityPreferences
import java.io.InputStream
import java.io.OutputStream

object CitySerializer : Serializer<CityPreferences> {
    override val defaultValue: CityPreferences = CityPreferences.getDefaultInstance()

    override fun readFrom(input: InputStream): CityPreferences {
        try {
            return CityPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Error deserializing proto", exception)
        }
    }

    override fun writeTo(t: CityPreferences, output: OutputStream) = t.writeTo(output)
}
