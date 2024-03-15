package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout menuLayout;
    private TextView billTextView;
    private double totalBill = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuLayout = findViewById(R.id.menuLayout);
        billTextView = findViewById(R.id.billTextView);

        // Add menu items dynamically (you can add more items)
        addItemToMenu("Chapathi", 20.0);
        addItemToMenu("Idli", 30.0);
        addItemToMenu("Dosa", 20.0);
        addItemToMenu("Puri", 30.0);
        addItemToMenu("Palavu", 40.0);

        Button selectItemsButton = findViewById(R.id.selectItemsButton);
        selectItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectedItems();
            }
        });


    }

    private void addItemToMenu(String itemName, double itemPrice) {
        CheckBox menuItem = new CheckBox(this);
        menuItem.setText(itemName + " - $" + itemPrice);
        menuLayout.addView(menuItem);
    }

    private void showSelectedItems() {
        StringBuilder selectedItems = new StringBuilder();
        totalBill = 0.0;

        for (int i = 0; i < menuLayout.getChildCount(); i++) {
            View view = menuLayout.getChildAt(i);

            if (view instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) view;

                if (checkBox.isChecked()) {
                    String itemText = checkBox.getText().toString();
                    selectedItems.append(itemText).append("\n");

                    // Parse the item price from the text and add it to the total bill
                    String[] parts = itemText.split(" - ");
                    if (parts.length == 2) {
                        double itemPrice = Double.parseDouble(parts[1].substring(1));
                        totalBill += itemPrice;
                    }
                }
            }
        }

        billTextView.setText("Selected Items:\n" + selectedItems.toString() +
                "\nTotal Bill: $" + totalBill +"\n\n\n----Thank you---\n");
    }

    private void calculateBill() {
        showSelectedItems(); // Update the bill in case user hasn't clicked "Select Items"
    }
}
