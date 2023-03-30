package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView alcool;
    private TextView gasolina;
    private TextView result;
    private Button calcular;
    private String texto;
    private String precoAlcoolStr;
    private String precoGasolinaStr;
    private Double precoAlcool;
    private Double precoGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.txtresult);
        gasolina = findViewById(R.id.txtGasolina);
        alcool = findViewById(R.id.txtAlcool);
        calcular = findViewById(R.id.btnCalcular);
        texto = result.getText().toString();
    }

    public void calcular(View view) {
        precoAlcoolStr = alcool.getText().toString();
        precoGasolinaStr = gasolina.getText().toString();
        if (precoAlcoolStr.isEmpty() || precoGasolinaStr.isEmpty()) {
            result.setText("Preencha todos os campos!");
        } else {
            precoAlcool = Double.parseDouble(precoAlcoolStr);
            precoGasolina = Double.parseDouble(precoGasolinaStr);
            if (precoAlcool / precoGasolina <=0.7){
                result.setText(texto+" Álcool!");
            }else {
                result.setText(texto+" Gasolina!");
            }
        }
        InputMethodManager fecharTeclado = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        fecharTeclado.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
    public void fecharTeclado(View view){
        InputMethodManager fecharTeclado = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        fecharTeclado.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
    public void limpar(View view){
        gasolina.setText("");
        alcool.setText("");
        result.setText(texto);
    }

}