import java.util.Collection;

public interface SistemaComercial {
	
	public boolean existeProduto(Produto produto); 
	public Produto pesquisaProduto(String codigoProduto) 
	throws ProdutoNaoExisteException; 
	
	public boolean cadastraProduto(Produto produto);
	
	public boolean existeCliente(Cliente cliente);
	
	public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException;
	
	public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria);
	
	public Collection<Produto> pesquisaProdutosEmFaixaDePreco(double limiteInferior, double limiteSuperior);
	
	public Collection<Produto> pesquisaProdutosComDescricaoComecandoCom(String prefixo);
	
	Produto pesquisaProduto(CategoriaProduto alimento) throws ProdutoNaoExisteException;
	  
	
}
