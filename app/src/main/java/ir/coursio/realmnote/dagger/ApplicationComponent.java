package ir.coursio.realmnote.dagger;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */
@Component(modules = RealmModule.class)
@AppplicationScope
public interface ApplicationComponent {
    Realm getRealm();
}
