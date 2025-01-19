import java.util.ArrayList;

public class Fila {
    private ArrayList<Cliente> listaClientes;
    int quantidadeClientes;

    public Fila(){
        listaClientes = new ArrayList<Cliente>();
        quantidadeClientes = 0;
    }

    public void novoCliente(Cliente cliente){
        listaClientes.add(cliente);
        quantidadeClientes++;
    }

    public Cliente removerCliente(int posicao){
        Cliente cliente = listaClientes.get(posicao);
        listaClientes.remove(posicao);
        quantidadeClientes--;
        return cliente;
    }

    public ArrayList<Cliente> getListaClientes(){
        return listaClientes;
    }

    public int getQuantidadeClientes(){
        return quantidadeClientes;
    }
}
