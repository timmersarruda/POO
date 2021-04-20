import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaComercialMap implements SistemaComercial{
	private Map<String, Cliente> clientes;
	private Map<String, Produto> produtos;
	
	public SistemaComercialMap() {
		this.clientes = new HashMap<String, Cliente>();
		this.produtos = new HashMap<String, Produto>();
	}
	
	@Override
	public boolean existeProduto(Produto produto) {
		if(this.produtos.containsKey(produto.getCodigo())) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean existeCliente(Cliente cliente) {
		if(this.clientes.containsKey(cliente.getId())) {
			return true;
		}else {
		
			return false;
		}
	
	}
	
	@Override
	public Produto pesquisaProduto(CategoriaProduto alimento) throws ProdutoNaoExisteException {
		if (this.produtos.containsKey(alimento)) {
			return this.produtos.get(alimento);
		}
		throw new ProdutoNaoExisteException("Não foi encontrado produto, com o código"+alimento);
	}
	
	@Override
	public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException {
		Cliente c = this.clientes.get(id);
		if(c == null) {
			throw new ClienteNaoExisteException("Não existe cliente com esse id");
		}else {
			return c;
		}
		
	}
	
	@Override
	public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria){
		Collection<Produto> produtosCategoria = new ArrayList<>();
			for(Produto p: this.produtos.values()) {
				if(p.getCategoria().equals(categoria)) {
					produtosCategoria.add(p);
				}
			}
			return produtosCategoria;
	}
	
	public boolean cadastraProduto(Produto produto) {
		if(existeProduto(produto)) {
			return false;
		}else {
			this.produtos.put(produto.getCodigo(), produto);
			return true;
		}
	}

	public Collection<Produto> pesquisaProdutosEmFaixaDePreco(double limiteInferior, double limiteSuperior) {
		Collection<Produto> produtosAchados = new ArrayList<Produto>();
		for (Produto p : produtos.values()) {
			if (p.getPrecoVenda() >= limiteInferior && p.getPrecoVenda() <= limiteSuperior) {
				produtosAchados.add(p);
			}
		}
		return produtosAchados;
	}

	@Override
	public Collection<Produto> pesquisaProdutosComDescricaoComecandoCom(String prefixo) {
		Collection<Produto> produtosAchados = new ArrayList<Produto>();
		for (Produto p : produtos.values()) {
			if (p.getDescricao().startsWith(prefixo)) {
				produtosAchados.add(p);
			}
		}
		return produtosAchados;
	}

	@Override
	public Produto pesquisaProduto(String codigoProduto) throws ProdutoNaoExisteException {
		Produto p = this.produtos.get(codigoProduto);
		if(p == null) {
			throw new ProdutoNaoExisteException("Não existe produto com esse código");
		}else {
			return p;
		}
	}
}
			


