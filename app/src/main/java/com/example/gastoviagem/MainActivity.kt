package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // propriedade chamada binding do tipo ActivityMainBinding; lateinit indica que sera inicializado depois
    private lateinit var binding: ActivityMainBinding //declarando o binding para usar em qualquer escopo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //cria uma instancia da classe AMB inflando o layout
        setContentView(binding.root) //defino a visualizacao do conteudo da atividade como a visualizacao raiz do layout inflado

        binding.buttonCalculate.setOnClickListener(this) //chamando o botao do xml
    }

    override fun onClick(view: View){ //funcao onclick
        if(view.id == R.id.button_calculate){
            calculate() //executa essa funcao que esta dentro do bloco
        }
    }

    private fun validation(): Boolean { //funcao do tipo booleana para validar se o campos estao vazios
            return (binding.editDistance.text.toString() != ""
                    && binding.editPrice.text.toString() != ""
                    && binding.editAutonomy.text.toString() != ""
                    && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate(){
        if(validation()){ //se a funcao validation for valida
            val distance = binding.editDistance.text.toString().toFloat() //declarando a variavel e dando o valor do edit_text
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val total = (distance * price) / autonomy // declarando a variavel total e passando a logica
            binding.textTotalValue.text ="R$ ${"%.2f".format(total)}" //colocando o resultado para o text_view, formatando seu resultado

        } else {
            Toast.makeText(this,R.string.validation_space,Toast.LENGTH_LONG).show() //exibe um texto na tela ao clicar com os campos vazios
        }



    }
}