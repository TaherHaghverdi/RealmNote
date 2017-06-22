package ir.coursio.realmnote.dagger.note;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import ir.coursio.realmnote.model.NoteModel;
import ir.coursio.realmnote.presenter.NotePresenter;
import ir.coursio.realmnote.view.NoteView;
import ir.coursio.realmnote.view.adapter.FolderAdapter;
import ir.coursio.realmnote.view.adapter.NoteAdapter;

/**
 * Created by Taher on 05/05/2017.
 * Project: RealmNote
 */

@Module
public class NoteActivityModule {
    private final Activity activity;

    public NoteActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @NoteActivityScope
    public NoteView view() {
        return new NoteView(activity);
    }


    @Provides
    @NoteActivityScope
    public NoteModel model(Realm realm) {
        return new NoteModel(activity, realm);
    }

    @Provides
    @NoteActivityScope
    public NotePresenter presenter(NoteView noteView, NoteModel noteModel, NoteAdapter noteAdapter) {
        return new NotePresenter(noteView, noteModel,noteAdapter);
    }


    @Provides
    @NoteActivityScope
    public NoteAdapter adapter() {
        return new NoteAdapter(activity);
    }
}
