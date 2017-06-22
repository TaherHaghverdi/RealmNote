package ir.coursio.realmnote;

import android.os.Bundle;

import javax.inject.Inject;

import ir.coursio.realmnote.dagger.note.DaggerNoteActivityComponent;
import ir.coursio.realmnote.dagger.note.NoteActivityModule;
import ir.coursio.realmnote.presenter.NotePresenter;
import ir.coursio.realmnote.view.NoteView;

/**
 * Created by Taher on 05/05/2017.
 * Project: RealmNote
 */

public class NoteActivity extends BaseActivity {

    @Inject
    NoteView view;

    @Inject
    NotePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerNoteActivityComponent.builder()
                .applicationComponent(RealmNoteApplication.get(this).component())
                .noteActivityModule(new NoteActivityModule(this))
                .build().inject(this);

        setContentView(view);
        presenter.onCreate();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
