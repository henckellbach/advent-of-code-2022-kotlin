object Day01 {
    private val input = Resource.parseAsString("1.txt")
    private val totals = input.split("\n\n").map{
        it.lines().sumOf { line -> line.toInt() }
    }

    fun solvePart1(): Int {
        return totals.max()
    }

    fun solvePart2(): Int {
        return totals.sortedDescending().slice(0..2).sum()
    }
}