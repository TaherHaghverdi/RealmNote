package ir.coursio.realmnote.dagger.main;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import ir.coursio.realmnote.model.MainModel;
import ir.coursio.realmnote.presenter.MainPresenter;
import ir.coursio.realmnote.view.MainView;
import ir.coursio.realmnote.view.adapter.FolderAdapter;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */

@Module
public class MainActivityModule {
    private final Activity activity;

    public MainActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @MainActivityScope
    public MainView view() {
        return new MainView(activity);
    }


    @Provides
    @MainActivityScope
    public MainModel model(Realm realm) {
        return new MainModel(activity, realm);
    }

    @Provides
    @MainActivityScope
    public MainPresenter presenter(MainView mainView, MainModel mainModel,FolderAdapter mAdapter) {
        return new MainPresenter(mainView, mainModel,mAdapter);
    }


    @Provides
    @MainActivityScope
    public FolderAdapter adapter() {
        return new FolderAdapter(activity);
    }


}
