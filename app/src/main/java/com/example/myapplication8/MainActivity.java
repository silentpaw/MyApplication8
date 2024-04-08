package com.example.myapplication8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart = findViewById(R.id.button1);
        Button btnStart1 = findViewById(R.id.button2);
        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создание и запуск первого потока
                Thread task1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("DDD", "Запущена задача 1");
                        // Выполнение задачи 1
                        doTask1();
                    }
                });
                task1.start();

                // Создание и запуск второго потока
                Thread task2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("DDD", "Запущена задача 2");
                        // Выполнение задачи 2
                        doTask2();
                    }
                });
                task2.start();
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Запуск первой задачи
                Thread task1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("DDD", "Запущена задача 1");
                        // Выполнение задачи 1
                        doTask1();
                    }
                });
                task1.start();

                // Ожидание завершения первой задачи и запуск второй задачи
                try {
                    task1.join();
                    Thread task2 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("DDD", "Запущена задача 2");
                            // Выполнение задачи 2
                            doTask2();
                        }
                    });
                    task2.start();

                    // Ожидание завершения второй задачи и запуск третьей задачи
                    task2.join();
                    Thread task3 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("DDD", "Запущена задача 3");
                            // Выполнение задачи 3
                            doTask3();
                        }
                    });
                    task3.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void doTask1() {
        // Здесь выполнение задачи 1
        try {
            Thread.sleep(2000); // Пример задержки на 2 секунды
            Log.d("DDD", "Завершена задача 1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doTask2() {
        // Здесь выполнение задачи 2
        try {
            Thread.sleep(2000); // Пример задержки на 2 секунды
            Log.d("DDD", "Завершена задача 2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doTask3() {
        // Здесь выполнение задачи 3
        try {
            Thread.sleep(2000); // Пример задержки на 2 секунды
            Log.d("DDD", "Завершена задача 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
