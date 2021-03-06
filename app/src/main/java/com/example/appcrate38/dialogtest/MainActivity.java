package com.example.appcrate38.dialogtest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String[] itemArr={"Ryujehong","Whoru","Miro","Zunba","EscA","Gido","Tobi"};
    Button butDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butDialog=(Button)findViewById(R.id.but_dialog);
        butDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("첫번째 다이얼로그");
        dialog.setIcon(R.drawable.lunaticlogo);
       // dialog.setMessage("여기는 메세지를 쓰는 곳입니다.");
        //단순목록
        /*dialog.setItems(itemArr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                butDialog.setText(itemArr[i]);
            }
        });*/
            //라디오 버튼 목록
        dialog.setSingleChoiceItems(itemArr,0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                butDialog.setText(itemArr[i]);
            }
        });
        //체크박스 목록
        boolean[] checkedItems={true,false,true,false,true,true,true};
        dialog.setMultiChoiceItems(itemArr, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b) {
                    butDialog.setText(itemArr[i]);
                }
            }
        });
       // dialog.setPositiveButton("OK",null);
        dialog.show();
    }
}
