import java.util.Random;
import java.util.ArrayList;
/**
 * Responsavel pela simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Simulacao {
    private Sistema sistema;
    private JanelaSimulacao janelaSimulacao;
    private Mapa mapa;
    private ArrayList<Cliente> listaCliente;
    
    public Simulacao() {
        Random rand = new Random(12345);
        listaCliente = new ArrayList<Cliente>();
        sistema = new Sistema();//Cria os caixas nas posicoes determinadas
        mapa = new Mapa(sistema.getListaCaixa());
        sistema.adicionarMapa(mapa);
        janelaSimulacao = new JanelaSimulacao(mapa);
    }
    
    public void executarSimulacao(int numPassos){
        janelaSimulacao.executarAcao();
        for (int i = 0; i < numPassos; i++) {
            executarUmPasso();
            esperar(100);
        }        
    }

    private void executarUmPasso() {
        System.out.println("Entrou em executar um passo");
        if (new Random().nextInt(2) == 0) { // Ajuste a probabilidade como desejar
            System.out.println ("Entrou no if pra cliente");
            Cliente novoCliente = sistema.criarCliente();
            listaCliente.add(novoCliente);
        }
        
        for(Caixa caixa: sistema.getListaCaixa()){
            caixa.executarAcao();
            System.out.println(caixa.getFila().getQuantidadeClientes());
            for(Cliente cliente: caixa.getFila().getListaClientes()){
                cliente.executarAcao();
            }

        }

        mapa.atualizarMapa(listaCliente);
        janelaSimulacao.executarAcao();
    }
    
    private void esperar(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    
}
