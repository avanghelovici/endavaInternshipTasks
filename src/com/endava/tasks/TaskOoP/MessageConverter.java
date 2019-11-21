package TaskOoP;


import static TaskOoP.DocxMessage.DOCX_MESSAGE;
import static TaskOoP.JsonMessage.JSON_MESSAGE;
import static TaskOoP.XmlMessage.XML_MESSAGE;

public class MessageConverter {


    public static MessageProcessor convertMessage(MessageProcessor messageProcessor, String typeName) {

        if (!typeName.equals(messageProcessor.getName())) {

            switch (typeName) {
                case XML_MESSAGE:
                    return new XmlMessage(messageProcessor.getBody());
                case JSON_MESSAGE:
                    return new JsonMessage(messageProcessor.getBody());
                case DOCX_MESSAGE:
                    return new DocxMessage(messageProcessor.getBody());
                default:
                    System.out.println("There is no such message format.");
                    return null;
            }
        } else {
            System.out.println("Already converted to the requested message type");
            return messageProcessor;
        }
    }
}

