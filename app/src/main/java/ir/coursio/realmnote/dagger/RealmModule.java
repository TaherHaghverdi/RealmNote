package ir.coursio.realmnote.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */

@Module(includes = ContextModule.class)
public class RealmModule {
    @Provides
    @AppplicationScope
    public Realm realm(Context context) {
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder().
                name("note_db")
                .build();
        Realm.setDefaultConfiguration(config);

        return Realm.getDefaultInstance();
    }

}
