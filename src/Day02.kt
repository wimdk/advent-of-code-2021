import kotlin.streams.toList

fun main() {



    fun part1(input: List<String>): Int {
        val inputPair = input.stream()
            .map { x -> Pair(x.substringBefore(' ').trim(), x.substringAfter(' ').trim()) }
        val horizontalMovementTotal = inputPair
            .filter { pair -> pair.first.equals("forward")}.map { forward -> forward.second.toInt() }.reduce{sum, element -> sum+element}.get()
        val verticalMovementUpTotal = inputPair
           .filter { pair -> pair.first.equals("up")}.map { forward -> forward.second.toInt() }.reduce{sum, element -> sum+element}.get()
        val verticalMovementsDownTotal = inputPair
            .filter { pair -> pair.first.equals("down")}.map { forward -> forward.second.toInt() }.reduce{sum, element -> sum+element}.get()
        return horizontalMovementTotal.times(verticalMovementsDownTotal.minus(verticalMovementUpTotal))
    }



    fun part2(input: List<String>): Int {

        var aim = 0
        var horizontalPosition = 0
        var depth = 0

       val movementsList = input.stream()
           .map{ y -> Pair(y.substringBefore(' ').trim(), y.substringAfter(' ').trim()) }.toList()


       movementsList.forEach() {
            if (it.first.equals("down")) {
                aim+= it.second.toInt()
            }
            else if(it.first.equals("up")) {
                aim-=it.second.toInt()
            }
            else if (it.first.equals("forward")) {
                horizontalPosition+=it.second.toInt()
                depth+=(aim.times(it.second.toInt()))
            }
        }
        return horizontalPosition.times(depth)
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")

    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println("part1 "+part1(input))
    println("part2 " + part2(input))
}