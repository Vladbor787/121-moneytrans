import kotlin.math.roundToInt

const val commissionRate = 0.0075F
const val minTransferCommission = 3500.0F
const val numbKopInRub = 100
val arrOfRubl = arrayOf("рубль", "рубля", "рублей")
val arrOfKopeiki = arrayOf("копейка", "копейки", "копеек")
var amountInRub: Float = 0.0f

fun main() {
    while (true) {
        print("Введите сумму перевода в рублях для расчета комиссии : ")
        try {
            amountInRub = readLine()!!.toFloat()
            if (amountInRub > 0) break
            else println("Введённое значение либо нулевое либо имеет отрицательное значение. Попробуйте заново")
            continue
        } catch (e: NumberFormatException) {
            println("Неправильный ввод. Попробуйте заново")
        }
    }
    calculateCommissions(amountInRub)
}

fun endUtil(T: Int, arrsome: Array<String>): String {
    return if (T % 10 == 1 && T % 100 != 11) T.toString() + " " + arrsome[0]
    else if (T % 10 == 2 && T % 100 != 12 || T % 10 == 3 && T % 100 != 13 || T % 10 == 4 && T % 100 != 14) T.toString() + " " + arrsome[1]
    else T.toString() + " " + arrsome[2]
}

fun calculateCommissions(amountInRub : Float) {
    val amountInKop = amountInRub * numbKopInRub
    val commissionInKop = kotlin.math.max(minTransferCommission, amountInKop * commissionRate).roundToInt()
    val discAmountInKop = (amountInKop + commissionInKop).roundToInt()
    val rub =  endUtil(discAmountInKop/100,arrOfRubl)
    val kop = endUtil(discAmountInKop%100,arrOfKopeiki)
    println("Сумма перевода в рублях : $amountInRub")
    println("Комиссия за перевод(в копейках) составит :$commissionInKop")
    println("Итоговая сумма составит :  $rub $kop")

}