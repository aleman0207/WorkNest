package com.example.worknest;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.widget.Toast;

public class TarjetaNfcDeficahjes {

    private Activity activity;
    private NfcAdapter nfcAdapter;


  public TarjetaNfcDeficahjes(Activity activity) {
       this.activity = activity;
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(activity);

        // Verificar si el dispositivo soporta NFC
        if (nfcAdapter == null) {
            Toast.makeText(activity, "Este dispositivo no soporta NFC", Toast.LENGTH_SHORT).show();
            activity.finish();  // Cerrar la actividad si no hay soporte para NFC
        }
    }

    // activacion del NFC cuando la actividad se reanuda
    public void onResume() {
        if (nfcAdapter != null && !nfcAdapter.isEnabled()) {
            Toast.makeText(activity, "Por favor, habilita NFC en los ajustes", Toast.LENGTH_LONG).show();
        }
    }

    //manejo el intent NFC y procesar la tarjeta
    public void handleNfcIntent(Intent intent) {
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            if (tag != null) {
                String tagId = bytesToHex(tag.getId());
                Toast.makeText(activity, "Tarjeta NFC detectada: " + tagId, Toast.LENGTH_SHORT).show();
                // Aquí puedes implementar lógica para guardar la hora de fichaje
            }
        }
    }

    //  convertir los bytes del tag a un String legible (ID de la tarjeta)
    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
