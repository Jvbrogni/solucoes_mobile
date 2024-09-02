package com.mobileJoao

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao1 = findViewById<Button>(R.id.botao1)
        val botao2 = findViewById<Button>(R.id.botao2)
        val botao3 = findViewById<Button>(R.id.botao3)
        val botao4 = findViewById<Button>(R.id.botao4)
        val botao5 = findViewById<Button>(R.id.botao5)
        val botao6 = findViewById<Button>(R.id.botao6)
        val botao7 = findViewById<Button>(R.id.botao7)
        val botao8 = findViewById<Button>(R.id.botao8)
        val botao9 = findViewById<Button>(R.id.botao9)
        val botao0 = findViewById<Button>(R.id.botao0)
        val botaoLimpa = findViewById<Button>(R.id.botaoLimpa)
        val botaoMultipla = findViewById<Button>(R.id.botaoMultipla)
        val botaoSoma = findViewById<Button>(R.id.botaoSoma)
        val botaoSubtrai = findViewById<Button>(R.id.botaoSubtrai)
        val botaoIgual = findViewById<Button>(R.id.botaoIgual)
        val botaoDivide = findViewById<Button>(R.id.botaoDivide)
        val caixaTexto = findViewById<TextView>(R.id.caixaTexto)

        val numberButtons = listOf(
            R.id.botao0, R.id.botao1, R.id.botao2, R.id.botao3, R.id.botao4,
            R.id.botao5, R.id.botao6, R.id.botao7, R.id.botao8, R.id.botao9
        )


        botao1.setOnClickListener { view ->
            caixaTexto.text =
                if (caixaTexto.text == "0") "1" else caixaTexto.text.toString().plus(other = "1")
        }
        botao2.setOnClickListener { view ->
            caixaTexto.text =
                if (caixaTexto.text == "0") "2" else caixaTexto.text.toString().plus(other = "2")
        }
        botao3.setOnClickListener { view ->
            caixaTexto.text =
                if (caixaTexto.text == "0") "3" else caixaTexto.text.toString().plus(other = "3")
        }
        botao4.setOnClickListener { view ->
            caixaTexto.text =
                if (caixaTexto.text == "0") "4" else caixaTexto.text.toString().plus(other = "4")
        }
        botao5.setOnClickListener { view ->
            caixaTexto.text =
                if (caixaTexto.text == "0") "5" else caixaTexto.text.toString().plus(other = "5")
        }
        botao6.setOnClickListener { view ->
            caixaTexto.text =
                if (caixaTexto.text == "0") "6" else caixaTexto.text.toString().plus(other = "6")
        }
        botao7.setOnClickListener { view ->
            caixaTexto.text =
                if (caixaTexto.text == "0") "7" else caixaTexto.text.toString().plus(other = "7")
        }
        botao8.setOnClickListener { view ->
            caixaTexto.text =
                if (caixaTexto.text == "0") "8" else caixaTexto.text.toString().plus(other = "8")
        }
        botao9.setOnClickListener { view ->
            caixaTexto.text =
                if (caixaTexto.text == "0") "9" else caixaTexto.text.toString().plus(other = "9")
        }
        botao0.setOnClickListener { view ->
            caixaTexto.text =
                if (caixaTexto.text == "0") "0" else caixaTexto.text.toString().plus(other = "0")
        }

        botaoLimpa.setOnClickListener { view ->
            caixaTexto.text = "0"

            var operador = ""
            var numero1 = 0
            var numero2 = 0

            // Configurando os listeners para os botões de números
            for (buttonId in numberButtons) {
                findViewById<Button>(buttonId).setOnClickListener { view ->
                    val buttonText = (view as Button).text.toString()
                    if (caixaTexto.text == "0") {
                        caixaTexto.text = buttonText
                    } else {
                        caixaTexto.append(buttonText)
                    }
                }
            }

            // Configurando listener para o botão de limpar
            botaoLimpa.setOnClickListener {
                caixaTexto.text = ""
                operador = ""
            }

            // Configurando listener para o botão de soma
            botaoSoma.setOnClickListener {
                operador = "+"
                numero1 = caixaTexto.text.toString().toInt()
                caixaTexto.text = ""
            }

            // Configurando listener para o botão de subtração
            botaoSubtrai.setOnClickListener {
                operador = "-"
                numero1 = caixaTexto.text.toString().toInt()
                caixaTexto.text = ""
            }

            // Configurando listener para o botão de multiplicação
            botaoMultipla.setOnClickListener {
                operador = "*"
                numero1 = caixaTexto.text.toString().toInt()
                caixaTexto.text = ""
            }

            botaoDivide.setOnClickListener {
                operador = "/"
                numero1 = caixaTexto.text.toString().toInt()
                caixaTexto.text = ""
            }

            // Configurando listener para o botão de igual
            botaoIgual.setOnClickListener {
                numero2 = caixaTexto.text.toString().toInt()
                val resultado = when (operador) {
                    "+" -> numero1 + numero2
                    "-" -> numero1 - numero2
                    "*" -> numero1 * numero2
                    "/" -> {
                        if (numero2 != 0) {
                            numero1.toDouble() / numero2.toDouble()
                        } else {
                            // Tratamento de divisão por zero
                            // Você pode adicionar sua própria lógica aqui
                            // Por exemplo, exibir uma mensagem de erro
                            0.0
                        }
                    }
                    else -> 0 // Operador inválido
                }
                caixaTexto.text = resultado.toString().replace('.', ',')
                operador = ""
            }
        }
    }
}