/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Custom.mytextfield;

/**
 *
 * @author Admin
 */
public class DataSearch {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isStory() {
        return story;
    }

    public void setStory(boolean story) {
        this.story = story;
    }

    public DataSearch(int id,String text, boolean story) {
        this.ID=id;
        this.text = text;
        this.story = story;
    }

    public DataSearch() {
    }

    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    private String text;
    private boolean story;
}
