package com.example.orientacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

/*
    Salvar dados da tela ao sofrer a rotação do aparelho
 */

class MainActivity : AppCompatActivity() {

    var mutNames = mutableListOf<String>()
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //se o saveInstance não for nulo inicializa os nomes carregados previamente
        if (savedInstanceState != null) {
            mutNames = savedInstanceState.getStringArrayList("listNames") as MutableList<String>
        }

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutNames)
        listNames.adapter = adapter

        btnAdd.setOnClickListener {
            mutNames.add(editText.text.toString())
            editText.text.clear()
            adapter?.notifyDataSetChanged()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putStringArrayList("listNames",mutNames as ArrayList<String>)
    }
}
