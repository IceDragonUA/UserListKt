package com.evaluation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.evaluation.userlist.MainActivity;
import com.evaluation.userlist.R;
import com.evaluation.utils.StringUtils;
import com.evaluation.viewmodel.PageViewModel;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Vladyslav Havrylenko
 * @since 09.03.2020
 */
public class DetailFragment extends Fragment {

    public final String TAG = DetailFragment.class.getCanonicalName();

    private PageViewModel mPageViewModel;

    private MainActivity mActivity;

    private View mRootView;

    @BindView(R.id.picture)
    ImageView mPictureView;

    @BindView(R.id.gender)
    TextView mGenderView;

    @BindView(R.id.name)
    TextView mNameView;

    @BindView(R.id.location)
    TextView mLocationView;

    @BindView(R.id.email)
    TextView mEmailView;

    @BindView(R.id.phone)
    TextView mPhoneView;

    @BindView(R.id.dob)
    TextView mDobView;

    @BindView(R.id.nat)
    TextView mNatView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.info_layout, container, false);
            ButterKnife.bind(this, mRootView);
            loadInfo();
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    private void loadInfo() {
        mPageViewModel.getResult().observe(requireActivity(), result -> {
            Glide.with(mActivity)
                    .load(result.getPicture().getLarge())
                    .into(mPictureView);

            String firstLastName = result.getName().getTitle() +
                    StringUtils.DOT_STRING +
                    StringUtils.BLANK_STRING +
                    result.getName().getFirst() +
                    StringUtils.BLANK_STRING +
                    result.getName().getLast();

            mGenderView.setText(result.getGender().toUpperCase());
            mNameView.setText(firstLastName);

            String address = result.getLocation().getCountry() +
                    StringUtils.COMMA_STRING +
                    StringUtils.BLANK_STRING +
                    result.getLocation().getCity() +
                    StringUtils.COMMA_STRING +
                    StringUtils.BLANK_STRING +
                    result.getLocation().getStreet().getName() +
                    StringUtils.BLANK_STRING +
                    result.getLocation().getStreet().getNumber();

            mLocationView.setText(address);
            mEmailView.setText(result.getEmail());
            mPhoneView.setText(result.getPhone());

            String birthday = result.getDob().getDate() +
                    StringUtils.COMMA_STRING +
                    StringUtils.BLANK_STRING +
                    result.getDob().getAge();

            mDobView.setText(birthday);
            mNatView.setText(result.getNat());

        });
    }
}
