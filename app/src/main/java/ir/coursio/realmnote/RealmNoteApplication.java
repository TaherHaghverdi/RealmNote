package ir.coursio.realmnote;

import android.app.Activity;
import android.app.Application;

import ir.coursio.realmnote.dagger.ApplicationComponent;
import ir.coursio.realmnote.dagger.ContextModule;
import ir.coursio.realmnote.dagger.DaggerApplicationComponent;
import timber.log.Timber;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */

public class RealmNoteApplication extends Application {

    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        component = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();


    }

    public ApplicationComponent component() {
        return component;
    }

    public static RealmNoteApplication get(Activity activity) {
        return (RealmNoteApplication) activity.getApplication();
    }
}
