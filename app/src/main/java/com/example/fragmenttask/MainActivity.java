package com.example.fragmenttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmenttask.fragments.BottomFragment;
import com.example.fragmenttask.fragments.ListFragment;

public class MainActivity extends AppCompatActivity implements BottomFragment.FragmentListener {

    private BottomFragment bottomFragment;
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomFragment = new BottomFragment();
        listFragment = new ListFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_fragment, listFragment)
                .replace(R.id.bottom_fragment, bottomFragment)
                .commit();
    }

    @Override
    public void addItem(String s) {
        listFragment.addItemToList(s);
    }

    @Override
    public void deleteItems() {
        listFragment.deleteItems();
    }
}