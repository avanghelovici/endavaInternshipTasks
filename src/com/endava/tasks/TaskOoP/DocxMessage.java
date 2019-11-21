package TaskOoP;

public class DocxMessage extends MessageProcessor {
    public static final String DOCX_MESSAGE = "DocxMessage";

    public DocxMessage(String body){
        super(DOCX_MESSAGE, body);
    }
    @Override
    public void prepareMessage() {
        System.out.println("Name: " + DOCX_MESSAGE + "\nbody: empty");
    }

    public void prepareMessage(String comment) {
        System.out.println("Name: " + DOCX_MESSAGE + "\nbody: " + comment);
    }

    public void prepareMessage(String comment1, String comment2){
        System.out.println("Name: " + DOCX_MESSAGE + "\nbody: "+ getBody() + "\nmessages: " + comment1 + ", " + comment2);
    }
}