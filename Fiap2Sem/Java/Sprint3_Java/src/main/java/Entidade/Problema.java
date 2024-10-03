package Entidade;

public class Problema extends EntidadeBase {
    private int idDiagnostico;
    private String descricao;
    private String tpProblema;
    private String status;

    public Problema(int id, int idDiagnostico, String descricao, String tpProblema, String status) {
        super(id);
        this.idDiagnostico = idDiagnostico;
        this.descricao = descricao;
        this.tpProblema = tpProblema;
        this.status = status;
    }

    // Getters and Setters
    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTpProblema() {
        return tpProblema;
    }

    public void setTpProblema(String tpProblema) {
        this.tpProblema = tpProblema;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
