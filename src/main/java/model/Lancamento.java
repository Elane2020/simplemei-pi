package model;


/**
 * Entidade que representa um lançamento no sistema.
 * 
 * @author Elane
 */

public class Lancamento {

    private int id;
    private Movimento tipo;
    private String dataOperacao;
    private String dataVencimento;
    private String setor;
    private String contas;
    private String descricao;
    private double valorOrig;
    private String clienteFornecedor;
    private String status;
    private String dataLiquidacao;
    private String formas;
    private double valorLiquidado;
    private double juros;
    private double desconto;

    public Lancamento() {
        
    }
    
    public Lancamento(Movimento tipo, String dataOperacao, String dataVencimento, 
            String setor, String contas, String descricao, double valorOrig, String clienteFornecedor,
            String status, String dataLiquidacao, String formas,
            double valorLiquidado, double juros, double desconto) {
        this.tipo = tipo;
        this.dataOperacao = dataOperacao;
        this.dataVencimento = dataVencimento;
        this.setor = setor;
        this.contas = contas;
        this.descricao = descricao;
        this.valorOrig = valorOrig;
        this.clienteFornecedor = clienteFornecedor;
        this.status = status;
        this.dataLiquidacao = dataLiquidacao;
        this.formas = formas;
        this.valorLiquidado = valorLiquidado;
        this.juros = juros;
        this.desconto = desconto;
    }
    
 //construtor com ID (usado quando o registro vem do banco)

    public Lancamento(int id, Movimento tipo, String dataOperacao, String dataVencimento, 
            String setor, String contas, String descricao, double valorOrig, String clienteFornecedor,
            String status, String dataLiquidacao, String formas,
            double valorLiquidado, double juros, double desconto) {
        this(tipo, dataOperacao, dataVencimento, setor, contas, descricao, valorOrig,
                clienteFornecedor, status, dataLiquidacao, formas, valorLiquidado, juros, desconto);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Movimento getTipo() {
        return tipo;
    }

    public void setTipo(Movimento tipo) {
        this.tipo = tipo;
    }

    public String getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(String dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getContas() {
        return contas;
    }

    public void setContas(String contas) {
        this.contas = contas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorOrig() {
        return valorOrig;
    }

    public void setValorOrig(double valorOrig) {
        this.valorOrig = valorOrig;
    }

    public String getClienteFornecedor() {
        return clienteFornecedor;
    }

    public void setClienteFornecedor(String clienteFornecedor) {
        this.clienteFornecedor = clienteFornecedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataLiquidacao() {
        return dataLiquidacao;
    }

    public void setDataLiquidacao(String dataLiquidacao) {
        this.dataLiquidacao = dataLiquidacao;
    }

    public String getFormas() {
        return formas;
    }

    public void setFormas(String formas) {
        this.formas = formas;
    }

    public double getValorLiquidado() {
        return valorLiquidado;
    }

    public void setValorLiquidado(double valorLiquidado) {
        this.valorLiquidado = valorLiquidado;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}   

    