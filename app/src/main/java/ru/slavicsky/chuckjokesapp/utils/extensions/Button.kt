package ru.slavicsky.chuckjokesapp.utils.extensions

import android.text.Editable
import android.widget.Button

fun Button.checkInput(input: Editable) : Int {
    var number: Int = 1
    try {
        number = Integer.parseInt(input.toString())
        require(number <= 300)
    } catch (exception: NumberFormatException) {
        context.toast("Bad input")
    } catch (exception: IllegalArgumentException) {
        context.toast("Too much jokes")
    }
    return number
}