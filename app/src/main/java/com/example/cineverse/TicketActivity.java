package com.example.cineverse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.MultiFormatWriter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TicketActivity extends AppCompatActivity {

    TextView txtMovie, txtSeats, txtAmount, txtBookingId;
    ImageView imgQr;
    ImageView imgMoviePoster;
    Button btnDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        txtMovie = findViewById(R.id.txtMovie);
        txtSeats = findViewById(R.id.txtSeats);
        txtAmount = findViewById(R.id.txtAmount);
        txtBookingId = findViewById(R.id.txtBookingId);
        imgQr = findViewById(R.id.imgQr);
        btnDone = findViewById(R.id.btnDone);
        imgMoviePoster = findViewById(R.id.imgMoviePoster);

        String selectedSeats = getIntent().getStringExtra("selectedSeats");
        int amount = getIntent().getIntExtra("totalPrice", 0);

        String movieName = getIntent().getStringExtra("movieName");
        int movieImage = getIntent().getIntExtra("movieImage", 0);

        txtMovie.setText("Movie : " + movieName);
        if (movieImage != 0) {
            imgMoviePoster.setImageResource(movieImage);
        }
        txtMovie.setText("Movie : " + movieName);
        txtSeats.setText("Seats : " + selectedSeats);
        txtAmount.setText("Paid : ₹" + amount);

        String bookingId = "CV" + (100000 + new Random().nextInt(900000));
        txtBookingId.setText("Booking ID : " + bookingId);

        String qrData =
                "Movie: " + movieName +
                        "\nSeats: " + selectedSeats +
                        "\nAmount: ₹" + amount +
                        "\nBooking ID: " + bookingId;

        try {
            imgQr.setImageBitmap(generateQRCode(qrData));
        } catch (WriterException e) {
            e.printStackTrace();
        }

        btnDone.setOnClickListener(v -> {

            Intent intent = new Intent(TicketActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        });

    }

    private Bitmap generateQRCode(String text) throws WriterException {

        int width = 500;
        int height = 500;

        BitMatrix bitMatrix = new MultiFormatWriter().encode(
                text,
                BarcodeFormat.QR_CODE,
                width,
                height
        );

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bitmap.setPixel(
                        x,
                        y,
                        bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF
                );
            }
        }

        return bitmap;
    }
}