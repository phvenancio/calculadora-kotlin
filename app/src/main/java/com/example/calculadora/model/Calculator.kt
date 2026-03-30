package domain

class Calculator {

    fun somar(a: Double, b: Double) = a + b
    fun subtrair(a: Double, b: Double) = a - b
    fun multiplicar(a: Double, b: Double) = a * b
    fun dividir(a: Double, b: Double): Double? {
        return if (b == 0.0) null else a / b
    }
}