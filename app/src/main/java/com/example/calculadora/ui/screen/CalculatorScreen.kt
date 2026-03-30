import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ui.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = viewModel()) {

    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // centraliza vertical
        horizontalAlignment = Alignment.CenterHorizontally // centraliza horizontal
    ) {

        TextField(
            value = state.num1,
            onValueChange = { viewModel.updateNum1(it) },
            label = { Text("Num1") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = state.num2,
            onValueChange = { viewModel.updateNum2(it) },
            label = { Text("Num2") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Primeira Linha
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { viewModel.calcular("+") },
                modifier = Modifier
                    .weight(1f)
                    .height(46.dp)
            ) { Text("+") }

            Button(
                onClick = { viewModel.calcular("-") },
                modifier = Modifier
                    .weight(1f)
                    .height(46.dp)
            ) { Text("-") }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Segunda Linha
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { viewModel.calcular("*") },
                modifier = Modifier
                    .weight(1f)
                    .height(46.dp)
            ) { Text("*") }

            Button(
                onClick = { viewModel.calcular("/") },
                modifier = Modifier
                    .weight(1f)
                    .height(46.dp)
            ) { Text("/") }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botão de Limpar
        Button(
            onClick = { viewModel.limpar() },
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
        ) {
            Text("C")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Resultado: ${state.resultado}",
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}