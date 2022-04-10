package com.example.delinev6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button add;
    AlertDialog dialog;
    AlertDialog dialogAsst;
    LinearLayout layout;
    LinearLayout layoutA;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();

        add = findViewById(R.id.add);
        layout = findViewById(R.id.container);
        layoutA = findViewById(R.id.assign_list);
        showAssignDialog();
        findViewById(R.id.addA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAsst.show();

            }
        });

        buildDialog();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }
// Assignment Dialog
    //still need to populate spinner with course names
    private void showAssignDialog() {
        AlertDialog.Builder builderA = new AlertDialog.Builder(this);
        View viewA = getLayoutInflater().inflate(R.layout.dialogasst, null);

        final EditText title = viewA.findViewById(R.id.titleEdit);

        builderA.setView(viewA);
        builderA.setTitle("Enter Assignment Details")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogAsst, int which) {
                        addTile(title.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        dialogAsst= builderA.create();

    }
//Course Dialog
    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog, null);

        final EditText name = view.findViewById(R.id.nameEdit);

        builder.setView(view);
        builder.setTitle("Enter Course Name")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addCard(name.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        dialog = builder.create();
    }

    private void addCard(String name) {
        final View view = getLayoutInflater().inflate(R.layout.card, null);

        TextView nameView = view.findViewById(R.id.name);
        Button delete = view.findViewById(R.id.delete);

        nameView.setText(name);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeView(view);
            }
        });

        layout.addView(view);
    }
    //add tiles doesnt include adding which course and selected due date
    private void addTile(String name) {
        final View viewAt = getLayoutInflater().inflate(R.layout.tile, null);

        TextView titleView = viewAt.findViewById(R.id.title);
        Button delete = viewAt.findViewById(R.id.delete_btn);

        titleView.setText(name);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutA.removeView(viewAt);
            }
        });

        layoutA.addView(viewAt);
    }



}

