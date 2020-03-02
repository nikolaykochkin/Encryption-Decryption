
package encryptdecrypt;

class UnicodeCrypt extends Crypt {

    public UnicodeCrypt(Options options) {
        super(options);
    }

    @Override
    void encrypt() {

        char[] messageAsArray = message.toCharArray();

        final StringBuilder finalMessage = new StringBuilder();
        boolean isValidCharacter;

        for (char characterInMessage : messageAsArray) {

            isValidCharacter = characterInMessage >= 32 && characterInMessage <= 126;

            if (isValidCharacter) {

                int encryptedCharValue = (int) (characterInMessage + Math.ceil(options.getKey() % 94));

                if (encryptedCharValue > 126) {

                    encryptedCharValue = encryptedCharValue - 126 + 31;
                }

                finalMessage.append((char) encryptedCharValue);

            } else {
                finalMessage.append(characterInMessage);
            }
        }

        processedMessage = finalMessage.toString();
    }

    @Override
    void decrypt() {

        char[] messageAsArray = message.toCharArray();

        final StringBuilder finalMessage = new StringBuilder();
        boolean isValidCharacter;

        for (char characterInMessage : messageAsArray) {
            isValidCharacter = characterInMessage >= 32 && characterInMessage <= 126;

            if (isValidCharacter) {

                int decryptedCharValue = (int) (characterInMessage - Math.ceil(options.getKey() % 94));

                if (decryptedCharValue > 126) {

                    decryptedCharValue = decryptedCharValue + 126 - 31;
                }

                finalMessage.append((char) decryptedCharValue);

            } else {
                finalMessage.append(characterInMessage);
            }
        }

        processedMessage = finalMessage.toString();
    }

}