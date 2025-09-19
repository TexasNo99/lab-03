package com.example.listycitylab3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        AddCityFragment.AddCityDialogListener {
    private ArrayList<City> dataList;
    private ListView cityList;
    private CityArrayAdapter cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] cities = { "Edmonton", "Vancouver", "Toronto" };
        String[] provinces = { "AB", "BC", "ON" };

        dataList = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            dataList.add(new City(cities[i], provinces[i]));
        }
        cityList = findViewById(R.id.city_list);
        cityAdapter = new CityArrayAdapter(this, dataList);
        cityList.setAdapter(cityAdapter);


        cityList.setOnItemClickListener((parent, view, position, id) -> {
            City selectedCity = dataList.get(position);
            AddCityFragment fragment = AddCityFragment.newInstance(selectedCity);
            fragment.show(getSupportFragmentManager(), "Edit City");
        });
    }

    // The following method is from OpenAI, ChatGPT,
    // "How to editing the city?", 2025-09-19
    @Override
    public void addCity(City city) {
        if (!dataList.contains(city)) {
            dataList.add(city);
        }
        cityAdapter.notifyDataSetChanged();
    }
}