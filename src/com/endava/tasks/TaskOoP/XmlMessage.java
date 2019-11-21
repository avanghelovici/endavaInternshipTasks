package TaskOoP;


public class XmlMessage extends MessageProcessor {

    protected static final String XML_MESSAGE = "XmlMessage";

    public XmlMessage(String body) {
        super(XML_MESSAGE, body);
    }

    @Override
    public void prepareMessage() {
        System.out.println("Name: " + XML_MESSAGE + "\nbody: " + getBody());
    }

    public void prepareMessage(String comment) {
        System.out.println("Name: " + XML_MESSAGE + "\nbody: " + getBody() + "\nmessages: " + comment);
    }

    public void prepareMessage(String comment1, String comment2) {
        System.out.println("Name: " + XML_MESSAGE + "\nbody: " + getBody() + "\nmessages: " + comment1 + ", " + comment2);
    }
}
