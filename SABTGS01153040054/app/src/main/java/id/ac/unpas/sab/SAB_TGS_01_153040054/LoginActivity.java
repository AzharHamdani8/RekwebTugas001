package id.ac.unpas.sab.SAB_TGS_01_153040054;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Instant;

public class LoginActivity extends AppCompatActivity {
    EditText editUsername, editPassord; //Deklarasi object dari class EdiText
    Button btnLogin; //Deklarasi object string


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editUsername = (EditText) findViewById(R.id.username);
        editPassord = (EditText) findViewById(R.id.password);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassord.getText().toString();
                if (!username.isEmpty() || !password.isEmpty()) {
                    if (username.equalsIgnoreCase("Praktikum") && password.equalsIgnoreCase("sb601")) {
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(LoginActivity.this,
                                "Username dan passord salah ! harap masukan inputan yang benar", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Inputan tidak boleh kosang", Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}