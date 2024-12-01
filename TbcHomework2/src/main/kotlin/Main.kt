fun main(args: Array<String>) {
    println(greatestCommonMultiple(11, 432))
    println(greatestCommonDenominator(11, 11))
    println(containsOrNot(""))
    println(reverseNumber(134500))
    println(isPolindrom("ana"))
    println(recursionSum(50))
}

fun greatestCommonMultiple(number1: Int, number2: Int): Int {
    var answer = 0
    if (number1 >= number2)
        answer = number1
    else answer = number2
    while (true) {
        if (answer % number1 == 0 && answer % number2 == 0) {
            break
        }
        answer++
    }
    return answer
}

fun greatestCommonDenominator(number1: Int, number2: Int): Int {
    var firstNumber = number1
    var secondNumber = number2

    while (secondNumber != 0) {
        var answer = secondNumber
        secondNumber = firstNumber % secondNumber
        firstNumber = answer
    }
    return firstNumber
}

fun containsOrNot(input: String): Boolean {
    return input.contains('$')
}

fun recursionSum(number: Int = 100): Int {
    if (number == 2) return 2
    return number + recursionSum(number - 2)
}

fun reverseNumber(number: Int): Int {
    val finalNumber = number.toString().reversed()
    return finalNumber.toInt()
}

fun isPolindrom(text: String): Boolean {
    val correctText = text
    val reversedText = text.reversed()

    return correctText == reversedText
}