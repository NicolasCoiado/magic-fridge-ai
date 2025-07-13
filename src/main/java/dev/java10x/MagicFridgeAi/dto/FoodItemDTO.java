package dev.java10x.MagicFridgeAi.dto;

import dev.java10x.MagicFridgeAi.enums.FoodCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {
    private Long id;
    private String nome;
    private FoodCategory categoria;
    private Integer quantidade;
    private LocalDate validade;
}
