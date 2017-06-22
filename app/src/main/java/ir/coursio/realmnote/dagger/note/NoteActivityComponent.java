package ir.coursio.realmnote.dagger.note;

import dagger.Component;
import ir.coursio.realmnote.NoteActivity;
import ir.coursio.realmnote.dagger.ApplicationComponent;

/**
 * Created by Taher on 05/05/2017.
 * Project: RealmNote
 */
@NoteActivityScope
@Component(modules = NoteActivityModule.class, dependencies = ApplicationComponent.class)
public interface NoteActivityComponent {
    public void inject(NoteActivity noteActivity);

}
