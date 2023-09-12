package ru.mirea.shunyaev.securesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;

import java.io.IOException;
import java.security.GeneralSecurityException;

import ru.mirea.shunyaev.securesharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences secureSharedPreferences;
        KeyGenParameterSpec keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC;
        try {
            String mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec);
            secureSharedPreferences = EncryptedSharedPreferences.create(
                    "secret_shared_prefs",
                    mainKeyAlias,
                    getBaseContext(),
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
            secureSharedPreferences.edit().putString("secure", "Серге́й Алекса́ндрович Есе́нин");
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }

        binding.textView2.setText(secureSharedPreferences.getString("secure", "Серге́й Алекса́ндрович Есе́нин"));
        binding.textView.setText(secureSharedPreferences.getString("secure", "Фото Есенина"));
        binding.imageView.setImageResource(R.drawable.actor);
    }
}
