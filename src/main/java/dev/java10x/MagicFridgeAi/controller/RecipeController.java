package dev.java10x.MagicFridgeAi.controller;

import dev.java10x.MagicFridgeAi.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAi.service.FoodItemService;
import dev.java10x.MagicFridgeAi.service.OpenAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RecipeController {

    private FoodItemService foodService;
    private OpenAiService openAiService;

    public RecipeController(FoodItemService foodService, OpenAiService openAiService) {
        this.foodService = foodService;
        this.openAiService = openAiService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generatRecipe(){
        List<FoodItemDTO> foodItens = foodService.listar();
        return openAiService.generateRecipe(foodItens)
                .map(recipe -> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
