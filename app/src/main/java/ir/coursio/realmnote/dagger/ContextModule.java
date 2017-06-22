package ir.coursio.realmnote.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */
@Module
public class ContextModule {
    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @AppplicationScope
    public Context context() {
        return context;
    }
}
