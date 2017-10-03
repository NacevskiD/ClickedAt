package com.example.david.clickedat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.new_list);
        Button button = (Button) findViewById(R.id.click);
        final ArrayList<String> clickedAtList = new ArrayList<String>();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_view,R.id.list_text,clickedAtList);
        listView.setAdapter(arrayAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat df = new SimpleDateFormat("HH:mm:ss a");
                String date = df.format(Calendar.getInstance().getTime());
                //String currentTime = date.toString();
                clickedAtList.add("Clicked at " + date);
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}
