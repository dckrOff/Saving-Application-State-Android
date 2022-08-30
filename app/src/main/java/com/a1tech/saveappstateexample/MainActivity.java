package com.a1tech.saveappstateexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    User user = new User("undefined", 0);
    final static String userVariableKey = "USER_VARIABLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // сохранение состояния
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putSerializable(userVariableKey, user);
        super.onSaveInstanceState(outState);
    }

    // получение ранее сохраненного состояния
    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // получаем объект User в переменную
        user = (User) savedInstanceState.getSerializable(userVariableKey);
        TextView dataView = findViewById(R.id.dataView);
        dataView.setText("Name: " + user.getName() + " Age: " + user.getAge());
    }

    public void saveData(View view) {
        // получаем введенные данные
        EditText nameBox = findViewById(R.id.nameBox);
        EditText yearBox = findViewById(R.id.yearBox);
        String name = nameBox.getText().toString();
        int age = 0;  // значение по умолчанию, если пользователь ввел некорректные данные
        try {
            age = Integer.parseInt(yearBox.getText().toString());
        } catch (NumberFormatException ex) {
        }
        user = new User(name, age);
    }

    public void getData(View view) {

        // получаем сохраненные данные
        TextView dataView = findViewById(R.id.dataView);
        dataView.setText("Name: " + user.getName() + " Age: " + user.getAge());
    }
}