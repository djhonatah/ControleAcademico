package classes;

import Excecoes.FiguraDesconhecida;

public class FigurasGeometricas {

	public static final int CIRCULO = 1;
    public static final int QUADRADO = 2;
    public static final int RETANGULO = 3;
    public static final int TODOS = 0;

    private final Circulo circulo;
    private final Quadrado quadrado;
    private final Retangulo retangulo;

    public FigurasGeometricas(int raio, int lado, int altura, int largura){
        this.circulo = new Circulo(raio);
        this.quadrado = new Quadrado(lado);
        this.retangulo = new Retangulo(altura, largura);
    }

    public double perimetro(int tipoDaFigura) throws FiguraDesconhecida {
        return switch (tipoDaFigura) {
            case RETANGULO -> retangulo.perimetro();
            case QUADRADO -> quadrado.perimetro();
            case CIRCULO -> circulo.perimetro();
            default -> throw new FiguraDesconhecida("Tipo de figura inválido.");
        };
    }

    public double area(int tipoDaFigura) throws FiguraDesconhecida {
        return switch (tipoDaFigura) {
            case RETANGULO -> retangulo.area();
            case QUADRADO -> quadrado.area();
            case CIRCULO -> circulo.area();
            default -> throw new FiguraDesconhecida("Tipo de figura inválido.");
        };
    }

    public String toStringDaFigura(int tipoDaFigura) throws FiguraDesconhecida {
        return switch (tipoDaFigura) {
            case RETANGULO -> "A altura do retângulo é: " + retangulo.getAltura() + "\nA largura do retângulo é: " + retangulo.getLargura();
            case QUADRADO -> "O tamanho dos lados do quadrado é: " + quadrado.getLado() + "\n";
            case CIRCULO -> "O tamanho de raio do circulo é: " + circulo.getRaio() + "\n";
            case TODOS -> "A altura do retângulo é: " + retangulo.getAltura() + "\nA largura do retângulo é: " + retangulo.getLargura() + "\nO tamanho dos lados do quadrado é: " + quadrado.getLado() + "\nO tamanho de raio do circulo é: " + circulo.getRaio();
            default -> throw new FiguraDesconhecida("Nenhuma função corresponde ao comando fornecido");
        };
    }
}
