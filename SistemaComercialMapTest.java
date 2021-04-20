import org.junit.jupiter.api.Test;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaComercialMapTest {
	@Test
	public void testaCadastroProdutos() {
		SistemaComercialMap sistema = new SistemaComercialMap();
		Collection<Produto> alimentos = sistema.pesquisaProduto(CategoriaProduto.ALIMENTO);
		assertTrue(alimentos.size()==0);
		sistema.cadastraProduto(new Produto("333", "Calça boca de sino", 100.00, 100, CategoriaProduto.ROUPA));
		Collection<Produto> produtosNoPreco = sistema.pesquisaProdutosEmFaixaDePreco(50, 150);
		assertTrue(produtosNoPreco.size()==1);
		Collection<Produto> produtosCalca = sistema.pesquisaProdutosComDescricaoComecandoCom("Calça");
		assertTrue(produtosCalca.size()==1);
	}

}
