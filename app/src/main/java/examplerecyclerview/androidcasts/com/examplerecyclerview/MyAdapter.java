package examplerecyclerview.androidcasts.com.examplerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {

    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private String mItem;
        private TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            mTextView = (TextView) view.findViewById(android.R.id.text1);
        }

        public void setItem(String item) {
            mItem = item;
            mTextView.setText(item);
        }

        @Override
        public void onClick(View view) {
            //Log.d(TAG, "onClick " + getPosition() + " " + mItem);
        }
    }

    private ArrayList<String> mDataset;

    public MyAdapter(ArrayList<String> dataset) {
        mDataset = dataset;
    }

    public void add(String item) {
        mDataset.add(item);
        notifyItemInserted(mDataset.size());
    }

    public void add(String item, int position) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(int position) {
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}