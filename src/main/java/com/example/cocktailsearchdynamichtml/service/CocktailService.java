package com.example.cocktailsearchdynamichtml.service;

import com.example.cocktailsearchdynamichtml.model.Cocktail;
import com.example.cocktailsearchdynamichtml.repository.CocktailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocktailService {
    private CocktailRepository cr;

    public CocktailService(CocktailRepository cr) {
        this.cr = cr;
    }

    public List<Cocktail> searchCocktailsByIngredient(String name) {
        return cr.searchCocktailsByIngredient(name);
    }
    public List<Cocktail> getCocktailList() {
        return cr.getCocktailList();
    }


}
