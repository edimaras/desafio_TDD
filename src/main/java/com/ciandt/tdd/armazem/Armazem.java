package com.ciandt.tdd.armazem;

import com.ciandt.tdd.ingrediente.Ingrediente;

import java.util.TreeMap;

public class Armazem {

    private TreeMap<Ingrediente, Integer> estoque;

    public Armazem() {
        this.estoque = new TreeMap<>();
    }

    public TreeMap<Ingrediente, Integer> getEstoque() {
        return estoque;
    }

    public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente) {
        if (estoque.containsKey(ingrediente)) {
            throw new IllegalArgumentException("Ingrediente já cadastrado");
        }
        estoque.put(ingrediente, 0);
    }

    public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente) {
        if (!estoque.containsKey(ingrediente)) {
            throw new IllegalArgumentException("Ingrediente não encontrado");
        }
        estoque.remove(ingrediente);
    }

    public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidadeAdicionada) {
        if (quantidadeAdicionada <= 0 || !estoque.containsKey(ingrediente)){
            throw new IllegalArgumentException("Ingrediente não encontrado ou quantidade inválida");
        }

        estoque.computeIfPresent(ingrediente, (key, value) -> value + quantidadeAdicionada);
    }

    public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidadeReduzida) {
        if (quantidadeReduzida <= 0 || !estoque.containsKey(ingrediente) || estoque.get(ingrediente) - quantidadeReduzida < 0) {
            throw new IllegalArgumentException("Ingrediente não encontrado ou quantidade inválida");
        }

        estoque.computeIfPresent(ingrediente, (key, value) -> value - quantidadeReduzida);
    }

    public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente) {
        if (!estoque.containsKey(ingrediente)){
            throw new IllegalArgumentException("Ingrediente não encontrado");
        }
        return estoque.get(ingrediente);
    }
}
