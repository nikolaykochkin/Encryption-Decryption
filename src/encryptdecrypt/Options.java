
package encryptdecrypt;

class Options {

    private String mode = "enc";
    private int key = 0;
    private String data = "";
    private String inputFileName = "";
    private String outputFileName = "";
    private String algorithm = "shift";

    public Options(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    this.mode = args[i + 1];
                    break;
                case "-key":
                    this.key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    this.data = args[i + 1];
                    break;
                case "-out":
                    this.outputFileName = args[i + 1];
                    break;
                case "-in":
                    this.inputFileName = args[i + 1];
                    break;
                case "-alg":
                    this.algorithm = args[i + 1];
                    break;
            }
        }
    }

    public String getMode() {
        return mode;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public String getAlgorithm() {
        return algorithm;
    }

}