object Day02 {
    enum class Sign(val score: Int) {
        ROCK(1), PAPER(2), SCISSORS(3)
    }

    private fun mapInputToSign(input: Char): Sign {
        return when (input) {
            'A', 'X' -> Sign.ROCK
            'B', 'Y' -> Sign.PAPER
            'C', 'Z' -> Sign.SCISSORS
            else -> throw Error("Cannot convert to sign, wrong input.")
        }
    }

    private val input = Resource.parseAsStringList("2.txt")

    private fun getScore(playerSign: Sign, opponentSign: Sign): Int {
        val stateScore = when (playerSign.score - opponentSign.score) {
            -1, 2 -> 0
            0 -> 3
            1, -2 -> 6
            else -> throw Error("Could not get score. Check your input.")
        }

        return stateScore + playerSign.score
    }

    fun solvePart1(): Int {
        val games = input.map { it.split(" ").map { str -> mapInputToSign(str.first()) } }
        val scores = games.map { getScore(it[0], it[1]) }

        return scores.sum()
    }

    fun solvePart2(): Int {
        val scores = input.map {
            val (opponentChar, resultChar) = it.split(" ").map { str -> str.first() }
            val opponentSign = mapInputToSign(opponentChar)
            val playerSign = when (opponentSign to resultChar) {
                Sign.SCISSORS to 'X', Sign.PAPER to 'Y', Sign.ROCK to 'Z' -> Sign.PAPER
                Sign.PAPER to 'X', Sign.ROCK to 'Y', Sign.SCISSORS to 'Z' -> Sign.ROCK
                Sign.ROCK to 'X', Sign.SCISSORS to 'Y', Sign.PAPER to 'Z' -> Sign.SCISSORS
                else -> {
                    throw Error("Could not convert result char to player sign. Check your input.")
                }
            }
            getScore(playerSign, opponentSign)

        }

        return scores.sum()
    }
}