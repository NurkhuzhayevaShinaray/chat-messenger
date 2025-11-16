package visitor;

import Classes.Message;

public interface MessageVisitor {
    void visitText(Message m);
    void visitVoice(Message m);
    void visitTranslated(Message m);
    void visitExpiring(Message m);
}
