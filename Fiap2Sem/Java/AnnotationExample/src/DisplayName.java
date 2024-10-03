import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Retention is used to specify how long annotations with the annotated type are to be retained.
// Runtime sigfica que a anotação será mantida em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
// O Target é usado para especificar onde a anotação pode ser aplicada
@Target(ElementType.FIELD)
public @interface DisplayName {
    String value();
}
