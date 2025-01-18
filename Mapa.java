import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 * Representa um mapa com todos os itens que participam da simulacao
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    private ArrayList<Cliente> listaCliente;
    private ArrayList<Caixa> listaCaixa;
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
        this.listaCaixa = listaCaixa;
    }
    
    public void adicionarCliente(Cliente novoCliente){
        listaCliente.add(novoCliente);
    }
    
    public void removerCliente(Cliente cliente){
        listaCliente.remove(cliente);
    }
    
    public void atualizarMapa(ArrayList<Cliente> listaCliente){
        for (Cliente cliente: listaCliente){
            removerCliente(cliente);
            adicionarCliente(cliente);
        }
    }

    public Cliente getCliente(int X, int Y){
        for (Cliente cliente: listaCliente){
            if(cliente.getLocalizacao().getX() == X && cliente.getLocalizacao().getY() == Y){
                return cliente;
            }
        }
        return null;
    }

    public Caixa getCaixa(int X, int Y){
        for (Caixa caixa: listaCaixa){
            if(caixa.getLocalizacao().getX() == X && caixa.getLocalizacao().getY() == Y){
                return caixa;
            }
        }
        return null;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
    
}
