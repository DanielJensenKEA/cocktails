package com.example.cocktailsearchdynamichtml.repository;

import com.example.cocktailsearchdynamichtml.model.Cocktail;
import com.example.cocktailsearchdynamichtml.service.CocktailService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class CocktailRepository {
    List<Cocktail> cocktailList;

    public CocktailRepository() {
        cocktailList = new ArrayList<>();
        populateCocktails();
    }
    public List<Cocktail> getCocktailList() {
        return cocktailList;
    }

    public void populateCocktails() {
        Collections.addAll(cocktailList,
                new Cocktail("Old Fashioned", Arrays.asList("Syrup", "Water", "Bitters", "Ice", "Bourbon", "Garnishes")),
                new Cocktail("Negroni", Arrays.asList("3/4 fluid ounce campari", "3/4 fluid ounce gin",
                        "3/4 fluid ounce sweet vermouth", "2 fluid ounces carbonated water", "1 wedge lemon, for garnish")),
                new Cocktail("Daiquiri", Arrays.asList("1 cup ice cubes", "1 1/2 fluid ounces light rum",
                        "1 fluid ounce lime juice", "1 fluid ounce triple sec", "1 teaspoon white sugar", "1 lime wedge", "2 tablespoons white sugar")),
                new Cocktail("Testcocktail", Arrays.asList("Water", "Syrup")));

    }
    public List<Cocktail> searchCocktailsByIngredient(String name) {
        List<Cocktail> searchResultsIngredient = new ArrayList<>();
        for (Cocktail c : cocktailList) {
            for (String ingredient : c.getIngredients()) {
                /*
                if (name.equalsIgnoreCase(ingredient)) {
                    searchResultsIngredient.add(c);
                    break; // Stopper søgning efter vi har fundet den søgte ingrediens. Bevæger os videre til næste cocktail.
                }

                 */
                if (name.toLowerCase().contains(ingredient.toLowerCase())) {
                    searchResultsIngredient.add(c);
                    break; // Stopper søgning efter vi har fundet den søgte ingrediens. Bevæger os videre til næste cocktail.
                }

            }

        }
        return searchResultsIngredient;
    }


}
