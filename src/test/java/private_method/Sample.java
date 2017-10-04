package private_method;

public interface Sample {

    // interfaceでprivateメソッドが定義できる
    private long id() {
        return 8263L;
    }

    // interfaceでstaticなprivateメソッドが定義できる
    private static String staticMethod() {
        return "999";
    }

    default long getId() {
        // defaultメソッドから呼び出せる
        return id();
    }

    default String s() {
        // こっちはあまり使い道わからない
        return Sample.staticMethod();
    }
}
