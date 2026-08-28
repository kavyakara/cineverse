package com.example.cineverse;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;

public class SeatSelectionActivity extends AppCompatActivity {

    LinearLayout seatContainer;
    TextView txtSelectedSeats, txtTotalPrice;
    Button btnContinue;

    int selectedCount = 0;
    final int seatPrice = 200;
    ArrayList<String> selectedSeats = new ArrayList<>();

    Set<String> bookedSeats = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        seatContainer = findViewById(R.id.seatContainer);
        txtSelectedSeats = findViewById(R.id.txtSelectedSeats);
        txtTotalPrice = findViewById(R.id.txtTotalPrice);
        btnContinue = findViewById(R.id.btnContinue);

        generateBookedSeats();

        createSeats();

        btnContinue.setOnClickListener(v -> {

            if (selectedCount == 0) {
                Toast.makeText(this,
                        "Please select at least one seat",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String movieName = getIntent().getStringExtra("movieName");
            int movieImage = getIntent().getIntExtra("movieImage", 0);

            Intent intent = new Intent(SeatSelectionActivity.this,
                    FoodActivity.class);

            intent.putExtra("movieName", movieName);
            intent.putExtra("movieImage", movieImage);

            intent.putExtra("selectedSeats",
                    String.join(", ", selectedSeats));

            intent.putExtra("seatCount", selectedCount);
            intent.putExtra("selectedSeats",
                    String.join(", ", selectedSeats));
            intent.putExtra("totalPrice", selectedCount * seatPrice);

            startActivity(intent);
        });
    }

    private void generateBookedSeats() {

        Random random = new Random();

        while (bookedSeats.size() < 30) {

            char row = (char) ('A' + random.nextInt(20));
            int seat = random.nextInt(10) + 1;

            bookedSeats.add(row + String.valueOf(seat));
        }
    }

    private void createSeats() {

        for (int i = 0; i < 20; i++) {

            LinearLayout rowLayout = new LinearLayout(this);
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView rowName = new TextView(this);
            rowName.setText(String.valueOf((char) ('A' + i)));
            rowName.setTextColor(getColor(android.R.color.white));
            rowName.setWidth(70);

            rowLayout.addView(rowName);

            for (int j = 1; j <= 10; j++) {

                if (j == 6) {

                    TextView gap = new TextView(this);
                    gap.setWidth(40);
                    rowLayout.addView(gap);
                }

                Button seat = new Button(this);

                String seatNo = (char) ('A' + i) + String.valueOf(j);

                seat.setText("");

                LinearLayout.LayoutParams params =
                        new LinearLayout.LayoutParams(65,65);

                params.setMargins(6,6,6,6);

                seat.setLayoutParams(params);

                if (bookedSeats.contains(seatNo)) {

                    seat.setBackgroundResource(R.drawable.seat_booked);
                    seat.setEnabled(false);

                } else {

                    seat.setBackgroundResource(R.drawable.seat_available);

                    seat.setOnClickListener(v -> {

                        if (seat.isSelected()) {

                            seat.setSelected(false);
                            seat.setBackgroundResource(R.drawable.seat_available);
                            selectedCount--;

                            selectedSeats.remove(seatNo);

                        } else {

                            if (selectedCount == 10) {

                                Toast.makeText(this,
                                        "Maximum 10 seats",
                                        Toast.LENGTH_SHORT).show();

                                return;
                            }

                            seat.setSelected(true);
                            seat.setBackgroundResource(R.drawable.seat_selected);
                            selectedCount++;

                            selectedSeats.add(seatNo);
                        }

                        txtSelectedSeats.setText(
                                "Seats : " + String.join(", ", selectedSeats));

                        txtTotalPrice.setText(
                                "Total : ₹" + (selectedCount * seatPrice));

                    });

                }

                rowLayout.addView(seat);
            }

            seatContainer.addView(rowLayout);
        }
    }
}