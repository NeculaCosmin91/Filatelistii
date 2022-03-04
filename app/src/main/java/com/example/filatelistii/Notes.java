package com.example.filatelistii;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.filatelistii.Necesar.ConverterData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

public class Notes extends AppCompatActivity {
    public static final String NOTES = "NOTES";
    public static final String UPDATED_AT = "UPDATED_AT";
    public static final String NO_CHARACTERS = "NO_CHARACTERS";
    public static final String NOTES_SHARED_PREF = "notesSharedPref";
    private TextView tvUpdatedAt;
    private TextView tvNoCharacters;
    private TextInputEditText tietNotes;
    private FloatingActionButton fabSave;

    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        initComponents();
        loadNotesSharedPreference();
    }

    private void initComponents() {
        tvUpdatedAt = findViewById(R.id.mainTvUpdated);
        tvNoCharacters = findViewById(R.id.mainTvNoChars);
        tietNotes = findViewById(R.id.main_tiet_notes);
        fabSave = findViewById(R.id.saveNote);
        fabSave.setOnClickListener(getSaveClickEvent());


        preferences = getSharedPreferences(NOTES_SHARED_PREF, MODE_PRIVATE);
    }

    private View.OnClickListener getSaveClickEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Toast.makeText(getApplicationContext(), R.string.save_message, Toast.LENGTH_SHORT).show();
                    saveNotesSharedPreference();
                }
            }
        };
    }

    private void saveNotesSharedPreference() {

        String notes = tietNotes.getText() != null ? tietNotes.getText().toString() : "";
        String updatedAt = ConverterData.fromDate(new Date());
        int noCharacters = notes.length();


        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(NOTES, notes);
        editor.putString(UPDATED_AT, updatedAt);
        editor.putInt(NO_CHARACTERS, noCharacters);
        editor.apply();


        setTextViewUpdatedAt(updatedAt);
        setTextViewNoCharacters(noCharacters);
    }

    private void loadNotesSharedPreference() {

        String notes = preferences.getString(NOTES, "");
        String updatedAt = preferences.getString(UPDATED_AT, "NONE");
        int noCharacters = preferences.getInt(NO_CHARACTERS, 0);

        tietNotes.setText(notes);
        setTextViewUpdatedAt(updatedAt);
        setTextViewNoCharacters(noCharacters);
    }

    private boolean isValid() {
        if (tietNotes.getText() == null || tietNotes.getText().toString().length() > 1000) {
            Toast.makeText(getApplicationContext(), R.string.notes_no_characters_error_message, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void setTextViewUpdatedAt(String updatedAt) {
        tvUpdatedAt.setText(getString(R.string.notes_updated, updatedAt));
    }

    private void setTextViewNoCharacters(int noCharacters) {
        tvNoCharacters.setText(getString(R.string.notes_template, noCharacters));
    }
}