package TemplateCreation.Presentation;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class TemplateCreationTest {
    @Test
    void getRootPanel(){
        TemplateCreation gui = new TemplateCreation();
        JPanel rootPanel = new JPanel();
        rootPanel = gui.getRootPanel();
        assertEquals(gui.getRootPanel(),rootPanel);
    }

    @Test
    void getName(){
        TemplateCreation gui = new TemplateCreation();
        assertEquals(gui.getName(),gui.getName());
    }
    @Test
    void getTags(){
        TemplateCreation gui = new TemplateCreation();
        assertEquals(gui.getTags(),gui.getTags());
    }
    @Test
    void getSubject(){
        TemplateCreation gui = new TemplateCreation();
        assertEquals(gui.getSubject(),gui.getSubject());
    }
    @Test
    void getBody(){
        TemplateCreation gui = new TemplateCreation();
        assertEquals(gui.getBody(),gui.getBody());
    }
}