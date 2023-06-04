package com.example.lesson2mod4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    // поля
    private TextView dataTicket;
    private Button button;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //привязка полей к разметке
        dataTicket = findViewById(R.id.dataTicket);
        button = findViewById(R.id.button);

        // получение данных о билете из интента
        Bundle bundleTicket = getIntent().getExtras();

        if (bundleTicket != null) {
            user = (User) bundleTicket.getSerializable(User.class.getSimpleName());

            //вывод данных о билете на экран

            dataTicket.setText("Билет на пассажира " + user.getId() + "\n"
                    + "Место отправления " + user.getDeparturePoint() + "\n"
                    + "Место прибытия " + user.getArrivalPoint() + "\n"
                    + "Время отправления " + user.getDepartureDate() + "\n"
                    + "Стоимость билета " + user.getCost());
        }
        //обработка нажатия кнопки
        button.setOnClickListener(listener);
    }

    //создание слушателя кнопки
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //исполняемый код при нажатии кнопки
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };
}
