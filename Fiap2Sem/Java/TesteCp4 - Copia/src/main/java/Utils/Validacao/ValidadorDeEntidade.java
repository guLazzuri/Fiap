package Utils.Validacao;

public class ValidadorDeEntidade { // escreve so um e fica copiando e colando
    public static void validarTitulo(String titulo) throws Exception{
        if (titulo == null || titulo.trim().isEmpty()){
            throw new Exception("O título não pode estar vazio");
        }
        if (titulo.length()> 100){
            throw new Exception("O titulo não pode ter mais de 100 careacteres ");
        }
    }

    public static void validarNomeDoArtista(String nome) throws Exception{
        if (nome == null || nome.trim().isEmpty()){
            throw new Exception("O nome do artista não pode estar vazio ");
        }
        if (nome.length() > 100){
            throw new Exception("O nome do artista não pode ter mais de 100  caracteres ");
        }
    }


    public static void validarAlbum(String album) throws Exception {
        if (album == null || album.trim().isEmpty()) {
            throw new Exception("O album não pode estar vazio");
        }
        if (album.length() > 100) {
            throw new Exception("O nome do album não pode ter mais de 100 caracteres");
        }
    }

    public static void validarGenero(String album) throws Exception {
        if (album == null || album.trim().isEmpty()) {
            throw new Exception("O genero não pode ter mais de 50 caracteres");
        }
        if (album.length() > 50) {
            throw new Exception("O genero não pode ter mais de 50 caracteres");
        }
    }
    public static void validarID (String id) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("O ID não pode estar vazio");
        }
        id =id.trim();
        if (!id.matches("\\d+")) {
            throw new Exception("O ID deve conter apenas caracteres numéricos");
        }
        if (id.length() < 1 || id.length() > 10) {
            throw new Exception("O ID deve ter entre 1 e 10 digitos");
        }
    }

    public static void validarAnoDoAlbum (int ano) throws Exception {
         String anos = String.valueOf(ano);
        if (anos == null || anos.trim().isEmpty()){
            throw new Exception("O ano de lançamento não pode estar vazio");
        }
        try{
            int anoDeLancamento = Integer.parseInt(anos);
            if (anoDeLancamento < 1900 || anoDeLancamento > 2100){
                throw new Exception("O ano deve estar entre 1900 e 2100");
            }
        }catch (NumberFormatException e){
            throw new Exception("O ano deve ser um valor numérico");
        }
    }
    public static void validarDuracao(int duracao) throws Exception {
        if (duracao <= 0) {
            throw new Exception("A duração deve ser positiva");
        }
        if (duracao > 3600) {
            throw new Exception("A duração não pode exceder 3600 minutos (60 horas)");
        }
    }
}