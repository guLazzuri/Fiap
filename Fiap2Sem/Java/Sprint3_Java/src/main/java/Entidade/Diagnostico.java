package Entidade;

public class Diagnostico extends EntidadeBase {
    private int idCarro;
    private String descricao;
    private String dataDiagnostico;
    private String nomeMecanico;

    public Diagnostico(int id, int idCarro, String descricao, String dataDiagnostico, String nomeMecanico) {
        super(id);
        this.idCarro = idCarro;
        this.descricao = descricao;
        this.dataDiagnostico = dataDiagnostico;
        this.nomeMecanico = nomeMecanico;
    }

    // Getters and Setters
    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataDiagnostico() {
        return dataDiagnostico;
    }

    public void setDataDiagnostico(String dataDiagnostico) {
        this.dataDiagnostico = dataDiagnostico;
    }

    public String getNomeMecanico() {
        return nomeMecanico;
    }

    public void setNomeMecanico(String nomeMecanico) {
        this.nomeMecanico = nomeMecanico;
    }
}
