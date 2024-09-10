package com.example.cocktailsearchdynamichtml.controller;


import com.example.cocktailsearchdynamichtml.model.Cocktail;
import com.example.cocktailsearchdynamichtml.service.CocktailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/cocktails")
public class CocktailController {

    private final CocktailService cs;

    public CocktailController(CocktailService cs) {
        this.cs = cs;
    }
    @GetMapping("")
    public List<Cocktail> getCocktailList() {
        return cs.getCocktailList();
    }
    @GetMapping("/")
    public String listCocktails(Model model) {
        List<Cocktail> allCocktails = cs.getCocktailList();
        model.addAttribute("allCocktails", allCocktails);
        System.out.println("Number of elements in the cocktail list: "+allCocktails.size());

        return "cocktail-list";
    }
// localhost:8080/cocktails/search
    @GetMapping("/search")
    public String searchCocktailsByIngredient(@RequestParam("ingredient")String ingredient, Model model) {
        List<Cocktail> ingredients = cs.searchCocktailsByIngredient(ingredient);
        model.addAttribute("cocktails", ingredients);
        model.addAttribute("ingredient", ingredient);

        return "cocktailsearchresults";
    }

    @GetMapping("/searchForm")
    public String showSearchForm() {
        return "search";
    }




}
