package demo.teamwork.aquidigital.common.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the View that can be
 * accessed from the children classes by calling getView().
 */
public abstract class BasePresenter<T extends View> {

    protected final CompositeDisposable disposable = new CompositeDisposable();
    private T view;

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
        if (!disposable.isDisposed()) {
            disposable.clear();
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

    protected T getView() {
        return view;
    }

    protected void checkViewAttached() {
        if (!isViewAttached()) throw new ViewNotAttachedException();
    }

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
}
