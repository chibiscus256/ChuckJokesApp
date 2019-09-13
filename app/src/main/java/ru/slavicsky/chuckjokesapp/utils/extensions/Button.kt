package ru.slavicsky.chuckjokesapp.utils.extensions

import android.text.Editable
import android.widget.Button
import ru.slavicsky.chuckjokesapp.api.networking.getNetworkResponse
import ru.slavicsky.chuckjokesapp.view.adapters.Adapter

fun Button.reload(input: Editable, adapter: Adapter) {
    val number: Int
    try {
        number = Integer.parseInt(input.toString())
        require(number <= 300)
        getNetworkResponse(adapter, number)
    } catch (exception: NumberFormatException) {
        context.toast("Bad input")
    } catch (exception: IllegalArgumentException) {
        context.toast("Too much jokes")
    }
}