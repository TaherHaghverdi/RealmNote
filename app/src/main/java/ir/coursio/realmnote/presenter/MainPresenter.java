package ir.coursio.realmnote.presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ir.coursio.realmnote.model.MainModel;
import ir.coursio.realmnote.view.MainView;
import ir.coursio.realmnote.view.adapter.FolderAdapter;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */

public class MainPresenter {

    private final MainView view;
    private final MainModel model;
    private final FolderAdapter mAdapter;
    private final CompositeDisposable disposable = new CompositeDisposable();

    public MainPresenter(MainView view, MainModel model, FolderAdapter mAdapter) {
        this.view = view;
        this.model = model;
        this.mAdapter = mAdapter;
    }

    public void onCreate() {
        disposable.add(observeAddFolder());
        view.setAdapter(mAdapter);
        view.updateList(mAdapter, model.getFolders());
    }

    public void onDestroy() {
        disposable.clear();
    }

    private Disposable observeAddFolder() {
        return view.observeAddFolder()
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(__ -> view.folderNameDialog())
                .subscribe(new_name -> {
                    view.updateList(mAdapter, model.getFolders());
                    model.addFolder(new_name);
                });
    }

}
