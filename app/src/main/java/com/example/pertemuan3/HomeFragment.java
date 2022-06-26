package com.example.pertemuan3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment {
    TextView textView1;
    EditText editText1;
    Button submitBtn;
    AlertDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        textView1 = v.findViewById(R.id.tv1);
        editText1 = v.findViewById(R.id.et1);
        submitBtn= v.findViewById(R.id.submit_btn);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Confirmation").setMessage("Are you sure you want to change the text?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textView1.setText(editText1.getText().toString());
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
                Toast.makeText(getActivity(), "Changes made", Toast.LENGTH_SHORT).show();
            }
        });
        dialog = builder.create();

        submitBtn.setOnClickListener(view ->{
            dialog.show();
        });

        return v;
    }
    }
}