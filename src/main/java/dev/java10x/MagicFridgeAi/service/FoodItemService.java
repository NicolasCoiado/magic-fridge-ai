package dev.java10x.MagicFridgeAi.service;

import dev.java10x.MagicFridgeAi.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAi.mapper.FoodItemMapper;
import dev.java10x.MagicFridgeAi.model.FoodItem;
import dev.java10x.MagicFridgeAi.repository.FoodItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodItemService {
    private FoodItemRepository repository;
    private FoodItemMapper mapper;

    public FoodItemService(FoodItemRepository repository, FoodItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public FoodItemDTO salvar(FoodItemDTO foodItem){
        FoodItem food = mapper.map(foodItem);
        food = repository.save(food);
        return mapper.map(food);
    }

    public List<FoodItemDTO> listar(){
        List<FoodItem> foodItens = repository.findAll();
        return foodItens.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public FoodItemDTO listarItemId(Long id){
        Optional<FoodItem> foodId = repository.findById(id);
        return foodId.map(mapper::map).orElse(null);
    }

    public FoodItemDTO atualizarItem(Long id, FoodItemDTO foodItemDTO){
        Optional<FoodItem> foodExisting = repository.findById(id);
        if (foodExisting.isPresent()){
            FoodItem updatedItem = mapper.map(foodItemDTO);
            updatedItem.setId(id);
            FoodItem savedItem = repository.save(updatedItem);
            return mapper.map(savedItem);
        }else{
            return null;
        }
    }

    public String deletarItem(Long id){
        Optional<FoodItem> foodExisting = repository.findById(id);
        if (foodExisting.isPresent()){
            repository.deleteById(id);
            return "Deletado.";
        }else{
            return null;
        }
    }
}
