package Repositorio;

import Entidades.Album;
import Entidades.Artista;
import Entidades.Musica;
import Validacao.VailidadorDeEntidade;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArtistaRepositorio extends RepositorioGenericoImp <Artista> {
    public ArtistaRepositorio() {
        super(Artista.class);
    }

    public void cadastrarArtista() throws Exception {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digite o ID do Artista: ");
            String id = sc.nextLine();                          //Da pra fazer esse processo 3x
            VailidadorDeEntidade.validarID(id); //alterar se usar

            System.out.println("Digite o Nome do Artista: ");
            String nome = sc.nextLine();                          //Da pra fazer esse processo 3x
            VailidadorDeEntidade.validarNomeDoArtista(nome); //alterar se usar

            System.out.println("Digite o Genero Musical: ");
            String genero = sc.nextLine();                          //Da pra fazer esse processo 3x
            VailidadorDeEntidade.validarGenero(genero); //alterar se usar

            List<Album> listaDeAlguns = new ArrayList<>();
            Artista artista = new Artista(id, nome, genero, listaDeAlguns);
            adicionar(artista);

            System.out.println("Artista cadastrado com sucesso! ");

        }catch (Exception e){
            System.out.println("Erro:" + e.getMessage());
        }
    }
    public List<Artista> pesquisarPorGenero(String genero){
        List<Artista> artistasEncontrados = new ArrayList<>();
        for (Artista artista : listaDeEntidades){
            if (artista.getGeneroMusical().equalsIgnoreCase(genero)){
                artistasEncontrados.add(artista);
            }
        }
        return  artistasEncontrados;
    }


}
