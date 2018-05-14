package demo.teamwork.aquidigital.util.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class InfiniteScrollListener extends RecyclerView.OnScrollListener {
  private final int maxItemsPerRequest;
  private final LinearLayoutManager layoutManager;


  public InfiniteScrollListener(int maxItemsPerRequest, LinearLayoutManager layoutManager) {
    this.maxItemsPerRequest = maxItemsPerRequest;
    this.layoutManager = layoutManager;
  }

  @Override
  public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    super.onScrolled(recyclerView, dx, dy);
    if (canLoadMoreItems()) {
      onScrolledToEnd(layoutManager.findFirstVisibleItemPosition());
    }
  }

  protected void refreshView(RecyclerView view, RecyclerView.Adapter adapter, int position) {
    view.setAdapter(adapter);
    view.invalidate();
    view.scrollToPosition(position);
  }


  protected boolean canLoadMoreItems() {
    final int visibleItemsCount = layoutManager.getChildCount();
    final int totalItemsCount = layoutManager.getItemCount();
    final int pastVisibleItemsCount = layoutManager.findFirstVisibleItemPosition();
    final boolean lastItemShown = visibleItemsCount + pastVisibleItemsCount >= totalItemsCount;
    return lastItemShown && totalItemsCount >= maxItemsPerRequest;
  }

  public abstract void onScrolledToEnd(final int firstVisibleItemPosition);
}
