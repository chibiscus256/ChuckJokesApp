package ru.slavicsky.chuckjokesapp.utils.extensions

import android.text.Editable
import android.widget.Button
import ru.slavicsky.chuckjokesapp.api.networking.getNetworkResponse
import ru.slavicsky.chuckjokesapp.view.adapters.JokeListAdapter

fun Button.reload(input: Editable, adapter: JokeListAdapter) {
    var number = 1
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