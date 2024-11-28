import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    var isTrue = true
    while (isTrue) {
        println("გთხოვთ შეიყვანოთ X --> ")
        val userInputX = reader.next()
        println("გთხოვთ შეიყვანოთ Y --> ")
        val userInputY = reader.next()
        val xNumberValue = checkNumbersInText(userInputX)
        val yNumberValue = checkNumbersInText(userInputY)
        try {
            val answerZ = xNumberValue / yNumberValue
            println("X და Y განაყოფი არის: $answerZ")
        } catch (e: ArithmeticException) {
            println("ნულზე გაყოფა არ შეიძლება")
        }
        println("გსურთ პროგრამის ხელახლა დაწყება <Y/N>?")
        while (true) {
            val userAnswer = reader.next()
            if (userAnswer == "დიახ") {
                break
            } else if (userAnswer == "არა") {
                isTrue = false
                break
            } else
                println("მოხდა გაუთვალისინებელი შეცდომა ! სწორად შეიყვანეთ სიტყვა 'დიახ' ან 'არა' ")
            continue
        }
    }
}

fun checkNumbersInText(input: String): Int {
    val number = StringBuilder()
    for (index in input) {
        if (index.isDigit()) {
            number.append(index)
        }
        if (number.isEmpty()) {
            number.append(0)
        }
    }
    return number.toString().toInt()
}
