package com.ciandt.tdd.armazem;

import com.ciandt.tdd.ingrediente.Base;
import com.ciandt.tdd.ingrediente.TipoBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArmazemTest {

	Armazem armazem;

	@BeforeEach
	void setup(){
		armazem = new Armazem();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testCadastrarIngredienteEmEstoque() {

		Base sorvete = new Base(TipoBase.Sorvete);
		armazem.cadastrarIngredienteEmEstoque(sorvete);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> armazem.cadastrarIngredienteEmEstoque(sorvete));
		assertEquals("Ingrediente já cadastrado", exception.getMessage());
	}

	@Test
	void testDescadastrarIngredienteEmEstoque() {

		Base sorvete = new Base(TipoBase.Sorvete);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> armazem.descadastrarIngredienteEmEstoque(sorvete));
		assertEquals("Ingrediente não encontrado", exception.getMessage());
	}

	@Test
	void testAdicionarQuantidadeDoIngredienteEmEstoque() {

		Base sorvete = new Base(TipoBase.Sorvete);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> armazem.adicionarQuantidadeDoIngredienteEmEstoque(sorvete, -10));
		assertEquals("Ingrediente não encontrado ou quantidade inválida", exception.getMessage());

		armazem.cadastrarIngredienteEmEstoque(sorvete);

		IllegalArgumentException exceptionQuantidade = assertThrows(IllegalArgumentException.class, () -> armazem.adicionarQuantidadeDoIngredienteEmEstoque(sorvete, -10));
		assertEquals("Ingrediente não encontrado ou quantidade inválida", exceptionQuantidade.getMessage());

	}

	@Test
	void testReduzirQuantidadeDoIngredienteEmEstoque(){

		Base sorvete = new Base(TipoBase.Sorvete);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(sorvete, 2));
		assertEquals("Ingrediente não encontrado ou quantidade inválida", exception.getMessage());
		armazem.cadastrarIngredienteEmEstoque(sorvete);

		IllegalArgumentException exceptionQuantidadeInsuficiente = assertThrows(IllegalArgumentException.class, () -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(sorvete, 10));
		assertEquals("Ingrediente não encontrado ou quantidade inválida", exceptionQuantidadeInsuficiente.getMessage());

		IllegalArgumentException exceptionQuantidadeNegativa = assertThrows(IllegalArgumentException.class, () -> armazem.reduzirQuantidadeDoIngredienteEmEstoque(sorvete, -10));
		assertEquals("Ingrediente não encontrado ou quantidade inválida", exceptionQuantidadeNegativa.getMessage());

	}

	@Test
	void testConsultarQuantidadeDoIngredienteEmEstoque() {

		Base sorvete = new Base(TipoBase.Sorvete);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> armazem.consultarQuantidadeDoIngredienteEmEstoque(sorvete));
		assertEquals("Ingrediente não encontrado", exception.getMessage());

	}

}
