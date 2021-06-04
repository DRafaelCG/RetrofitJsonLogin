package com.dim.retrofitjsonlogin.ui;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dim.retrofitjsonlogin.R;
import com.dim.retrofitjsonlogin.model.LoginResponse;

public class MainActivity extends AppCompatActivity {
    LoginResponse loginResponse;
    EditText etNombre, etPass;
    Button bttnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = (EditText)findViewById(R.id.etUsuario);
        etPass = (EditText)findViewById(R.id.etPassword);
        bttnIngresar = (Button)findViewById(R.id.bttonLogin);

        bttnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validaVacio(etNombre) && validaVacio(etPass)){
                    IniciaSesion();
                }
            }
        });
    }

    private boolean validaVacio(EditText etCampo){
        if(etCampo.getText().toString().trim().length() > 0){
            return true;
        }
        etCampo.setError("Ingresa datos para poder accesar");
        etCampo.requestFocus();
        return false;
    }

    private void IniciaSesion(){
        final ProgressDialog pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Espere por favot");
        pDialog.show();

        API.getCliente().registrar(etNombre.getText().toString().trim(),
                etPass.getText().toString().trim(), "pass")
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        pDialog.dismiss();
                        loginResponse = response.body();
                        muestraToast(response.body().getMensaje());
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        muestraToast(t.getStackTrace().toString());
                        pDialog.dismiss();
                    }
                });


    }

    private void muestraToast(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }
}