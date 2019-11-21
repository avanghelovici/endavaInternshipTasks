package TaskOoP;


import static TaskOoP.JsonMessage.JSON_MESSAGE;
import static TaskOoP.XmlMessage.XML_MESSAGE;

public class Main {
    public static void main(String[] args) {
        MessageProcessor Xml = new XmlMessage("This message is Xml format originally");
        MessageProcessor Docx = new DocxMessage("This message is Docx format originally");

        Docx.prepareMessage();
        Docx.prepareMessage("Comment");
        Docx.prepareMessage("Comment1", "Comment2");

        Xml.prepareMessage();
        Xml.prepareMessage("Comment");
        Xml.prepareMessage("Comment1", "Comment2");

        MessageProcessor messageChanged = MessageConverter.convertMessage(Xml, JSON_MESSAGE);
        messageChanged.prepareMessage();

        MessageProcessor messageChangged2 = MessageConverter.convertMessage(Docx, XML_MESSAGE);
        messageChangged2.prepareMessage();


    }
}
