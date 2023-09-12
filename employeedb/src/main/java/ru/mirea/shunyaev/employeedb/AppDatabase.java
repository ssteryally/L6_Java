package ru.mirea.shunyaev.employeedb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SuperHero.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract HeroDao heroDao();
}
