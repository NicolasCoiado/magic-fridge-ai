package dev.java10x.MagicFridgeAi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodCategory {
    CARNES("Alimentos de origem animal como carne bovina, suína, frango e peixe."),
    LATICINIOS("Derivados do leite como queijo, leite, manteiga e ."),
    VEGETAIS("Hortaliças como alface, brócolis, cenoura, espinafre."),
    FRUTAS("Frutas frescas como maçã, banana, laranja, morango."),
    BEBIDAS("Líquidos prontos para consumo como sucos, refrigerantes e água."),
    GRAOS_E_MASSAS("Arroz, feijão, macarrão, aveia, quinoa."),
    DOCES("Alimentos açucarados como chocolates, balas, sobremesas prontas."),
    OVOS("Ovos de galinha ou de outras aves."),
    TEMPEROS("Especiarias e ervas como sal, pimenta, alho, orégano, salsinha."),
    CONGELADOS("Produtos armazenados no congelador, como pizzas ou sorvetes."),
    ENLATADOS("Alimentos em conserva como milho, ervilha, atum."),
    OUTROS("Itens que não se encaixam nas outras categorias.");

    private final String descricao;
}
