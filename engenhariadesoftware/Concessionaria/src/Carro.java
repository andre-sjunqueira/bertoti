// Classe Entidade: Representa um objeto do mundo real, neste caso, um Carro.
public class Carro {

    // Atributos privados: Características do carro.
    // Usamos 'private' para garantir o Encapsulamento (segurança dos dados).
    private String modelo;
    private String marca;
    private Integer anoFabricacao;

    // Construtor: Método especial chamado quando usamos "new Carro(...)".
    // Serve para inicializar o objeto já com os dados preenchidos.
    public Carro(String modelo, String marca, Integer anoFabricacao) {
        this.modelo = modelo;           // 'this' se refere ao atributo da classe
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
    }

    // Métodos Getters e Setters: Permitem ler (get) e alterar (set) os atributos privados de forma segura.
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    // Regra de Negócio: Método para comparar se o modelo deste carro é igual ao modelo buscado.
    public Boolean comparar(String modeloBuscado) {
        // equalsIgnoreCase compara as Strings ignorando letras maiúsculas e minúsculas.
        if (this.modelo.equalsIgnoreCase(modeloBuscado)) {
            return true;
        }
        return false;
    }
}
