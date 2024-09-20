package com.example.lab3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val s: TextInputEditText = findViewById(R.id.inputstring)
        val so: TextInputEditText = findViewById(R.id.inputfirst)
        val sn: TextInputEditText = findViewById(R.id.inputsecond)

        val rebuildButton: Button = findViewById(R.id.button)
        val s1: TextView = findViewById(R.id.viewall)

        rebuildButton.setOnClickListener {
            val inputs: String = s.text.toString()
            val sold: String = so.text.toString()
            val snew: String = sn.text.toString()

            // Убедимся, что введенный индекс корректен
            val soldIndex: Int? = sold.toIntOrNull()?.minus(1) // Преобразуем в индекс с нуля

            if (soldIndex != null && soldIndex in inputs.indices && snew.isNotEmpty()) {
                // Создаем новый StringBuilder для изменения исходной строки
                val result = StringBuilder(inputs)

                // Заменяем символ по указанному индексу на новый символ
                result[soldIndex] = snew[0]

                // Устанавливаем измененную строку в TextView
                s1.text = result.toString()
            } else {
                // Обрабатываем некорректный ввод (например, индекс вне границ или пустой новый символ)
                s1.text = "Некорректный ввод. Пожалуйста, проверьте ваши значения."
            }
        }
    }
}
