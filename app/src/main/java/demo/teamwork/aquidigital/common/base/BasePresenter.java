package demo.teamwork.aquidigital.common.base;

import java.util.List;

import demo.teamwork.aquidigital.repository.Item;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detach(). It also handles keeping a reference to the View that can be
 * accessed from the children classes by calling getView().
 */
public abstract class BasePresenter<I extends Item, T extends View> {

    protected final CompositeDisposable disposable = new CompositeDisposable();

    public void addDisposable(Disposable disposable) {
        this.disposable.add(disposable);
    }

    private static class ViewNotAttachedException extends RuntimeException {
        ViewNotAttachedException() {
            super(
                    "Please call Presenter.attachView(View) before"
                            + " requesting data to the Presenter");
        }
    }

    protected abstract void onSuccess(List<I> dataList);

    protected abstract void onError(Throwable throwable);

    public void detach() {
        if (!disposable.isDisposed()) {
            disposable.clear();
        }
    }
}
