package com.a1tech.saveappstateexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class SaveArrayListActivity extends ListActivity {
        ArrayList<MyObject> list;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if(savedInstanceState == null || !savedInstanceState.containsKey("key")) {
                String[] colors = {"black", "red", "orange", "cyan", "green", "yellow", "blue", "purple", "magenta", "white"};
                String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

                list = new ArrayList<>();
                for(int i = 0; i < numbers.length; i++)
                    list.add(new MyObject(numbers[i], colors[i]));
            }
            else {
                list = savedInstanceState.getParcelableArrayList("key");
            }
            setListAdapter(new ArrayAdapter<MyObject>(this, android.R.layout.simple_list_item_1, list));
        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {
            outState.putParcelableArrayList("key", list);
            super.onSaveInstanceState(outState);
        }
    }