import java.awt.Image;
import java.util.Random;

public abstract class Pessoa {
    //Atributos
    public static final int tempoMaxProduto = 1500;
    public static final int tempoProduto = random.nextInt(tempoMaxProduto);
    private boolean preferencial;
    private Localizacao localizacao;
    private Image imagem;
    
    //Construtor
    public Pessoa(boolean preferencial, Localizacao localizacao, Image imagem) {
        this.preferencial = preferencial;
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
