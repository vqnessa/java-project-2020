package SendNotification.Logic;

/**
 * STORY - Send Notification
 *
 * This class will act as the Template object
 * containing the Templates Name, Subject, and Message
 *
 * @author Johnny Perez
 * @version 2020.10.13
 */

public class TemplateData {
    private String templateName;
    private String templateSubject;
    private String templateMessage;

    public TemplateData(String name, String subject, String message) {
        templateName = name;
        templateSubject = subject;
        templateMessage = message;
    }
    public String getTemplateName() {
        return templateName;
    }

    public String getTemplateSubject() {
        return templateSubject;
    }

    public String getTemplateMessage() {
        return templateMessage;
    }
}
