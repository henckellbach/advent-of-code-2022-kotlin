import java.io.File

internal object Resource {
    private fun getFile(filename: String): File {
        return File("src/main/resources/$filename")
    }

    fun parseAsString(filename: String): String {
        return getFile(filename).readText()
    }

    fun parseAsStringList(filename: String): List<String> {
        return getFile(filename).readLines()
    }

    fun parseAsIntList(filename: String): List<Int?> {
        return parseAsStringList(filename).map{ it.toInt() }
    }
}