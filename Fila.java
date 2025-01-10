import java.util.ArrayList;

public class Fila {
    private ArrayList<Cliente> listaClientes;
    int quantidadeClientes;

    public Fila(){
        listaClientes = new ArrayList<listaClientes>();
        quantidadeClientes = 0;
    }

    public void novoCliente(Cliente cliente){
        listaClientes.add(cliente);
        quantidadeClientes++;
    }

    public void removerCliente(Cliente cliente){
        listaClientes.remove(cliente);
        quantidadeClientes--;
    }

    public ArrayList<Cliente> getListaClientes(){
        ArrayList<Cliente> novaLista = new ArrayList<Cliente>;
        //ver como faz para clonar
    }

    public int getQuantidadeClientes(){
        return quantidadeClientes;
    }
}
