package com.example.lesson2mod4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //ПОЛЯ

    private EditText idIn;
    private EditText ageIn;
    private EditText departureIn;
    private EditText arrivalIn;
    private EditText departureDateIn;

    private Button button;

    private String id;
    private int age;
    private int cost;
    private String departurePoint;
    private String arrivalPoint;
    private String departureDate;

    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //привязка полей к разметке

        idIn = findViewById(R.id.idIn);
        ageIn = findViewById(R.id.ageIn);
        departureIn = findViewById(R.id.departureIn);
        arrivalIn = findViewById(R.id.arrivalIn);
        departureDateIn = findViewById(R.id.departureDateIn);
        button = findViewById(R.id.button);

        //обработка нажатия кнопки
        button.setOnClickListener(listener);

    }

    //создание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //исполняемый код при нажатии кнопки
            //считывание данных с окон ввода
            //Toast.makeText(MainActivity.this,"Жмяк",Toast.LENGTH_SHORT).show();
            id = idIn.getText().toString();
            departurePoint = departureIn.getText().toString();
            arrivalPoint = arrivalIn.getText().toString();
            departureDate = departureDateIn.getText().toString();

            try { // исключение на случай ввода не числа типа Int
                age = Integer.parseInt(ageIn.getText().toString());

            } catch (NumberFormatException exception) {
                Toast.makeText(MainActivity.this, "Вы ввели не число", Toast.LENGTH_SHORT).show();
            }
            //задание условия
            if(age < 18) {
                Toast.makeText(MainActivity.this, "Билет можно оформить только с 18 лет", Toast.LENGTH_SHORT).show();
            } else {
                //условие стоимости билета
                switch (arrivalPoint) {
                    case "Moscow":
                        cost = 1000;
                        break;
                    case "Vladimir":
                        cost = 800;
                        break;
                    case "Kostroma":
                        cost = 900;
                        break;
                    case "Vladivostok":
                        cost = 7000;
                        break;
                    default:
                        cost = 1999;
                }
                //инициализация данных пользователя
                user = new User(id,age,departurePoint,arrivalPoint,departureDate,cost);

                //создание намерения и перехода в другую активность
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra(User.class.getSimpleName(), user);
                startActivity(intent);
            }
        }
    };
}
