package ir.coursio.realmnote.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jakewharton.rxbinding2.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.realm.RealmResults;
import ir.coursio.realmnote.R;
import ir.coursio.realmnote.model.structures.NoteStruct;
import ir.coursio.realmnote.view.adapter.NoteAdapter;
import ir.coursio.realmnote.view.dialog.GetNoteDialog;

/**
 * Created by Taher on 05/05/2017.
 * Project: RealmNote
 */

@SuppressLint("ViewConstructor")
public class NoteView extends FrameLayout {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.fabAddNote)
    FloatingActionButton addFolder;

    @BindView(R.id.mainLayout)
    ViewGroup mainLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    FragmentManager fragmentManager;

    public NoteView(@NonNull Activity activity) {
        super(activity);
        inflate(getContext(), R.layout.activity_note, this);
        ButterKnife.bind(this);
        fragmentManager = activity.getFragmentManager();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        toolbar.setTitle(R.string.toolbar_main);
        toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.toolbarTitle));
    }

    public Observable<Object> observeAddFolder() {
        return RxView.clicks(addFolder);
    }

    public void showMessage(String message) {
        Snackbar.make(mainLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    public void setAdapter(NoteAdapter mAdapter) {
        recyclerView.setAdapter(mAdapter);
    }

    public void updateList(NoteAdapter mAdapter, RealmResults<NoteStruct> mNoteList) {
        mAdapter.SwapData(mNoteList);
    }

    public Observable<NoteStruct> folderNameDialog() {
        return Observable.create(subscriber -> {
            GetNoteDialog dialog = GetNoteDialog.newInstance();
            dialog.show(fragmentManager, "test");

        });
    }
}
