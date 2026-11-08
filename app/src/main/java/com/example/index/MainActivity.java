package com.example.index;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText taskInput;
    Button addButton;
    ListView taskList;

    ArrayList<String> tasks;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskInput = findViewById(R.id.taskInput);
        addButton = findViewById(R.id.addButton);
        taskList = findViewById(R.id.taskList);

        tasks = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                tasks
        );

        taskList.setAdapter(adapter);

        addButton.setOnClickListener(v -> {

            String task = taskInput.getText().toString().trim();

            if (!task.isEmpty()) {
                tasks.add(task);
                adapter.notifyDataSetChanged();
                taskInput.setText("");
            } else {
                Toast.makeText(this,
                        "Enter a task!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        taskList.setOnItemClickListener((parent, view, position, id) -> {
            tasks.remove(position);
            adapter.notifyDataSetChanged();
        });
    }
}