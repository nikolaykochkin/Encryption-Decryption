
package encryptdecrypt;

abstract class CryptFactory {
    public static Crypt newCrypt(Options options) {
        switch (options.getAlgorithm()) {
            case "unicode":
                return new UnicodeCrypt(options);
            case "shift":
                return new ShiftCrypt(options);
            default:
                return null;
        }
    }
}