package repositorios;

import entidades.Cupom;

import java.util.Objects;

public class CupomRepositorio extends _RepositorioBaseImpl<Cupom> {

        public void deletarPorCodigo(String codigo){
            var cupom = lista.stream().filter(c -> Objects.equals(c.getCodigo(), codigo)).findFirst();
            if(cupom.isEmpty())
                return;

            lista.remove(cupom.get());
        }
}
