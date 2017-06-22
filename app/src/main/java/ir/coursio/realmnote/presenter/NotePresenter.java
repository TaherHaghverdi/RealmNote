package ir.coursio.realmnote.presenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ir.coursio.realmnote.model.NoteModel;
import ir.coursio.realmnote.view.NoteView;
import ir.coursio.realmnote.view.adapter.NoteAdapter;

/**
 * Created by Taher on 05/05/2017.
 * Project: RealmNote
 */

public class NotePresenter {

    private final NoteView view;
    private final NoteModel model;
    private final NoteAdapter mAdapter;
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public NotePresenter(NoteView view, NoteModel model, NoteAdapter mAdapter) {
        this.view = view;
        this.model = model;
        this.mAdapter = mAdapter;
    }

    public void onCreate() {
        disposable.add(observeAddNote());
        view.setAdapter(mAdapter);
        view.updateList(mAdapter, model.getFolders());
    }

    public void onDestroy() {
        disposable.clear();
    }

    private Disposable observeAddNote() {
        return view.observeAddFolder()
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(__ -> view.folderNameDialog())
                .subscribe(new_name -> {
                    view.updateList(mAdapter, model.getFolders());
                    model.addNote(new_name);
                });
    }

}
