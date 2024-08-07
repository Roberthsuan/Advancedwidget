package com.example.listviewtest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView cityListView;
    private List<String> cities = new ArrayList<String>();

    private class CityAdapter extends ArrayAdapter<City>{
        public CityAdapter(@NonNull Context context, ArrayList<City> cities) {
            super(context,0,cities);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            City city = getItem(position);

            if(convertView==null){
                convertView= LayoutInflater.from(getContext()).inflate(R.layout.city_information,parent,false);
            }
            TextView tv_cityname =(TextView) convertView.findViewById(R.id.cityname);
            TextView tv_zipcode=(TextView) convertView.findViewById(R.id.zipcode);

            tv_cityname.setText(city.name);
            tv_zipcode.setText(String.valueOf(city.zipcode));
            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        ListView lv = (ListView) findViewById(R.id.citylistview);
//        lv.setOnItemClickListener(this);
        cityListView=(ListView) findViewById(R.id.citylistview);
        setCities();
        cityListView.setOnItemClickListener(this);
    }

    public void setCities() {
//        cities = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.cities)));
//        cities.add("Hualien");
//        cities.add("Tokyo");
//        cities.add("Okinawa");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cities);
//        cityListView.setAdapter(adapter);


        ArrayList<City> cityList = new ArrayList<>();
        cityList.add(new City("Taichung", 400));
        cityList.add(new City("Taipei", 401));
        cityList.add(new City("Tokyo", 402));

        CityAdapter adapter = new CityAdapter(this, cityList);
        cityListView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView tv = (TextView) findViewById(R.id.textView);
        //String[] citiesArray = getResources().getStringArray(R.array.cities);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("city");
        dialog.setMessage("ur choice:" + cities.get(i));
        dialog.setCancelable(true);
        dialog.setPositiveButton("confirm", null);
        dialog.setNeutralButton("cancel", null);
        dialog.setNegativeButton("discard", null);
        dialog.show();

        //tv.setText("您選擇的是:"+citiesArray[i]);
        //Toast.makeText(this,"您選擇的是:"+citiesArray[i],Toast.LENGTH_LONG).show();

    }
}