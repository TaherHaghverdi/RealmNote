package ir.coursio.realmnote.view.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.coursio.realmnote.R;

/**
 * Created by Taher on 05/05/2017.
 * Project: RealmNote
 */

public class GetNoteDialog extends DialogFragment {

    @BindView(R.id.edtNoteTitle)
     EditText edtTitle;

    @BindView(R.id.edtNoteText)
    EditText edtText;

    public GetNoteDialog() {
    }

    public static GetNoteDialog newInstance() {
        return new GetNoteDialog();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_get_note, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        edtTitle.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }


}
