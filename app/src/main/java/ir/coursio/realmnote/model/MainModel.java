package ir.coursio.realmnote.model;

import android.app.Activity;

import io.realm.Realm;
import io.realm.RealmResults;
import ir.coursio.realmnote.model.structures.FolderStruct;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */

public class MainModel {
    private final Activity activity;
    private final Realm realm;

    public MainModel(Activity activity, Realm realm) {
        this.activity = activity;
        this.realm = realm;
    }

    public int addFolder(String name) {
        realm.beginTransaction();
        int nextId = realm.where(FolderStruct.class).findAll().size() + 1;
        FolderStruct folder = realm.createObject(FolderStruct.class, nextId);
        folder.setName(name);
        realm.commitTransaction();
        return folder.getId();
    }

    public RealmResults<FolderStruct> getFolders() {
        return realm.where(FolderStruct.class).findAll();
    }

}
