package spartar;

public interface Parser<T> {
    T parse(String s) throws RuntimeException;
}
