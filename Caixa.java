import java.util.Random;

public class Caixa extends Pessoa{
    Fila filaCaixa;

    //Construtor
    public Caixa(Localizacao local, Imagem imagem){
        super(local, imagem);
        this.filaCaixa = new Fila();
    }

    //Método que retorna o tempo de atendimento do cliente
    @Override
    public void executarAcao(){
        if(filaCaixa.getQuantidadeClientes > 0){
            Thread.sleep(getTempoAtendimento());
            System.out.println("Cliente atendido em: " + filaCaixa.getListaClientes().get(0).getTempoAtendimento());
            filaCaixa.removerCliente(0); //posição do cliente na fila
        } 
    }

    //get tempo atendimento do primeiro cliente da fila deveria ser feito só aqui
    public int getTempoAtendimento(){
        return filaCaixa.getListaClientes().get(0).getQuantidadeProdutos() * getTempoPorProd();
    }
    //ideal ter o método de pegar o primeiro cliente da fila na classe Fila
}