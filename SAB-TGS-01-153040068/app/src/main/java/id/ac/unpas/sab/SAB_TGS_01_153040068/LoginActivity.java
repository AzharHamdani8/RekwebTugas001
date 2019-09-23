package id.ac.unpas.sab.SAB_TGS_01_153040068;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        buttonLogin = (Button) findViewById(R.id.button2);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                if(username.trim().equalsIgnoreCase("")){
                    editTextUsername.setError("Username Tidak Boleh Kosong!");
                    editTextUsername.requestFocus();
                } else if (password.trim().equalsIgnoreCase("")){
                    editTextPassword.setError("Password Tidak Boleh Kosong!");
                    editTextPassword.requestFocus();
                } else {
                    if(username.equalsIgnoreCase("dwinda") && password.equalsIgnoreCase("pratama")){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        LoginActivity.this.finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Username dan Password tidak sesuai", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });
    }
}