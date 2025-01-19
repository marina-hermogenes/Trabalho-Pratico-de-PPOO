import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 * Representa um mapa com todos os itens que participam da simulacao
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    private Cliente[][] clientes;
    private Caixa[][] caixas;
    private int largura;
    private int altura;
    
    private static final int LARGURA_PADRAO = 35;
    private static final int ALTURA_PADRAO = 35;
    
    /**
     * Cria mapa para alocar itens da simulacao.
     * @param largura: largura da área de simulacao.
     * @param altura: altura da área de simulação.
     */
    public Mapa(ArrayList<Caixa> listaCaixa){
        this.largura = LARGURA_PADRAO;
        this.altura = ALTURA_PADRAO;
        clientes = new Cliente[altura][largura];
        caixas = new Caixa[altura][largura];
        for (Caixa caixa: listaCaixa){
            caixas[caixa.getLocalizacao().getX()][caixa.getLocalizacao().getY()] = caixa;
        }
    }
    
    public void adicionarCliente(Cliente novoCliente){
        System.out.println("Adicionou cliente no mapa");
        clientes[novoCliente.getLocalizacao().getX()][novoCliente.getLocalizacao().getY()] = novoCliente;
    }
    
    public void removerCliente(Cliente cliente){
        clientes[cliente.getLocalizacao().getX()][cliente.getLocalizacao().getY()] = null;
    }
    
    public void atualizarMapa(ArrayList<Cliente> listaCliente){
        for (Cliente cliente: listaCliente){
            removerCliente(cliente);
            adicionarCliente(cliente);
        }
    }

    public Cliente getCliente(int x, int y){
        return clientes[x][y];
    }

    public Caixa getCaixa(int x, int y){
        return caixas[x][y];
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
    
}
