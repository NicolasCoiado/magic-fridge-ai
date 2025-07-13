package dev.java10x.MagicFridgeAi.controller;

import dev.java10x.MagicFridgeAi.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAi.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {
    private FoodItemService service;

    public FoodItemController(FoodItemService service) {
        this.service = service;
    }

    //GET
    @GetMapping("/listar")
    public ResponseEntity<List<FoodItemDTO>> listar(){
        List<FoodItemDTO> foods = service.listar();
        return ResponseEntity.ok(foods);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> descrever(@PathVariable Long id){
        FoodItemDTO foodById = service.listarItemId(id);

        if (foodById != null){
            return ResponseEntity.ok(foodById);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum alimento com o ID "+id+" foi encontrado!");
        }
    }

    //POST
    @PostMapping("/cadastrar")
    public ResponseEntity<String> criar(@RequestBody FoodItemDTO fooditem){
        FoodItemDTO salvo = service.salvar(fooditem);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Item: "+salvo);
    }

    //PUT
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarItem(@PathVariable Long id, @RequestBody FoodItemDTO foodToUpdate){
        if(service.listarItemId(id) != null){
            FoodItemDTO updatedFood = service.atualizarItem(id, foodToUpdate);
            return ResponseEntity.ok(updatedFood);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum alimento com o ID "+id+" foi encontrado!");
        }
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(service.listarItemId(id) != null){
            service.deletarItem(id);
            return ResponseEntity.ok("Alimento com ID "+id+" deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum alimento com o ID "+id+" foi encontrado!");
        }
    }
}
