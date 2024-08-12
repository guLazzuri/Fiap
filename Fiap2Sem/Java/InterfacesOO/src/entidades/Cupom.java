package entidades;

import java.time.LocalDate;

public class Cupom extends _EntidadeBase{
    private String codigo;
    private int desconto;
    private char tipoDesconto; // porcentagem = p ou valor = v
    private LocalDate dataValidade;

    public Cupom() {
    }

    public Cupom(int id, String codigo, int desconto, char tipoDesconto, LocalDate dataValidade) {
        super(id);
        this.codigo = codigo;
        this.desconto = desconto;
        this.tipoDesconto = tipoDesconto;
        this.dataValidade = dataValidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public char getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(char tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "codigo='" + codigo + '\'' +
                ", desconto=" + desconto +
                ", tipoDesconto=" + tipoDesconto +
                ", dataValidade=" + dataValidade +
                "} " + super.toString();
    }
}
