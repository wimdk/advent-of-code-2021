import kotlin.streams.toList

fun main() {

    fun numberOfIncreases(input: List<Int>): Int {
        var numberOfIncreases = -1
        var previousValue = 0
        for (current in input) {
            if(current > previousValue) {
                numberOfIncreases++
            }
            previousValue = current
        }
        return numberOfIncreases
    }

    fun part1(input: List<String>): Int {
        val inputNumbers = input.stream().map { it.toInt()}.toList()

        return numberOfIncreases(inputNumbers)

    }

    fun part2(input: List<String>): Int {
        val inputNumbers = input.stream().map { it.toInt()}.toList()

        val slidingWindows = mutableListOf<Int>()
        val numberOfInputs = inputNumbers.size

        for(i in 0 .. numberOfInputs-3) {
            slidingWindows.add(inputNumbers[i]+inputNumbers[i+1]+inputNumbers[i+2])
        }
        return numberOfIncreases(slidingWindows)
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}