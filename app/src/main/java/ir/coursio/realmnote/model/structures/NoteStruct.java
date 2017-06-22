package ir.coursio.realmnote.model.structures;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */

public class NoteStruct extends RealmObject {

    @PrimaryKey
    private int id;
    private String title;
    private String text;
    private int folderId;

    public NoteStruct() {
    }

    public void setAttributes(String title, String text, int folderId) {
        this.title = title;
        this.text = text;
        this.folderId = folderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }
}
