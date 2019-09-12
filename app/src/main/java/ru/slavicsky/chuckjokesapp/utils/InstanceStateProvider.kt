package ru.slavicsky.chuckjokesapp.utils

import android.os.Bundle
import android.os.Parcelable
import kotlin.reflect.KProperty

abstract class InstanceStateProvider<T>(protected val savable: Bundle) {

    protected var cache: T? = null

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        cache = value
        if (value == null) return
        when (value) {
            is Int -> savable.putInt(property.name, value)
            is Long -> savable.putLong(property.name, value)
            is Float -> savable.putFloat(property.name, value)
            is String -> savable.putString(property.name, value)
            is Bundle -> savable.putBundle(property.name, value)
            is Parcelable -> savable.putParcelable(property.name, value)
        }
    }
    class Nullable<T>(savable: Bundle) : InstanceStateProvider<T>(savable) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): T? {
            if (cache != null) return cache
            if (!savable.containsKey(property.name)) return null
            return savable.get(property.name) as T
        }
    }

    class NotNull<T>(savable: Bundle, private val defaultValue: T) : InstanceStateProvider<T>(savable) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return cache ?: savable.get(property.name) as T ?: defaultValue
        }
    }
    protected fun <T> instanceState() = Nullable<T>(savable)
    protected fun <T> instanceState(defaultValue: T) = NotNull(savable, defaultValue)
}

