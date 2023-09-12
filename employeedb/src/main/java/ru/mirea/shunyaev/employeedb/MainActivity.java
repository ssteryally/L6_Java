package ru.mirea.shunyaev.employeedb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();
        HeroDao heroDao = db.heroDao();
        SuperHero SuperHeroOne = new SuperHero();
        SuperHeroOne.id = 1;
        SuperHeroOne.name = "SuperMan";
        SuperHeroOne.ability = "Супермен обладает следующими сверхспособностями:\n" +
                " неуязвимость, сверхсила, сверхскорость, сверхвыносливость,\n" +
                " способность летать, суперзрение, суперслух.";

        SuperHero SuperHeroTwo = new SuperHero();
        SuperHeroTwo.id = 2;
        SuperHeroTwo.name = "Batman";
        SuperHeroTwo.ability = "Money";

        heroDao.insert(SuperHeroOne);
        heroDao.insert(SuperHeroTwo);
    }
}