package demo.teamwork.aquidigital.util.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

import retrofit2.HttpException;

public class NetworkUtil {

    private final Context context;

    @Inject
    public NetworkUtil(Context context) {
        this.context = context;
    }

    /**
     * Returns true if the Throwable is an instance of RetrofitError with an http status code equals
     * to the given one.
     */
    public boolean isHttpStatusCode(Throwable throwable, int statusCode) {
        return throwable instanceof HttpException
                && ((HttpException) throwable).code() == statusCode;
    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
