package negocio;

import java.util.ArrayList;
import java.util.Calendar;

public class Compra {
	
	private int compraId;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private double vlrTotal = 0.0;
	private Calendar data;
	
	public int getCompraId() {
		return compraId;
	}
	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}
	public Compra () {
		
	}
	public Compra (ArrayList<Produto> prods , int ano, int mes, int dia) {
		produtos = prods;
		setData(ano, mes, dia);
		setVlrTotal();
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public void addProduto(Produto produto) {
		this.produtos.add(produto);
		setVlrTotal();
	}
	public double getVlrTotal() {
		return vlrTotal;
	}
	public void setVlrTotal() {
		double s = 0.0;
		for (Produto prod : produtos) {
			s = s + prod.getPreco();
		}
		this.vlrTotal = s;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(int ano, int mes, int dia) {
		data = Calendar.getInstance();
		this.data.set(ano, mes, dia);
	}
}
