object Day03: IDay {
    private val input = Resource.parseAsStringList("3.txt")

    private fun String.halve(): Pair<String, String> {
        if (this.length % 2 != 0) {
            throw Error("Cannot halve string, length not even.")
        }
        val index = this.length / 2

        return take(index) to substring(index)
    }

    private fun getCharValue(char: Char): Int {
        val lowercaseRange = 'a'.code..'z'.code
        val uppercaseRange = 'A'.code..'Z'.code

        if (char.code in lowercaseRange) {
            return char.code - lowercaseRange.first + 1
        } else if (char.code in uppercaseRange) {
            return char.code - uppercaseRange.first + 1 + lowercaseRange.count()
        }

        throw Error("Cannot get char value, char not in range.")
    }

    override fun solvePart1(): Int {
        val values = input.map { line ->
            val (first,second) = line.halve()
            val duplicates = first.toCharArray().distinct().filter { char -> second.contains(char) }
            duplicates.sumOf { duplicate -> getCharValue(duplicate) }
        }

        return values.sum()
    }

    override fun solvePart2(): Int {
        val chunks = input.chunked(3)
        val values = chunks.map{ chunk ->
            val duplicate = chunk[0].toCharArray().distinct().find { char -> chunk[1].contains(char) && chunk[2].contains(char) }
            if (duplicate != null) getCharValue(duplicate) else 0
        }

        return values.sum()
    }
}