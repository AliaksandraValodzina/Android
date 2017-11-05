package com.example.volodin.simpleform;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LunchList extends MainActivity {
    Restaurant restaurant = new Restaurant();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(onSave);
    }

    private View.OnClickListener onSave = new View.OnClickListener()
    {
        public void onClick(View view)
        {
            EditText name = (EditText)findViewById(R.id.name);
            EditText address = (EditText)findViewById(R.id.addr);

            restaurant.setName(name.getText().toString());
            restaurant.setAddress(address.getText().toString());
        }
    };
}
