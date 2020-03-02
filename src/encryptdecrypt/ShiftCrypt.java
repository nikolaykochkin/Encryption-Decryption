
package encryptdecrypt;

class ShiftCrypt extends Crypt {

    private int key;

    public ShiftCrypt(Options options) {
        super(options);
        key = options.getKey();
    }

    @Override
    void encrypt() {
        char[] messageAsArray = message.toCharArray();
        final StringBuilder finalMessage = new StringBuilder();
        for (char characterInMessage : messageAsArray) {
            if (Character.isLetter(characterInMessage)) {
                char offset = (Character.isLowerCase(characterInMessage) ? 'a' : 'A');
                int originalAlphabetPosition = characterInMessage - offset;
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                finalMessage.append((char) (offset + newAlphabetPosition));
            } else {
                finalMessage.append(characterInMessage);
            }
        }
        processedMessage = finalMessage.toString();
    }

    @Override
    void decrypt() {
        key = 26 - (key % 26);
        encrypt();
    }
}