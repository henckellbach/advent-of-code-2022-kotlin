object Day04: IDay {
    private val input = Resource.parseAsStringList("4.txt")
    private val rangeLists = input.map { it.split(',').map { str -> str.toRange() } }

    private fun IntRange.contains(range2: IntRange): Boolean {
        return this.intersect(range2).count() == range2.count()
    }

    private fun String.toRange(delimiter: Char = '-'): IntRange {
        val (first,last) = this.split(delimiter).map{it.toInt()}
        return first..last
    }

    override fun solvePart1(): Int {
        return rangeLists.count { (range1, range2) ->
            range1.contains(range2) || range2.contains(range1)
        }
    }

    override fun solvePart2(): Any {
        return rangeLists.count { (range1,range2) ->
            range1.intersect(range2).isNotEmpty() || range2.intersect(range1).isNotEmpty()
        }
    }
}