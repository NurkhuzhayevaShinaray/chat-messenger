import adapter.VoskAdapter;
import decorator.VoiceRecorder;

public class VoskTest {
    public static void main(String[] args) {
        var vosk = new VoskAdapter();
        var recorder = new VoiceRecorder(vosk);
        String text = recorder.recording();

    }
}

