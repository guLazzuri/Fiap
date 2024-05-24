package ifood.pedido;

import ifood.pagamento.FormaPagamento;

import java.util.List;

public class Pedido {
    private int id;
    private Endereco endereco;
    private List<ItemPedido> itens;
    private double subtotal;
    private double taxaEntrega;
    private double desconto;
    private double valorTotal;
    private STATUS_PEDIDO status;
    private FormaPagamento formaPagamento;
    private AcompanhamentoPedido acompanhamento;
    private double gorjeta;
    private String observacao;
}
