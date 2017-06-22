package ir.coursio.realmnote.dagger.main;

import dagger.Component;
import ir.coursio.realmnote.MainActivity;
import ir.coursio.realmnote.dagger.ApplicationComponent;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */


@MainActivityScope
@Component(modules = MainActivityModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    public void inject(MainActivity mainActivity);
}
