package fiap.tds.entities;

public class CupomDeDesconto {
    private int id;
    private String codigo;
    private double desconto;

    public CupomDeDesconto() {
    }

    public CupomDeDesconto(int id, String codigo, double desconto) {
        this.id = id;
        this.codigo = codigo;
        this.desconto = desconto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "CupomDeDesconto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", desconto=" + desconto +
                '}';
    }
}
