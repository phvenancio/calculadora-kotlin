package ui.viewmodel

import androidx.lifecycle.ViewModel
import ui.state.CalculatorState
import domain.Calculator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel : ViewModel() {

    private val calculator = Calculator()

    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state.asStateFlow()

    fun updateNum1(value: String) {
        _state.value = _state.value.copy(num1 = value)
    }

    fun updateNum2(value: String) {
        _state.value = _state.value.copy(num2 = value)
    }

    fun calcular(op: String) {

        val num1Str = _state.value.num1
        val num2Str = _state.value.num2

        // Campos vazios
        if (num1Str.isBlank() || num2Str.isBlank()) {
            _state.value = _state.value.copy(resultado = "Preencha ambos os números")
            return
        }

        val n1 = num1Str.toDoubleOrNull()
        val n2 = num2Str.toDoubleOrNull()

        // Letras ou valor inválido
        if (n1 == null || n2 == null) {
            _state.value = _state.value.copy(resultado = "Digite apenas números válidos")
            return
        }

        // Divisão por zero
        if (op == "/" && n2 == 0.0) {
            _state.value = _state.value.copy(resultado = "Não é possível dividir por zero")
            return
        }

        val result = when (op) {
            "+" -> calculator.somar(n1, n2)
            "-" -> calculator.subtrair(n1, n2)
            "*" -> calculator.multiplicar(n1, n2)
            "/" -> calculator.dividir(n1, n2)
            else -> null
        }

        _state.value = _state.value.copy(
            resultado = result?.toString() ?: "Erro"
        )
    }

    fun limpar() {
        _state.value = CalculatorState()
    }
}