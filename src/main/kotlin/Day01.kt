object Day01 : IDay {
    private val input = Resource.parseAsString("1.txt")
    private val totals = input.split("\n\n").map {
        it.lines().sumOf { line -> line.toInt() }
    }

    override fun solvePart1(): Int {
        return totals.max()
    }

    override fun solvePart2(): Int {
        return totals.sortedDescending().slice(0..2).sum()
    }
}