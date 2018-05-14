package demo.teamwork.aquidigital.common.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import rx.Observable;
import rx.Single;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the View that can be
 * accessed from the children classes by calling getView().
 */
public abstract class BasePresenter<T extends View> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private T view;

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
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
        compositeDisposable.add(disposable);
    }

    private static class ViewNotAttachedException extends RuntimeException {
        ViewNotAttachedException() {
            super(
                    "Please call Presenter.attachView(View) before"
                            + " requesting data to the Presenter");
        }
    }
}
