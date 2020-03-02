
package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        Options options = new Options(args);
        Crypt crypt = CryptFactory.newCrypt(options);
        if (crypt != null) {
            crypt.work();
        }
    }

}