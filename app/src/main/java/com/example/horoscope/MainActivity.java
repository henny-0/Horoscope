package com.example.horoscope;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner dropdown = findViewById(R.id.spinner);
        ImageView characterImageView = findViewById(R.id.characterImage);
        TextView horoscope = findViewById(R.id.textView2);

        String[] zodiacSigns = {
                "Please select a Zodiac Sign",
                "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
                "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"
        };

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, zodiacSigns);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String sign = zodiacSigns[i];
               String getHoroscope =  HoroscopeDataProvider.getHoroscopeForSign(sign);
               horoscope.setText(getHoroscope);

               int characterImageResourceId = HoroscopeDataProvider.getCharacterImageResource(sign);
               if (characterImageResourceId != -1) {
                   characterImageView.setImageResource(characterImageResourceId);
               } else {
                   characterImageView.setImageResource(R.drawable.bgwp);               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });



    }



}

class HoroscopeDataProvider {

    private static final String[] horoscopes = {
            "Today's horoscope for Aries (Naruto):\nBelieve it! Today's a day for bold decisions and ninja adventures.",
            "Today's horoscope for Taurus (Goku):\nGet ready to power up! You'll face challenges, but you'll overcome them like a Saiyan.",
            "Today's horoscope for Gemini (Luffy):\nAhoy there! Today is a day for making new friends and setting sail for exciting journeys.",
            "Today's horoscope for Cancer\n(Sailor Moon):\nIn the name of the moon, today's a day for love, friendship, and moonlit magic.",
            "Today's horoscope for Leo (Vegeta):\nToday, you'll surpass your limits and become the true prince of all Saiyans.",
            "Today's horoscope for Virgo (Kaneki):\nEmbrace your inner strength. Today might be tough, but you have the power to overcome.",
            "Today's horoscope for Libra (Yugi):\nIt's time to duel! Balance your life and tackle challenges with the heart of the cards.",
            "Today's horoscope for Scorpio (Sasuke):\nSeek revenge against negativity, and harness your true potential to achieve your goals.",
            "Today's horoscope for Sagittarius (Ash Ketchum):\nGotta catch 'em all! Today's a day for adventure and meeting new Pokémon.",
            "Today's horoscope for Capricorn (Levi Ackerman):\nToday, your dedication and hard work will lead you to achieve great heights.",
            "Today's horoscope for Aquarius (Gon Freecss):\nEmbrace your optimism and set off on new exciting adventures today.",
            "Today's horoscope for Pisces (Sakura): \nLet your compassion and inner strength guide you through the day. Blossom and heal."
    };

    public static String getHoroscopeForSign(String sign) {
        int index = -1;
        switch (sign) {
            case "Aries":
                index = 0;
                break;
            case "Taurus":
                index = 1;
                break;
            case "Gemini":
                index = 2;
                break;
            case "Cancer":
                index = 3;
                break;
            case "Leo":
                index = 4;
                break;
            case "Virgo":
                index = 5;
                break;
            case "Libra":
                index = 6;
                break;
            case "Scorpio":
                index = 7;
                break;
            case "Sagittarius":
                index = 8;
                break;
            case "Capricorn":
                index = 9;
                break;
            case "Aquarius":
                index = 10;
                break;
            case "Pisces":
                index = 11;
                break;
            case "Please select a Zodiac Sign":
                return "";
        }

        if (index != -1 && index < horoscopes.length) {
            return horoscopes[index];
        }

        return "Horoscope data not available for this sign.";
    }

    public static int getCharacterImageResource(String sign) {
        int resourceId = -1;
        switch (sign) {
            case "Aries":
                resourceId = R.drawable.naruto; // Replace with the actual image resource for Naruto
                break;
            case "Taurus":
                resourceId = R.drawable.goku; // Replace with the actual image resource for Goku
                break;
            case "Gemini":
                resourceId = R.drawable.luffy; // Replace with the actual image resource for Monkey D. Luffy
                break;
            case "Cancer":
                resourceId = R.drawable.sailor_moon; // Replace with the actual image resource for Sailor Moon
                break;
            case "Leo":
                resourceId = R.drawable.vegeta; // Replace with the actual image resource for Vegeta
                break;
            case "Virgo":
                resourceId = R.drawable.kaneki; // Replace with the actual image resource for Kaneki Ken
                break;
            case "Libra":
                resourceId = R.drawable.yugi_mutou; // Replace with the actual image resource for Yugi Mutou
                break;
            case "Scorpio":
                resourceId = R.drawable.sasuke; // Replace with the actual image resource for Sasuke Uchiha
                break;
            case "Sagittarius":
                resourceId = R.drawable.ash_ketchum; // Replace with the actual image resource for Ash Ketchum
                break;
            case "Capricorn":
                resourceId = R.drawable.levi; // Replace with the actual image resource for Levi Ackerman
                break;
            case "Aquarius":
                resourceId = R.drawable.gon_freecss; // Replace with the actual image resource for Gon Freecss
                break;
            case "Pisces":
                resourceId = R.drawable.sakura_haruno; // Replace with the actual image resource for Sakura Haruno
                break;
        }

        return resourceId;
    }
}