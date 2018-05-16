package demo.teamwork.aquidigital.common.base;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import demo.teamwork.aquidigital.util.ui.Item;

/**
 * Base class for recycler view adapters.
 *
 * @param <I>
 * @param <V>
 */
public abstract class BaseAdapter<I extends Item, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    protected List<I> data;

    protected Listener listener;

    protected BaseAdapter() {
        data = new ArrayList<>();
    }

    public void setData(List<I> data) {
        this.data = data;

        if (hasObservers()) {
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickedListener(Listener<I> onItemClickedListener) {
        this.listener = onItemClickedListener;
    }

    protected void onItemClicked(int position) {

        if (listener != null) {
            if (getItem(position) instanceof Item) {
                listener.onItemClicked(data.get(position));
            }
        }
    }

    protected Object getItem(int position) {
        return data.get(position);
    }

    protected void clearData() {
        data.clear();
    }

    @Override
    public int getItemCount() {
        return (data == null) ? 0 : data.size();
    }

    public interface Listener<I> {
        void onItemClicked(I item);
    }
}
