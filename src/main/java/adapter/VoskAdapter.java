package adapter;

public class VoskAdapter implements Speech{
    private VoskLibrary voskLibrary = new VoskLibrary("src/main/resources/vosk-model-small-en-us-0.15/vosk-model-small-en-us-0.15");

    @Override
    public String recognize() {
        return voskLibrary.recognize();
    }
}

