package com.example.fragmenttask.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmenttask.R;


public class BottomFragment extends Fragment {

    private EditText input;
    private Button add, delete;
    private FragmentListener listener;

    public BottomFragment() {
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
        View v = inflater.inflate(R.layout.fragment_bottom, container, false);
        input = v.findViewById(R.id.input);
        add = v.findViewById(R.id.add);
        delete = v.findViewById(R.id.delete);

        add.setOnClickListener(view -> {
            String itemName = input.getText().toString();
            listener.addItem(itemName);
        });

        delete.setOnClickListener(view -> listener.deleteItems());

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof FragmentListener){
            listener = (FragmentListener) context;
        }else {
            throw new RuntimeException(context.toString()+" must implements FragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface FragmentListener {
        void addItem(String s);
        void deleteItems();
    }

}