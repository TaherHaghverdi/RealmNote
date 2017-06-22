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
import ir.coursio.realmnote.model.structures.FolderStruct;

/**
 * Created by Taher on 05/05/2017.
 * Project: RealmNote
 */

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder>  {


    private Context mContext;
    private RealmResults<FolderStruct> mFolderList ;

    public FolderAdapter(Activity mContext) {
        this.mContext = mContext;
    }

    public void SwapData(RealmResults<FolderStruct> mFolderList) {
        this.mFolderList = mFolderList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_folder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mFolderList != null) {
            holder.txtFolderName.setText(mFolderList.get(position).getName());
        }
    }


    @Override
    public int getItemCount() {
        if (mFolderList != null)
            return mFolderList.size();
        else
            return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtFolderName)
        TextView txtFolderName;

         ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
