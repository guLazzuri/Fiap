package ifood.pagamento;

public class Pix extends FormaPagamento{
    private String chavePix;
    private String qrCode;
    public Pix() {
        this.tipo = TIPO_PAGAMENTO.PIX;
    }
}
