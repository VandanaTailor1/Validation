package com.example.calender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RadioGroup radioGroup;
    TextView t1,t2;
    Switch swt;
    RadioButton radioButton;
    CalendarView calendarView;
    String msg="";
    Spinner spinner;
    TextView textView;
   Button submit,clear;
   CheckBox c1,c2,c3,c4;
   Button button;
    String[] course={"java","c","c++","kotlin","Android"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button =findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(MainActivity.this,ValidationActivity.class);
                startActivity(intend);
            }
        });

        calendarView =findViewById(R.id.calender);
        textView=findViewById(R.id.text);
          radioGroup =findViewById(R.id.radio);
        radioGroup.clearCheck();

         submit =findViewById(R.id.select);
         clear=findViewById(R.id.clear);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton= group.findViewById(checkedId);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selected=radioGroup.getCheckedRadioButtonId();
                if(selected==-1){
                     Toast.makeText(MainActivity.this,"",Toast.LENGTH_SHORT).show();
                }else {
                    radioButton = radioGroup.findViewById(selected);
                    Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.clearCheck();
            }
        });

//     btn=findViewById(R.id.btn);
        c1=findViewById(R.id.first);
        c2=findViewById(R.id.second);
        c3=findViewById(R.id.third);
        c4=findViewById(R.id.fourth);

        spinner =findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, course);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayofmonth) {
                Log.d("year" ,"year" + year);
                Log.d("month" ,"month" + month);
                Log.d("day" ,"dayofmonth" + dayofmonth);
                String date =dayofmonth +"/"+ (month+1)+ "/" +year;
                  textView.setText(date);
            }
        });
       // check();

        swt=findViewById(R.id.swt);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);


//    if(swt.isChecked()){
//        t2.setText("Check");
//    }else{
//        t2.setText("uncheck");
//    }

    swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
             if(isChecked){
                 t2.setText("it's check");
             }else{
                 t2.setText("It's not check");
             }
        }
    });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),course[position],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    public  void check(){
//
//
//       btn.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               if(c1.isChecked())
//                   msg=msg+ "Yoga";
//               if(c2.isChecked())
//                   msg=msg+ "Music";
//
//               if(c3.isChecked())
//                   msg=msg+ "Drawing";
//
//               if(c4.isChecked())
//                   msg=msg+ "Painting";
//
//               Toast.makeText(MainActivity.this, msg + "are selected",
//                       Toast.LENGTH_LONG).show();
//               msg="";
//
//           }
//       });
//    }
}