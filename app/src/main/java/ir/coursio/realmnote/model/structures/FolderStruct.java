package ir.coursio.realmnote.model.structures;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */

public class FolderStruct extends RealmObject {
    @PrimaryKey
    int id;
    String name;

    public FolderStruct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
