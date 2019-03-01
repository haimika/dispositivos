package com.example.melhorcombustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    private double gas;
    private double ethan;

    private TextView priceGasTextView2;
    private TextView priceAlcoolTextView2;
    private TextView bestOptionTextView;
    private ImageView bestOptionImageView;
    private SeekBar gasSeekBar;
    private SeekBar alcoolSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        priceGasTextView2 = (TextView)
                findViewById(R.id.priceGasTextView2);
        priceAlcoolTextView2 = (TextView)
                findViewById(R.id.priceAlcoolTextView2);
        SeekBar gasSeekBar = (SeekBar)
                findViewById(R.id.gasSeekBar);
        SeekBar alcoolSeekBar = (SeekBar)
                findViewById(R.id.alcoolSeekBar);
        bestOptionTextView = (TextView)
                findViewById(R.id.bestOptionTextView);
        bestOptionImageView = (ImageView)
                findViewById(R.id.bestOptionImageView);
        gas = 5.0;
        ethan = 5.0;
        gasSeekBar.setOnSeekBarChangeListener(observer);
        alcoolSeekBar.setOnSeekBarChangeListener(observer);
    }

    private SeekBar.OnSeekBarChangeListener observer =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (seekBar.getId() == R.id.gasSeekBar){
                        gas = progress/100.0;
                        priceGasTextView2.setText(currencyFormat.format(gas));
                    }
                    else {
                        ethan = progress/100.0;
                        priceAlcoolTextView2.setText(currencyFormat.format(ethan));
                    }
                    calculate();
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };

    private void calculate (){
        double result = ethan / gas;
        priceGasTextView2.setText(currencyFormat.format(gas));
        priceAlcoolTextView2.setText(currencyFormat.format(ethan));
        if(result >= 0.7){
            bestOptionTextView.setText("Gas");
            bestOptionImageView.setImageResource(R.drawable.gasolina);
        }
        else{
            bestOptionTextView.setText("Ethanol");
            bestOptionImageView.setImageResource(R.drawable.alcool);
        }
    }
}
