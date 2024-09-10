package com.example.cocktailsearchdynamichtml.model;

import java.util.List;

public class Cocktail {

    private String name;
    private List<String> ingredients;

    public Cocktail(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
