package negocio;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael.Soares
 */
public class Produto {
    
	private int produtoId;
	private String nome;
    private float preco;
    private boolean promo;
    
    public Produto(int id, String nomeProd, float precoProd, boolean promocao) {
    	setProdutoId(id);
    	setNome(nomeProd);
    	setPreco(precoProd);
    	setPromo(promocao);
    }
    
    public int getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }
}
