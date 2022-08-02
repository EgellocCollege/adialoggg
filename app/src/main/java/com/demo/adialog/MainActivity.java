package com.demo.adialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edit = findViewById(R.id.serach);
        Button btn = findViewById(R.id.btn);
        edit.requestFocus();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//
//                inputMethodManager.hideSoftInputFromWindow(edit.getWindowToken(), 0);
                showDialog();
//                view.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        showDialog();
//                    }
//                }, 10);
           }
        });

    }

    protected void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        View dialogView = View.inflate(this, R.layout.srh, null);
        //设置对话框布局
        dialog.setView(dialogView);
        EditText etName = (EditText) dialogView.findViewById(R.id.name);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.IM, WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
//        dialog.getWindow().setWindowAnimations(R.style.Adialog);
        etName.requestFocus();
        dialog.show();
    }

}