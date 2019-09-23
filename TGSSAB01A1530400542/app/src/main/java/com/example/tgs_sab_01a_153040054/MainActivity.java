package com.example.tgs_sab_01a_153040054;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nrp, nama;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nrp = (EditText) findViewById(R.id.nrp);
        nama = (EditText) findViewById(R.id.nama);
        submit = (Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View v){
                Toast.makeText(MainActivity.this, "Hello SAB, perkenalkan saya "+nama.getText()+"dengan nrp"+nrp.getText(), Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "Saya adalah mahasiswa unpas informatika unpas", Toast.LENGTH_LONG).show();
            }
        });
    }
}
