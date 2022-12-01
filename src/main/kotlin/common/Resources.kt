package common

import java.io.File
import java.net.URI

internal object Resources {
    private fun asList(fileName: String): List<String> =
        File(fileName.toURI()).readLines()

    fun asListOfInt(fileName: String): List<Int> =
        asList(fileName).map { it.toInt() }

    fun asListOfString(fileName: String): List<String> =
        asList(fileName).map { it }

    private fun String.toURI(): URI =
        Resources.javaClass.classLoader.getResource(this)?.toURI()
            ?: throw IllegalArgumentException("Cannot find Resource: $this")

    /**
     *  Separates by empty line. Each new string contains one or more \n-separated rows.
     */
    fun List<String>.splitOnEmpty(): List<List<String>> {
        val res = mutableListOf<List<String>>()
        var group = mutableListOf<String>()

        forEach {
            if (it.trim().isEmpty()) {
                res += group
                group = mutableListOf()
            } else {
                group += it
            }
        }
        res += group
        return res
    }
}