package src.com.endava.tasks.TaskOoP;

public abstract class MessageProcessor implements Message {

    private String name;
    private String body;

    public MessageProcessor(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public abstract void prepareMessage();

    public abstract void prepareMessage(String s);

    public abstract void prepareMessage(String s1, String s2);


}
