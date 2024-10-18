package videoclub;

public class Pelicula {
    private String titulo;
    private Categoria categoria;

    public Pelicula(String titulo, Categoria categoria) {
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPuntos(int dias) {
        return categoria.getPuntos(dias);
    }

    public double getPrecio(int dias) {
        return categoria.getPrecio(dias);
    }
}
