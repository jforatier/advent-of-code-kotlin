package common

import java.io.File
import java.net.URI

internal object Resources {
    private fun asList(fileName: String): List<String> =
        File(fileName.toURI()).readLines()

    fun asListOfInt(fileName: String): List<Int> =
        asList(fileName).map { it.toInt() }

    private fun String.toURI(): URI =
        Resources.javaClass.classLoader.getResource(this)?.toURI()
            ?: throw IllegalArgumentException("Cannot find Resource: $this")
}