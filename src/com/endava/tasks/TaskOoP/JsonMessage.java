package TaskOoP;

public class JsonMessage extends MessageProcessor {

    public static final String JSON_MESSAGE = "JsonMessage";

    public JsonMessage(String body) {

        super(JSON_MESSAGE, body);
    }

    @Override
    public void prepareMessage() {
        System.out.println("Name: " + JSON_MESSAGE + "\nbody: " + getBody());
    }

    public void prepareMessage(String comment) {
        System.out.println("Name: " + JSON_MESSAGE + "\nbody: " + comment);
    }

    public void prepareMessage(String comment1, String comment2) {
        System.out.println("Name: " + JSON_MESSAGE + "\nbody: " + getBody() + "\nmessages: " + comment1 + ", " + comment2);
    }
}