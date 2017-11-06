package com.example.volodin.simpleform;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class LunchList extends MainActivity {
    List<Restaurant> model = new ArrayList<Restaurant>();
    ArrayAdapter<Restaurant> adapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(onSave);

        ListView listView = (ListView)findViewById(R.id.restaurants);

        adapter = new ArrayAdapter<Restaurant>(this,
                android.R.layout.simple_list_item_1,
                model);
        listView.setAdapter(adapter);
    }

    private View.OnClickListener onSave = new View.OnClickListener()
    {
        public void onClick(View view)
        {
            Restaurant restaurant = new Restaurant();
            EditText name = (EditText)findViewById(R.id.name);
            EditText address = (EditText)findViewById(R.id.addr);

            restaurant.setName(name.getText().toString());
            restaurant.setAddress(address.getText().toString());

            RadioGroup types = (RadioGroup)findViewById(R.id.types);

            switch (types.getCheckedRadioButtonId())
            {
                case R.id.sitDown:
                    restaurant.setType("sit_down");
                    break;

                case R.id.takeOut:
                    restaurant.setType("take_out");
                    break;

                case R.id.delivery:
                    restaurant.setType("delivery");
                    break;
            }

            adapter.add(restaurant);
        }
    };
}
