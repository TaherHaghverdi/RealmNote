package ir.coursio.realmnote.view;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import ir.coursio.realmnote.model.structures.FolderStruct;
import ir.coursio.realmnote.view.adapter.FolderAdapter;

/**
 * Created by Taher on 03/05/2017.
 * Project: RealmNote
 */

@SuppressLint("ViewConstructor")
public class MainView extends FrameLayout {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.fabAddFolder)
    FloatingActionButton addFolder;

    @BindView(R.id.mainLayout)
    ViewGroup mainLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public MainView(@NonNull Activity activity) {
        super(activity);
        inflate(getContext(), R.layout.activity_main, this);
        ButterKnife.bind(this);

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

    public void setAdapter(FolderAdapter mAdapter) {
        recyclerView.setAdapter(mAdapter);
    }

    public void updateList(FolderAdapter mAdapter, RealmResults<FolderStruct> mFolderList) {
        mAdapter.SwapData(mFolderList);
    }

    public Observable<String> folderNameDialog() {
        return Observable.create(subscriber -> {
            new MaterialDialog.Builder(getContext())
                    .content(R.string.dialog_folder_name_message)
                    .inputRange(1, 20)
                    .inputType(InputType.TYPE_CLASS_TEXT)
                    .input(null, null, new MaterialDialog.InputCallback() {
                        @Override
                        public void onInput(MaterialDialog dialog, CharSequence input) {
                            subscriber.onNext(input.toString());
                            showMessage(input + " folder added");
                        }
                    })
                    .show();
        });
    }
}
