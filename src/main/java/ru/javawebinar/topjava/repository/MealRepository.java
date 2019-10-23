package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealRepository {
    // null if not found, when updated
    Meal save(int id, Meal meal);

    // false if not found
    Boolean delete(int userId, int id);

    // null if not found
    Meal get(int userId, int id);

    Collection<Meal> getAll(int userId);
}
