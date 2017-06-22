package ir.coursio.realmnote;

import android.os.Bundle;


import javax.inject.Inject;

import ir.coursio.realmnote.dagger.main.DaggerMainActivityComponent;
import ir.coursio.realmnote.dagger.main.MainActivityModule;
import ir.coursio.realmnote.presenter.MainPresenter;
import ir.coursio.realmnote.view.MainView;

public class MainActivity extends BaseActivity {

    @Inject
    MainView view;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainActivityComponent.builder()
                .applicationComponent(RealmNoteApplication.get(this).component())
                .mainActivityModule(new MainActivityModule(this))
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
