package com.example.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] names;
    String[] surnames;
    ArrayList<String> data = new ArrayList<>();
    ListView listview;
    ArrayAdapter<String> stringArrayAdapter;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getResources().getStringArray(R.array.names);
        surnames = getResources().getStringArray(R.array.surname);

        listview = findViewById(R.id.listview);
        stringArrayAdapter = new ArrayAdapter<>(this, R.layout.item, data);
        listview.setAdapter(stringArrayAdapter);
        listview.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ColorDrawable colorDrawable = (ColorDrawable) view.getBackground();
            if (colorDrawable != null && colorDrawable.getColor() == Color.GREEN){
                view.setBackgroundColor(Color.TRANSPARENT);
            } else {
                view.setBackgroundColor(Color.GREEN);
            }
        }
    };

    public void addItem(View v) {
        int nameId = random.nextInt(names.length);
        int surnameId = random.nextInt(surnames.length);

        String str = names[nameId] + " " + surnames[surnameId];

        data.add(str);

        stringArrayAdapter.notifyDataSetChanged();
    }
}