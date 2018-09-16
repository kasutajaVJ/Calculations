package com.example.vanessa.calculations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private static final double VAT = 0.2;
    EditText price, amount, calcExclVat, calcVat, calcInclVat;
    RadioButton inclVat, exclVat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        price.findViewById(R.id.price);
        amount.findViewById(R.id.amount);

        inclVat.findViewById(R.id.incl_vat);
        exclVat.findViewById(R.id.excl_vat);
        calcExclVat.findViewById(R.id.cal_excl_vat);
        calcVat.findViewById(R.id.vat);
        calcInclVat.findViewById(R.id.cal_incl_vat);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_clear) {
            clearFields();
        } else if (view.getId() == R.id.btn_ok) {
            int parsePrice = Integer.parseInt(price.getText().toString());
            int parseAmount = Integer.parseInt(amount.getText().toString());

            if (inclVat.isChecked()) {
                calcExclVat.setText("");
                calcVat.setText(calcVat(parsePrice, parseAmount));
                calcInclVat.setText(calcCostWithVat(parsePrice, parseAmount));
            }
            else if (exclVat.isChecked()) {
                calcExclVat.setText(calcCost(parsePrice, parseAmount));
                calcVat.setText("");
                calcInclVat.setText("");
            }
        }
    }

    private void clearFields() {
        price.setText("");
        amount.setText("");
        calcExclVat.setText("");
        calcVat.setText("");
        calcInclVat.setText("");
    }

    private String calcCost(int price, int amount) {
        return String.valueOf(price * amount);
    }

    private String calcVat(int price, int amount) {
        return String.valueOf(price * amount * VAT);
    }

    private String calcCostWithVat(int price, int amount) {
        return String.valueOf(price * amount * (1 + VAT));
    }
}
