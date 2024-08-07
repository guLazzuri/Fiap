package Entidades;

import java.time.LocalDateTime;

public class Cupom extends _EntidadesBases{
    private int quantidadesDeUso;
    private LocalDateTime validade;
    private Boolean ativo;
    private String codigo;
    private double desconto;
    private String tipoDeDesconto;

    public Cupom(int id, int quantidadesDeUso, LocalDateTime validade, Boolean ativo, String codigo, double desconto, String tipoDeDesconto) {
        super(id);
        this.quantidadesDeUso = quantidadesDeUso;
        this.validade = validade;
        this.ativo = ativo;
        this.codigo = codigo;
        this.desconto = desconto;
        this.tipoDeDesconto = tipoDeDesconto;
    }

    public Cupom() {
    }

    public int getQuantidadesDeUso() {
        return quantidadesDeUso;
    }

    public void setQuantidadesDeUso(int quantidadesDeUso) {
        this.quantidadesDeUso = quantidadesDeUso;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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

    public String getTipoDeDesconto() {
        return tipoDeDesconto;
    }

    public void setTipoDeDesconto(String tipoDeDesconto) {
        this.tipoDeDesconto = tipoDeDesconto;
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "quantidadesDeUso=" + quantidadesDeUso +
                ", validade=" + validade +
                ", ativo=" + ativo +
                ", codigo='" + codigo + '\'' +
                ", desconto=" + desconto +
                ", tipoDeDesconto='" + tipoDeDesconto + '\'' +
                "} " + super.toString();
    }
}
