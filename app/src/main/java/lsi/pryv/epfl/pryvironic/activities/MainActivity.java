package lsi.pryv.epfl.pryvironic.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import lsi.pryv.epfl.pryvironic.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Log out")
                .setMessage("You are about to log out. Continue?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoginActivity.resetCreditentials();
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void discoverBTLE(View view) {
        startActivity(new Intent(MainActivity.this, BluetoothLEActivity.class));
    }

    public void discoverBT(View view) {
        startActivity(new Intent(MainActivity.this, BluetoothActivity.class));
    }
}