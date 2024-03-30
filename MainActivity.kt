package com.vinimaia.projetofinalrestic10

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vinimaia.projetofinalrestic10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private lateinit var petit_gateau: CheckBox
    private lateinit var pacoquita: CheckBox
    private lateinit var peixe_delicia: CheckBox
    private lateinit var carne_sol: CheckBox

    private var total = 0.0
    private lateinit var menu: Map<CheckBox, Double>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        petit_gateau = findViewById(R.id.dessert_petit_gateau_checkbox)
        pacoquita = findViewById(R.id.dessert_pacoquita_checkbox)
        peixe_delicia = findViewById(R.id.main_dish_peixe_delicia_checkbox)
        carne_sol = findViewById(R.id.main_dish_carne_sol_checkbox)

        menu = mapOf(
            petit_gateau to 15.90,
            pacoquita to 1.50,
            peixe_delicia to 47.90,
            carne_sol to 38.50
        )

        binding.button.setOnClickListener(this)

        // essas funções "amarram" funções anônimas à cada checkbox do layout
        create_desserts_checkbox_events()
        create_main_dishes_checkbox_events()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button) {
            if (total == 0.0) {
                nothing_checked_error()
            } else {
                confirm_order()
            }
        }
    }

    fun nothing_checked_error() {
        Toast.makeText(this, R.string.nothing_checked, Toast.LENGTH_SHORT).show()
    }

    fun confirm_order() {
        Toast.makeText(this, R.string.confirmed_order, Toast.LENGTH_LONG).show()
    }

    fun create_desserts_checkbox_events() {
        petit_gateau.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                val price = menu[petit_gateau]

                if (price != null) {
                    total += price
                }
            } else {
                val price = menu[petit_gateau]

                if (price != null) {
                    total -= price

                    if (total <= 0.0) {total = 0.0}
                }
            }

            val result = "R$ ${"%.2f".format(total)}"
            binding.result.text = result
        }

        pacoquita.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                val price = menu[pacoquita]

                if (price != null) {
                    total += price
                }
            } else {
                val price = menu[pacoquita]

                if (price != null) {
                    total -= price

                    if (total <= 0.0) {total = 0.0}
                }
            }

            val result = "R$ ${"%.2f".format(total)}"
            binding.result.text = result
        }
    }

    fun create_main_dishes_checkbox_events() {
        carne_sol.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                val price = menu[carne_sol]

                if (price != null) {
                    total += price
                }
            } else {
                val price = menu[carne_sol]

                if (price != null) {
                    total -= price

                    if (total <= 0.0) {total = 0.0}
                }
            }

            val result = "R$ ${"%.2f".format(total)}"
            binding.result.text = result
        }

        peixe_delicia.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                val price = menu[peixe_delicia]

                if (price != null) {
                    total += price
                }
            } else {
                val price = menu[peixe_delicia]

                if (price != null) {
                    total -= price

                    if (total <= 0.0) {total = 0.0}
                }
            }

            val result = "R$ ${"%.2f".format(total)}"
            binding.result.text = result
        }
    }
}