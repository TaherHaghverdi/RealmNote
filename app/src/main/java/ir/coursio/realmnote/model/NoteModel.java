package ir.coursio.realmnote.model;

import android.app.Activity;

import io.realm.Realm;
import io.realm.RealmResults;
import ir.coursio.realmnote.model.structures.NoteStruct;

/**
 * Created by Taher on 05/05/2017.
 * Project: RealmNote
 */

public class NoteModel {
    private final Activity activity;
    private final Realm realm;

    public NoteModel(Activity activity, Realm realm) {
        this.activity = activity;
        this.realm = realm;
    }


    public int addNote(NoteStruct mNote) {
        realm.beginTransaction();
        int nextId = realm.where(NoteStruct.class).findAll().size() + 1;
        NoteStruct note = realm.createObject(NoteStruct.class, nextId);
        note.setAttributes(mNote.getTitle(),mNote.getText(), mNote.getFolderId());
        realm.commitTransaction();
        return note.getId();
    }

    public RealmResults<NoteStruct> getFolders() {
        return realm.where(NoteStruct.class).findAll();
    }

}
