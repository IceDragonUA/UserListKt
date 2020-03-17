package com.evaluation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.evaluation.adapter.CustomListAdapter
import com.evaluation.command.ICommand
import com.evaluation.dagger.data.DataComponent.Injector.component
import com.evaluation.model.UserList
import com.evaluation.model.result.Result
import com.evaluation.network.RestAdapter
import com.evaluation.userlist.MainActivity
import com.evaluation.userlist.R
import com.evaluation.viewmodel.PageViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Vladyslav Havrylenko
 * @since 09.03.2020
 */
class MainFragment : Fragment() {

    private val TAG = MainFragment::class.java.canonicalName

    lateinit var mPageViewModel: PageViewModel

    lateinit var mActivity: MainActivity

    private var mRootView: View? = null

    @Inject
    lateinit var mRestAdapter: RestAdapter

    @BindView(R.id.userList)
    lateinit var mUserList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        mPageViewModel = ViewModelProvider(requireActivity()).get(PageViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            val view = inflater.inflate(R.layout.main_layout, container, false)
            ButterKnife.bind(this, view)
            mRootView = view
            mUserList.layoutManager = LinearLayoutManager(activity)
            loadList()
        }
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mActivity = activity as MainActivity
    }

    @SuppressLint("CheckResult")
    private fun loadList() {
        mRestAdapter.restApiService.getUserList(100)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ userList ->
                val adapter = activity?.let {
                    CustomListAdapter(
                        it,
                        userList.resultList,
                        object : ICommand<Result> {
                            override fun execute(param: Result) {
                                mPageViewModel.setResult(param)
                            }
                        }
                    )
                }
                mUserList.adapter = adapter
                mPageViewModel.setResult(userList.resultList[0])
            },
                {throwable -> Log.e(TAG, "Loading Error", throwable)})
    }


}