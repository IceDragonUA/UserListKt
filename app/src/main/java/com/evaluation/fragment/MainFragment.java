package com.evaluation.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.evaluation.adapter.CustomListAdapter;
import com.evaluation.dagger.data.DataComponent;
import com.evaluation.model.UserList;
import com.evaluation.network.RestAdapter;
import com.evaluation.userlist.MainActivity;
import com.evaluation.userlist.R;
import com.evaluation.viewmodel.PageViewModel;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Vladyslav Havrylenko
 * @since 09.03.2020
 */
public class MainFragment extends Fragment {

    private final String TAG = MainFragment.class.getCanonicalName();

    private PageViewModel mPageViewModel;

    private MainActivity mActivity;

    private View mRootView;

    @Inject
    RestAdapter mRestAdapter;

    @BindView(R.id.userList)
    RecyclerView mUserList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataComponent.Injector.getComponent().inject(this);
        mPageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.main_layout, container, false);
            ButterKnife.bind(this, mRootView);
            mUserList.setLayoutManager(new LinearLayoutManager(mActivity));
            loadList();
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    private void loadList() {
        mRestAdapter.getRestApiService().getUserList(100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<UserList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(UserList userList) {
                        CustomListAdapter adapter = new CustomListAdapter(
                                mActivity,
                                userList.getResultList(),
                                selectedItem -> mPageViewModel.setResult(selectedItem)
                        );
                        mUserList.setAdapter(adapter);
                        mPageViewModel.setResult(userList.getResultList().get(0));
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.e(TAG, "onError: " + throwable);
                    }
                });
    }
}
