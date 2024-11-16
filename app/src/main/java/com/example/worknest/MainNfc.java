package com.example.worknest;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainNfc extends AppCompatActivity {

    private TarjetaNfcDeficahjes tarjetaNfcDeficahjes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos la clase TarjetaNfcDeficahjes
        tarjetaNfcDeficahjes = new TarjetaNfcDeficahjes(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tarjetaNfcDeficahjes.onResume();  // Activar NFC cuando la actividad se reanuda
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        tarjetaNfcDeficahjes.handleNfcIntent(intent);  // Manejar el intent NFC cuando se detecta una tarjeta
    }
}
