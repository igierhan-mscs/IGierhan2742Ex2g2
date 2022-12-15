package com.example.igierhan2742ex2g2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<SensorReading> sensorReadings;
    private TextView sensorReadingIdTextView;
    private TextView dateTimeTextView;
    private TextView valueTextView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.sensorReadingIdTextView = (TextView) findViewById(R.id.sensorReadingIdTextView);
        this.dateTimeTextView = (TextView) findViewById(R.id.dateTimeTextView);
        this.valueTextView = (TextView) findViewById(R.id.valueTextView);

//        SensorReading sensorReading = new SensorReading(99999, 2, LocalDateTime.now(), 29.0f);
        loadSensorReadings();
        SensorReading sensorReading = this.sensorReadings.get(0);

        this.sensorReadingIdTextView.setText(Integer.toString(sensorReading.getSensorReadingId()));
        LocalDateTime dt = sensorReading.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.dateTimeTextView.setText(dt.format(formatter));
        this.valueTextView.setText(Float.toString(sensorReading.getValue()));
    }

    private void loadSensorReadings() {
        String json = "{\n" +
                "  \"readings\": [\n" +
                "    {\n" +
                "      \"sensorReadingId\": 60161,\n" +
                "      \"sensorId\": 2,\n" +
                "      \"dateTime\": \"2018-11-26T10:01:43.54235\",\n" +
                "      \"value\": 29,\n" +
                "      \"sensor\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"sensorReadingId\": 60162,\n" +
                "      \"sensorId\": 2,\n" +
                "      \"dateTime\": \"2018-11-26T10:03:04.7657807\",\n" +
                "      \"value\": 30,\n" +
                "      \"sensor\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"sensorReadingId\": 60163,\n" +
                "      \"sensorId\": 2,\n" +
                "      \"dateTime\": \"2018-11-26T10:05:06.5187565\",\n" +
                "      \"value\": 31,\n" +
                "      \"sensor\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"sensorReadingId\": 60164,\n" +
                "      \"sensorId\": 2,\n" +
                "      \"dateTime\": \"2018-11-26T10:05:47.3773175\",\n" +
                "      \"value\": 32,\n" +
                "      \"sensor\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"sensorReadingId\": 60165,\n" +
                "      \"sensorId\": 2,\n" +
                "      \"dateTime\": \"2018-11-26T10:06:48.2299219\",\n" +
                "      \"value\": 33,\n" +
                "      \"sensor\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"sensorReadingId\": 60166,\n" +
                "      \"sensorId\": 2,\n" +
                "      \"dateTime\": \"2018-11-26T10:07:28.8307888\",\n" +
                "      \"value\": 34,\n" +
                "      \"sensor\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"sensorReadingId\": 60167,\n" +
                "      \"sensorId\": 2,\n" +
                "      \"dateTime\": \"2018-11-26T10:08:09.4228174\",\n" +
                "      \"value\": 32,\n" +
                "      \"sensor\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"sensorReadingId\": 60168,\n" +
                "      \"sensorId\": 2,\n" +
                "      \"dateTime\": \"2018-11-26T10:08:29.7470375\",\n" +
                "      \"value\": 31,\n" +
                "      \"sensor\": null\n" +
                "    },\n" +
                "    {\n" +
                "      \"sensorReadingId\": 60169,\n" +
                "      \"sensorId\": 2,\n" +
                "      \"dateTime\": \"2018-11-26T10:08:50.0713275\",\n" +
                "      \"value\": 30,\n" +
                "      \"sensor\": null\n" +
                "    }]}";
        this.sensorReadings = SensorReadingJSONParser.getSensorReadings(json);
    }
}