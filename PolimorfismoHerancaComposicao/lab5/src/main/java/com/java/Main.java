package com.java;

import com.Classes.Controle;
import com.Excecoes.FilmeExistente;
import com.Excecoes.FilmeNaoEncontrado;
import com.Excecoes.FuncionarioExistente;
import com.Excecoes.FuncionarioNaoEncontrado;
import com.Excecoes.PapelNaoEncontrado;
import com.Excecoes.TamanhoIncompativel;
import com.Interface.Papeis;

public class Main {
    // objetos e arrays static
    static Controle controleGloboFilmes;
    static private String[] filmes;
    static private String[] anosDeLancamento;
    static private String[][] trilhasSonoras;
    static private String[] funcionarios;
    static private Papeis[] papeis;

    public static void main(String[] args) {
        controleGloboFilmes = new Controle();
        iniciarVariaveis();
        try {
            cadastrarFilmes();
            cadastrarFuncionarios();
            alocarFuncionarios();
            exibirDadosDoFilme("Harry Potter e o Prisioneiro de Askaban");
            exibirFilmografiaDoFuncionario("Emma Watson");

            System.out.print("------------------------------------------------------------------------\n");

            exibirDadosDoFilme("Um Filme Minecraft");
            exibirFilmografiaDoFuncionario("Jack Black");
        } catch (FilmeNaoEncontrado | FuncionarioExistente | FuncionarioNaoEncontrado
                | PapelNaoEncontrado | TamanhoIncompativel | FilmeExistente e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    // Cadastrar funcionario
    public static void cadastrarFuncionario() throws FuncionarioExistente {
        for (String funcionario : funcionarios) {
            controleGloboFilmes.adicionarFuncionario(funcionario);
        }
    }

    // arrays

    private static void iniciarVariaveis() {

        filmes = new String[] { "Harry Potter e o Prisioneiro de Askaban", "Um Filme Minecraft",
                "O Auto da Compadecida 2", "Cidade de Deus", "Titanic" };
        
        anosDeLancamento = new String[] {
                "2004", // Harry Potter e o Prisioneiro de Azkaban
                "2025", // Um Filme Minecraft
                "2024", // O Auto da Compadecida 2
                "2002", // Cidade de Deus
                "1997" // Titanic
        };

        trilhasSonoras = new String[][] {
                // Harry Potter e o Prisioneiro de Azkaban
                {
                        "\"A Window to the Past\" - John Williams",
                        "\"Buckbeak’s Flight\" - John Williams",
                        "\"Double Trouble\" - John Williams"
                },

                // Um Filme Minecraft
                {
                        "\"Blocos e Sombras\" - Daniel Rosenfeld (C418)",
                        "\"Eco dos Pixels\" - Lena Raine",
                        "\"Ritmo da Redstone\" - Gareth Coker"
                },

                // O Auto da Compadecida 2
                {
                        "\"Nordestino Sonhador\" - Gilberto Gil",
                        "\"Cordel e Fé\" - Dominguinhos",
                        "\"Caminho da Graça\" - Elba Ramalho"
                },

                // Cidade de Deus
                {
                        "\"Convite para Vida Loka\" - Antonio Pinto",
                        "\"Favela Groove\" - Seu Jorge",
                        "\"No Ritmo da Correria\" - MV Bill"
                },

                // Titanic
                {
                        "\"My Heart Will Go On\" - Celine Dion",
                        "\"Hymn to the Sea\" - James Horner",
                        "\"Southampton\" - James Horner"
                }
        };

        funcionarios = new String[] {
                // Harry Potter e o Prisioneiro de Askaban
                "Alfonso Cuarón",                                   // DIRETOR
                "Steve Kloves",                                     // ROTEIRISTA — adaptou o livro
                "Michael Seresin",                                  // CAMERA
                "Peter Cavaciuti",                                  // CINEGRAFISTA
                "Daniel Radcliffe",                                 // ATOR
                "Emma Watson",                                      // ATOR
                "Rupert Grint",                                     // ATOR

                // Um Filme Minecraft (2025, previsto)
                "Jared Hess",                                       // DIRETOR
                "Allison Schroeder",                                // ROTEIRISTA
                "Felix Monti",                                      // CAMERA
                "Kátia Lund",                                       // CINEGRAFISTA
                "Jason Momoa",                                      // ATOR
                "Jack Black",                                       // ATOR
                "Emma Myers",                                       // ATOR
               
                // Auto da Compadecida 2
                "Guel Arraes",                                      // DIRETOR
                "Adriana Falcão",                                   // ROTEIRISTA
                "Fernando Meirelles",                               // CAMERA
                "Lia Renha",                                        // CINEGRAFISTA
                "Matheus Nachtergaele",                             // ATOR
                "Selton Mello",                                     // ATOR
                "Fernanda Montenegro",                              // ATOR

                // // Cidade de Deus (2002)
                // "Fernando Meirelles (Diretor)",
                // "Kátia Lund (Co-diretora)",
                // "Bráulio Mantovani (Roteirista)",
                // "Alexandre Rodrigues (Ator - Buscapé)",
                // "Leandro Firmino (Ator - Zé Pequeno)",

                // // Titanic (1997)
                // "James Cameron (Diretor/Roteirista)",
                // "Leonardo DiCaprio (Ator - Jack Dawson)",
                // "Kate Winslet (Atriz - Rose DeWitt)",
                // "Jon Landau (Produtor)",
                // "James Horner (Compositor)"
        };

        papeis = new Papeis[] {
                Papeis.DIRETOR, Papeis.ROTEIRISTA, Papeis.CAMERA, Papeis.CINEGRAFISTA,
                Papeis.ATOR, Papeis.ATOR, Papeis.ATOR};
    }

    private static void exibirFilmografiaDoFuncionario(String nome) throws FuncionarioNaoEncontrado {
        controleGloboFilmes.exibirFilmografia(nome);
    }

    private static void exibirDadosDoFilme(String nome) throws FilmeNaoEncontrado {
        controleGloboFilmes.exibirDadosFilme(nome);
    }

    private static void alocarFuncionarios()
            throws FilmeNaoEncontrado, PapelNaoEncontrado, TamanhoIncompativel, FuncionarioNaoEncontrado {

        String[] funcionariosFilme1 = new String[] {
            "Alfonso Cuarón",                                   // DIRETOR
            "Steve Kloves",                                     // ROTEIRISTA — adaptou o livro
            "Michael Seresin",                                  // CAMERA
            "Peter Cavaciuti",                                  // CINEGRAFISTA
            "Daniel Radcliffe",                                 // ATOR
            "Emma Watson",                                      // ATOR
            "Rupert Grint",                                     // ATOR
        };


        // Um Filme Minecraft (2025)
        String[] funcionariosFilme2 = new String[] {
            "Jared Hess",                                       // DIRETOR
            "Allison Schroeder",                                // ROTEIRISTA
            "Felix Monti",                                      // CAMERA
            "Kátia Lund",                                       // CINEGRAFISTA
            "Jason Momoa",                                      // ATOR
            "Jack Black",                                       // ATOR
            "Emma Myers",                                       // ATOR
        };

        // O Auto da Compadecida 2 (2024)
        String[] funcionariosFilme3 = new String[] {
            "Guel Arraes",                                      // DIRETOR
            "Adriana Falcão",                                   // ROTEIRISTA
            "Fernando Meirelles",                               // CAMERA
            "Lia Renha",                                        // CINEGRAFISTA
            "Matheus Nachtergaele",                             // ATOR
            "Selton Mello",                                     // ATOR
            "Fernanda Montenegro",                              // ATOR
        };


    controleGloboFilmes.cadastrarEnvolvidos(filmes[0], papeis, funcionariosFilme1);
    controleGloboFilmes.cadastrarEnvolvidos(filmes[1], papeis, funcionariosFilme2);
    controleGloboFilmes.cadastrarEnvolvidos(filmes[2], papeis, funcionariosFilme3);
    }

    private static void cadastrarFuncionarios() throws FuncionarioExistente {
        // Adiciona todos os funcionarios ao sistema
        for (String funcionario : funcionarios)
            controleGloboFilmes.adicionarFuncionario(funcionario);
    }

    private static void cadastrarFilmes() throws FilmeExistente {
        for(int i = 0; i < filmes.length; i++){
            controleGloboFilmes.cadastrarFilme(filmes[i],anosDeLancamento[i],trilhasSonoras[i]);
        }
    }
}
