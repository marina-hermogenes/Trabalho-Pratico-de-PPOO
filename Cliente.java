import java.awt.Image;

public class Cliente extends Pessoa {
    public static final int MAX_QUANT_PRODUTOS = 50;
    private final int QUANT_PRODUTOS;
    private int posicaoFila;
    private Localizacao localizacaoDestino;

    public Cliente(Localizacao localizacao, Image imagem) {
        super(localizacao, imagem);
        this.QUANT_PRODUTOS = new java.util.Random().nextInt(MAX_QUANT_PRODUTOS) + 1;
        this.posicaoFila = -1;
        this.localizacaoDestino = null;
    }

    @Override
    public int getTempoAtendimento() {
        return getTempoPorProd() * QUANT_PRODUTOS;
    }

    public int getQuantidadeProdutos() {
        return QUANT_PRODUTOS;
    }

    public int getPosicaoFila() {
        return posicaoFila;
    }

    public void setPosicaoFila(int posicaoFila) {
        this.posicaoFila = posicaoFila;
    }

    public void trocarFilaCliente(Sistema sistema) {
        Fila menorFila = sistema.getMenorFila();
    
        Fila filaAtual = null;
        for (Fila fila : sistema.listaFilas) {
            if (fila.getListaClientes().contains(this)) {
                filaAtual = fila;
            }
        }
    
        if (filaAtual != null && menorFila != null && filaAtual.getQuantidadeClientes() > menorFila.getQuantidadeClientes()) {
            filaAtual.removerCliente(this); //removendo cliente da fila atual
            menorFila.novoCliente(this); //adicionando cliente na menor fila
            setPosicaoFila(menorFila.getQuantidadeClientes()); //atualizando posição dele na menor fila
        
            //atualizando a localizacaoDestino depois da troca de fila
            localizacaoDestino = new Localizacao(getLocalizacao().getX(), getLocalizacao().getY() + 1); 
            System.out.println("Cliente trocou para a fila com menos pessoas.");
        } else {
            System.out.println("Cliente permaneceu na mesma fila.");
        }
    }

    public Localizacao getLocalizacaoDestino() {
        return localizacaoDestino;
    }

    public void setLocalizacaoDestino(Localizacao localizacaoDestino) {
        this.localizacaoDestino = localizacaoDestino;
    }

    @Override
    public void executarAcao() {
        if (localizacaoDestino != null) {
            setLocalizacao(localizacaoDestino); //atualiza a posição do cliente para o destino
        } else {        
            if (posicaoFila >= 0) {
                localizacaoDestino = new Localizacao(getLocalizacao().getX(), getLocalizacao().getY() + 1); 
                System.out.println("Cliente avançando para a próxima posição na fila.");
            }
        }
    }
}
