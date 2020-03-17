package com.evaluation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.evaluation.model.result.Result
import com.evaluation.userlist.MainActivity
import com.evaluation.userlist.R
import com.evaluation.utils.StringUtils
import com.evaluation.viewmodel.PageViewModel

/**
 * @author Vladyslav Havrylenko
 * @since 09.03.2020
 */
class DetailFragment : Fragment() {

    val TAG = DetailFragment::class.java.canonicalName

    lateinit var mPageViewModel: PageViewModel

    lateinit var mActivity: MainActivity

    private var mRootView: View? = null

    @BindView(R.id.picture)
    lateinit var mPictureView: ImageView

    @BindView(R.id.gender)
    lateinit var mGenderView: TextView

    @BindView(R.id.name)
    lateinit var mNameView: TextView

    @BindView(R.id.location)
    lateinit var mLocationView: TextView

    @BindView(R.id.email)
    lateinit var mEmailView: TextView

    @BindView(R.id.phone)
    lateinit var mPhoneView: TextView

    @BindView(R.id.dob)
    lateinit var mDobView: TextView

    @BindView(R.id.nat)
    lateinit var mNatView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPageViewModel = ViewModelProvider(requireActivity()).get(PageViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            val view = inflater.inflate(R.layout.info_layout, container, false)
            ButterKnife.bind(this, view)
            mRootView = view
            loadInfo()
        }
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mActivity = activity as MainActivity
    }

    private fun loadInfo() {
        mPageViewModel.result.observe(
            requireActivity(),
            Observer { result: Result ->

                activity?.let {
                    Glide.with(it)
                        .load(result.picture.large)
                        .into(mPictureView)
                }

                val firstLastName = result.name.title +
                        StringUtils.DOT_STRING +
                        StringUtils.BLANK_STRING +
                        result.name.first +
                        StringUtils.BLANK_STRING +
                        result.name.last

                mGenderView.text = result.gender.toUpperCase()
                mNameView.text = firstLastName

                val address = result.location.country +
                        StringUtils.COMMA_STRING +
                        StringUtils.BLANK_STRING +
                        result.location.city +
                        StringUtils.COMMA_STRING +
                        StringUtils.BLANK_STRING +
                        result.location.street.name +
                        StringUtils.BLANK_STRING +
                        result.location.street.number

                mLocationView.text = address
                mEmailView.text = result.email
                mPhoneView.text = result.phone

                val birthday = result.dob.date +
                        StringUtils.COMMA_STRING +
                        StringUtils.BLANK_STRING +
                        result.dob.age

                mDobView.text = birthday
                mNatView.text = result.nat
            }
        )
    }
}