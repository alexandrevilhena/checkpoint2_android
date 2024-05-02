package br.com.fiap.listadecompras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter //amarra o ItemsAdapter com recyclerView

        val button = findViewById<Button>(R.id.button)
        val apaga = findViewById<Button>(R.id.button2)
        val editText = findViewById<EditText>(R.id.editText)

        //Ouvir eventos esperando o clique
        button.setOnClickListener {
            val item = ItemModel(
                name = editText.text.toString() //converte o objeto para String
            )

            itemsAdapter.addItem(item)
            editText.setText("");
        }

        apaga.setOnClickListener{
            recyclerView.removeAllViewsInLayout()
        }
    }
}