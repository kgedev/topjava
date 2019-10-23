package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.util.ValidationUtil.*;

@Service
public class MealService {
    private MealRepository repository;

    @Autowired
    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal save(int userId, Meal meal) {
        checkNotFoundWithId(repository.save(userId, meal), userId);
        return repository.save(userId, meal);
    }

    public boolean delete(int userId, int mealId) {
        return checkNotFoundWithId(repository.delete(userId, mealId), userId);
    }

    public Meal get(int userId, int mealId) {
        return checkNotFoundWithId(repository.get(userId, mealId), userId);
    }

    public List<Meal> getBetween(int userId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return checkNotFoundWithId(repository.getAll(userId).stream()
                .filter(meal -> meal.getDateTime().isAfter(startDateTime) & meal.getDateTime().isBefore(endDateTime))
                .collect(Collectors.toList()), userId);
    }

    public List<Meal> getAll(int userId) {
        return checkNotFoundWithId(new ArrayList<>(repository.getAll(userId)), userId);
    }


}