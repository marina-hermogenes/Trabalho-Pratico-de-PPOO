import java.awt.Image;
import java.util.Random;

public abstract class Pessoa {
    //Atributos
    public static final int tempoMaxProduto = 1500;

    Random random = new Random();
    public static final int tempoProduto = random.nextInt(tempoMaxProduto);

    //Define um número aleatório para definir se a pessoa é preferencial ou não
    int numero = random.nextInt(4);
    if (numero == 0) {
        private boolean preferencial = true;
    } else {
        private boolean preferencial = false;
    }

    private Localizacao localizacao;
    private Image imagem;
    
    //Construtor
    public Pessoa(Localizacao localizacao, Image imagem) {
        this.localizacao = localizacao;
        this.imagem = imagem;
    }

    //Métodos Abstratas
    public abstract int getTempoAtendimento();
    public abstract void executarAcao();
    
    //Métodos 
    public boolean isPreferencial() {
        return preferencial;
    }
    
    public int getTempoPorProd() {
        return tempoProduto;
    }
    
    public Localizacao getLocalizacao() {
        return localizacao;
    }
    
    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
    
    public Image getImagem() {
        return imagem;
    }
}
