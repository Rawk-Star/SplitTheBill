package com.rawks.jeremy.splitthebill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BillSplitActivity extends AppCompatActivity
{
    // Objects for activity views
    TextView txtBillAmount, txtNumPeople;
    Spinner spnQuality;
    Button btnCalculate;
    TextView txtBillPerPerson, txtTipPerPerson, txtTotalPerPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_split);

        // Create object representations of all activity views
        txtBillAmount = findViewById(R.id.txtBillAmount);
        txtNumPeople = findViewById(R.id.txtNumPeople);
        spnQuality = findViewById(R.id.spnQuality);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtBillPerPerson = findViewById(R.id.txtBillPerPerson);
        txtTipPerPerson = findViewById(R.id.txtTipPerPerson);
        txtTotalPerPerson = findViewById(R.id.txtTotalPerPerson);

        // Populate the quality of service spinner with options
        String[] quality = {"Excellent", "Average", "Poor"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.quality_spinner, R.id.txtQualitySpinner, quality);
        spnQuality.setAdapter(adapter);

        btnCalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Tip percentages for each quality of service option
                final double[] tip = {0.15, 0.10, 0.05};

                double totalBill;
                int numberOfPeople;
                int qualityOfService;
                double splitBill;
                double splitTip;
                double splitTotal;

                // Retrieve the current user input values
                totalBill = Double.parseDouble(txtBillAmount.getText().toString());
                numberOfPeople = Integer.parseInt(txtNumPeople.getText().toString());
                qualityOfService = spnQuality.getSelectedItemPosition();

                // Calculate the split bill
                splitBill = totalBill / numberOfPeople;
                splitTip = (totalBill * tip[qualityOfService]) / numberOfPeople;
                splitTotal = splitBill + splitTip;

                // Output split bill to screen
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                txtBillPerPerson.setText(currency.format(splitBill));
                txtTipPerPerson.setText(currency.format(splitTip));
                txtTotalPerPerson.setText(currency.format(splitTotal));
            }
        });
    }
}