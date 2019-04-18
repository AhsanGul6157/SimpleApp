package com.example.ahsannaveed.foodpandaappclone;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class ExampleDialog extends AppCompatDialogFragment {
    TextView textViewDate;
    TextView textViewTime;

    private String time;
    private String date_;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog_item_list, null);
        textViewDate = view.findViewById(R.id.text_date);
        textViewTime = view.findViewById(R.id.text_time);
        //dateListener
        textViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });
        textViewTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTime();
            }
        });


        builder.setView(view)
                .setTitle("Delivery Time")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ViewPagerActivity.updateTimeDate();

                    }
                });

        return builder.create();
    }

    public void selectDate() {
        Calendar mCurrentDate = Calendar.getInstance();
        final int date = mCurrentDate.get(Calendar.DATE);
        int month = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        int year = mCurrentDate.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog;
        datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                textViewDate.setText(dayOfMonth + "/" + month + 1 + "/" + year);
                ViewPagerActivity.date = dayOfMonth + "/" + month + 1 + "/" + year;

            }
        }, date, month, year);
        datePickerDialog.setTitle("Select Date");
        datePickerDialog.show();

    }

    public void selectTime() {
//
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                textViewTime.setText(selectedHour + ":" + selectedMinute);
                ViewPagerActivity.time = selectedHour + ":" + selectedMinute;
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();

    }


    public String getDate_() {
        return date_;
    }

    public String getTime() {
        return time;
    }
}
