package com.example.fragmenttask.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmenttask.ItemAdapter;
import com.example.fragmenttask.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListFragment extends Fragment {


    private RecyclerView recyclerView;
    private List<Pair<String, Boolean>> itemList;
    private ItemAdapter adapter;


    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        itemList = new ArrayList<>();
        adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        return v;
    }

    public void addItemToList(String itemName) {
        adapter.addItemToList(itemName);
        recyclerView.smoothScrollToPosition(adapter.getItemCount()-1);
    }


    public void deleteItems() {
        adapter.deleteItems();
    }
}