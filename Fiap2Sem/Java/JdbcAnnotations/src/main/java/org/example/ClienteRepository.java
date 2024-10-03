package org.example;

public class ClienteRepository {

    public void Inserir(Cliente cliente){
        var query =
                "INSERT INTO "+cliente.getClass().getAnnotation(Table.class).name() + "(";
        //pra cada campo adicionar o restante da query
        for(var field : cliente.getClass().getDeclaredFields()){
            var column = field.getAnnotation(Column.class);
            if(column != null){
                query += column.name() + ",";
            }
        }
        query += ")";

        System.out.println(query);
    }
}
