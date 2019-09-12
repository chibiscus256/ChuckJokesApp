package ru.slavicsky.chuckjokesapp.utils.extensions

fun fix(input: String): String {
    input.replace("&quot;", "\"")
    input.replace("?", "'")
    return input
}