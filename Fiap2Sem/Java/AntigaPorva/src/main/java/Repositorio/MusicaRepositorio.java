package Repositorio;

import Entidades.Musica;
import Validacao.VailidadorDeEntidade;

import java.util.Scanner;

public class MusicaRepositorio extends RepositorioGenericoImp<Musica> {


    public MusicaRepositorio() {
        super(Musica.class);
    }

    public void cadastrarMusica(){
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Digite o ID da Música: ");
            String id = sc.nextLine();                          //Da pra fazer esse processo 3x
            VailidadorDeEntidade.validarID(id); //alterar se usar

            System.out.println("Digite o Titulo da musica: ");
            String titulo = sc.nextLine();                          //Da pra fazer esse processo 3x
            VailidadorDeEntidade.validarTitulo(titulo); //alterar se usar

            System.out.println("Digite o Album: ");
            String album = sc.nextLine();                          //Da pra fazer esse processo 3x
            VailidadorDeEntidade.validarAlbum(album); //alterar se usar

            System.out.println("Digite a Duração (em minutos): ");
            int duracao = sc.nextInt();                          //Da pra fazer esse processo 3x
            VailidadorDeEntidade.validarDuracao(duracao); //alterar se usar

            Musica musica = new Musica(id, titulo, album, duracao);
            adicionar(musica);

            System.out.println("Musica cadastrada com sucesso! ");

        }catch (Exception e){
            System.out.println("Erro:" + e.getMessage());
        }




    }


}
