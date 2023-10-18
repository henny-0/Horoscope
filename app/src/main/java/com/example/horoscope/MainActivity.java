package com.example.horoscope;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        TextView zodiP = findViewById(R.id.textView);
        TextView today = findViewById(R.id.today);
        TextView horoscope = findViewById(R.id.textView2);
        TextView selectSun = findViewById(R.id.textView3);

        String[] zodiacSigns = {
                "Please select a Zodiac Sign",
                "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
                "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"
        };

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, zodiacSigns);

        dropdown.setAdapter(adapter);

        Button updateButton = findViewById(R.id.updateButton);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedItemPosition = dropdown.getSelectedItemPosition();
                String sign = zodiacSigns[selectedItemPosition];
                String getHoroscope = HoroscopeDataProvider.getHoroscopeForSign(sign);
                horoscope.setText(getHoroscope);

                int characterImageResourceId = HoroscopeDataProvider.getCharacterImageResource(sign);
                if (characterImageResourceId != -1) {
                    characterImageView.setImageResource(characterImageResourceId);
                    today.setVisibility(View.VISIBLE);
                    horoscope.setVisibility(View.VISIBLE);
                    zodiP.setVisibility(View.VISIBLE);
                } else {
                    characterImageView.setImageResource(R.drawable.bgwp);
                    today.setVisibility(View.INVISIBLE);
                    horoscope.setVisibility(View.INVISIBLE);
                    zodiP.setVisibility(View.INVISIBLE);
                }

                zodiP.setText(HoroscopeDataProvider.getZodiacName(sign) + " " + HoroscopeDataProvider.getZodiacPeriod(sign));
            }
        });

/*
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String sign = zodiacSigns[i];
               String getHoroscope =  HoroscopeDataProvider.getHoroscopeForSign(sign);
               horoscope.setText(getHoroscope);

               int characterImageResourceId = HoroscopeDataProvider.getCharacterImageResource(sign);
               if (characterImageResourceId != -1) {
                   characterImageView.setImageResource(characterImageResourceId);
                   today.setVisibility(View.VISIBLE);
                   selectSun.setVisibility(View.INVISIBLE);

               } else {
                   characterImageView.setImageResource(R.drawable.bgwp);
                   today.setVisibility(View.INVISIBLE);
                   selectSun.setVisibility(View.VISIBLE);
               }

               zodiP.setText(HoroscopeDataProvider.getZodiacName(sign)+" "+HoroscopeDataProvider.getZodiacPeriod(sign));
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
*/
    }
}

class HoroscopeDataProvider {

    private static final String[][] zodiacData = {
            {"Aries", "Mar 21 - Apr 20"},
            {"Taurus", "Apr 21 - May 20"},
            {"Gemini", "May 21 - Jun 20"},
            {"Cancer", "Jun 21 - Jul 22"},
            {"Leo", "Jul 23 - Aug 22"},
            {"Virgo", "Aug 23 - Sep 22"},
            {"Libra", "Sep 23 - Oct 22"},
            {"Scorpio", "Oct 23 - Nov 21"},
            {"Sagittarius", "Nov 22 - Dec 21"},
            {"Capricorn", "Dec 22 - Jan 19"},
            {"Aquarius", "Jan 20 - Feb 18"},
            {"Pisces", "Feb 19 - Mar 20"}
    };

    private static final String[] horoscopes = {
            "Today's horoscope for Aries\n(Eren Yeager):\n\n\"If you don't fight, you can't win!\" \n\nToday is a day to be brave and take action.",
            "Today's horoscope for Taurus\n(Kyo Sohma):\n\n\"I'm not running away. I'm just living my life.\"\n\nToday is a day to be true to yourself and stand your ground.",
            "Today's horoscope for Gemini\n(Kagami Taiga):\n\n\"I'll show you something even better than miracles!\"\n\nToday is a day to push yourself to new heights.",
            "Today's horoscope for Cancer\n(Usagi Tsukino):\n\n\"In the name of the moon, I will punish you!\"\n\nToday is a day to protect those you love and fight for what's right.",
            "Today's horoscope for Leo\n(Natsu Dragneel):\n\n\"I'm all fired up!\"\n\nToday is a day to be confident and passionate.",
            "Today's horoscope for Virgo\n(Shino Aburame):\n\n\"The only way to truly escape the mundane is for you to constantly be evolving.\"\n\nToday is a day to focus on self-improvement.",
            "Today's horoscope for Libra\n(Yukino Aguria):\n\n\"I believe that the world is full of beautiful things like friendship, magic, and dreams.\"\n\nToday is a day to appreciate the beauty in life.",
            "Today's horoscope for Scorpio\n(Itachi Uchiha):\n\n\"People live their lives bound by what they accept as correct and true. That's how they define 'reality'. But what does it mean to be 'correct' or 'true'? Merely vague concepts... their 'reality' may all be a mirage.\"\n\nToday is a day to question your assumptions and seek the truth.",
            "Today's horoscope for Sagittarius\n(Monkey D. Luffy):\n\n\"I don't want to conquer anything. I just think that the guy with the most freedom in this ocean is the Pirate King!\"\n\nToday is a day to embrace your sense of adventure and explore new possibilities.",
            "Today's horoscope for Capricorn\n(Levi Ackerman):\n\n\"The only thing we're allowed to do is believe. We can't change anything.\"\n\nToday is a day to stay focused on your goals and work hard towards achieving them.",
            "Today's horoscope for Aquarius\n(Haruka Nanase):\n\n\"I swim because I want to swim.\"\n\nToday is a day to follow your passions and do what makes you happy.",
            "Today's horoscope for Pisces\n(Nana Osaki):\n\n\"I'm not interested in ordinary people. But if any of you are aliens, time-travelers, or espers, please come see me. That is all!\"\n\nToday is a day to embrace your unique qualities and let your creativity shine."
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
               resourceId = R.drawable.erenyeager;
                break;
            case "Taurus":
               resourceId = R.drawable.kyosohma;
                break;
            case "Gemini":
                resourceId = R.drawable.kagamitaiga;
                break;
            case "Cancer":
                resourceId = R.drawable.sailor_moon;
                break;
            case "Leo":
                resourceId = R.drawable.natsudragneel;
                break;
            case "Virgo":
                resourceId = R.drawable.shinoaburame;
                break;
            case "Libra":
                resourceId = R.drawable.yukinoaguria;
                break;
            case "Scorpio":
                resourceId = R.drawable.itachiuchiha;
                break;
            case "Sagittarius":
                resourceId = R.drawable.luffy;
                break;
            case "Capricorn":
                resourceId = R.drawable.levi;
                break;
            case "Aquarius":
               resourceId = R.drawable.harukananase;
                break;
            case "Pisces":
               resourceId = R.drawable.nanaosaki;
                break;
        }

        return resourceId;
    }

    public static String getZodiacName(String sign) {
        for (String[] zodiac : zodiacData) {
            if (zodiac[0].equalsIgnoreCase(sign)) {
                return zodiac[0];
            }
        }
        return "";
    }
    public static String getZodiacPeriod(String sign) {
        for (String[] zodiac : zodiacData) {
            if (zodiac[0].equalsIgnoreCase(sign)) {
                return zodiac[1];
            }
        }
        return "";
    }

}