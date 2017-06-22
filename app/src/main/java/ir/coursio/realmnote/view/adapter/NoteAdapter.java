package ir.coursio.realmnote.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;
import ir.coursio.realmnote.R;
import ir.coursio.realmnote.model.structures.NoteStruct;

/**
 * Created by Taher on 05/05/2017.
 * Project: RealmNote
 */

public class NoteAdapter extends  RecyclerView.Adapter<NoteAdapter.ViewHolder>  {

    private Context mContext;
    private RealmResults<NoteStruct> mNoteList;

    public NoteAdapter(Activity mContext) {
        this.mContext = mContext;
    }

    public void SwapData(RealmResults<NoteStruct> mFolderList) {
        this.mNoteList = mFolderList;
        notifyDataSetChanged();
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_note, parent, false);
        return new NoteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder holder, int position) {
        if (mNoteList != null) {
            holder.txtNoteTitle.setText(mNoteList.get(position).getTitle());
        }
    }


    @Override
    public int getItemCount() {
        if (mNoteList != null)
            return mNoteList.size();
        else
            return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtNoteTitle)
        TextView txtNoteTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
