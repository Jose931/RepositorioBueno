
public class Producto {
	
	private String id_producto;
	private String descripcion;
	private int stockActual;
	private int stockMinimo;
	private float precio;
	
	
	public Producto(String id_producto, String descripcion, int stockActual, int stockMinimo, float precio) {
		this.id_producto = id_producto;
		this.descripcion = descripcion;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.precio = precio;
	}


	public String getId_producto() {
		return id_producto;
	}


	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getStockActual() {
		return stockActual;
	}


	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}


	public int getStockMinimo() {
		return stockMinimo;
	}


	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	
	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", descripcion=" + descripcion + ", stockActual=" + stockActual
				+ ", stockMinimo=" + stockMinimo + ", precio=" + precio + "]";
	}


	


	
	
	
	
}
