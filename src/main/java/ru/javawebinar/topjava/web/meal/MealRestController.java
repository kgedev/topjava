package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;

import static ru.javawebinar.topjava.web.SecurityUtil.authUserId;

@Controller
public class MealRestController {
    private MealService service;

    @Autowired
    public MealRestController(MealService service) {
        this.service = service;
    }

    public MealTo save(Meal meal) {
        return new MealTo(service.save(authUserId(), meal));
    }

    public boolean delete(int mealId) {
        return service.delete(authUserId(), mealId);
    }

    public MealTo get(int mealId) {
        return new MealTo(service.get(authUserId(), mealId));
    }

}