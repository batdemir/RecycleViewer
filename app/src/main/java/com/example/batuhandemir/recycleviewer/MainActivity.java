package com.example.batuhandemir.recycleviewer;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.batuhandemir.recycleviewer.AlertDialogUpdateFrame.DialogFragmentUpdateFrame;

public class MainActivity extends AppCompatActivity {

    private Button deneme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deneme = findViewById(R.id.deneme);
        click();
    }

    private void click(){
        deneme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragmentUpdateFrame dialogFragmentUpdateFrame = new DialogFragmentUpdateFrame();
                FragmentManager fragmentManager = getSupportFragmentManager();

                dialogFragmentUpdateFrame.show(fragmentManager,"deneme");
            }
        });
    }
}
