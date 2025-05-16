package excecoes;

public class FiguraJaCriadaException extends RuntimeException {
    public FiguraJaCriadaException(String nomeFigura) {
        super(nomeFigura + " já foi criada anteriormente.");
    }
}
