package library.validator;

/**
 * Created by mi on 12.10.2016.
 */
public interface Validator<T> {


    boolean isValid(T in);

}
