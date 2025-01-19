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

    public void trocarFilaCliente(Sistema sistema, Fila fila) { 
        setPosicaoFila(fila.getQuantidadeClientes() - 1); //atualizando posição dele na menor fila

        //atualizando a localizacaoDestino depois da troca de fila
        localizacaoDestino = new Localizacao(getLocalizacao().getX(), getLocalizacao().getY() + 2); 
        System.out.println("Cliente trocou para a fila com menos pessoas.");
    }

    public Localizacao getLocalizacaoDestino() {
        return localizacaoDestino;
    }

    public void setLocalizacaoDestino(Localizacao localizacaoDestino) {
        this.localizacaoDestino = localizacaoDestino;
    }

    @Override
    public void executarAcao() {
        System.out.println("Entrou em executar ação no cliente");
            setLocalizacao(localizacaoDestino); // atualiza a posição do cliente para o destino
            localizacaoDestino = new Localizacao(getLocalizacao().getX(), getLocalizacao().getY() - 1); 
            System.out.println("Cliente avançando para a próxima posição na fila.");
    }

}
