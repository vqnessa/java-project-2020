package TemplateCreation.Logic;

/**
 * Template Creation Story Template
 * @author Melissa Chan
 * @version 11.11.2020
 * creates the template
 */
public class Template {
    private String name;
    private String tags;
    private String subject;
    private String body;

    /**
     *
     * @param n string name
     * @param t string tag
     * @param s string subject
     * @param b string body
     */
    public Template(String n, String t, String s, String b) {
        name = n;
        tags = t;
        subject = s;
        body = b;
    }

    /**
     * field parameters for name, subject and body
     * @param name  string name parameter
     * @param subject string subject parameter
     * @param body string body parameter
     */
    public Template(String name, String subject, String body) {
        this.name = name;
        this.subject = subject;
        this.body = body;
    }

    /**
     * gets the name, tags, subject and body
     * @return name, tag, subject, body
     */
    public String getName(){
        return name;
    }
    public String getTags(){
        return tags;
    }
    public String getSubject(){
        return subject;
    }
    public String getBody(){
        return body;
    }
}



