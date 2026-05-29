import java.util.LinkedList;
import java.util.List;

public class Concessionaria {

    private List<Carro> carros = new LinkedList<>();

    public void cadastrarCarro(Carro carro) {
        carros.add(carro);
    }

    public List<Carro> buscarPorModelo(String modelo) {
        List<Carro> encontrados = new LinkedList<>();
        for (Carro carro : carros) {
            if (carro.getModelo().equalsIgnoreCase(modelo)) {
                encontrados.add(carro);
            }
        }
        return encontrados;
    }

    public List<Carro> getCarros() {
        return carros;
    }
}
