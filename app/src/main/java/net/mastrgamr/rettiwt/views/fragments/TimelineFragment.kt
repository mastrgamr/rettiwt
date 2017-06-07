package net.mastrgamr.rettiwt.views.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twitter.sdk.android.core.models.Tweet
import net.mastrgamr.rettiwt.R
import net.mastrgamr.rettiwt.adapters.TimelineAdapter
import net.mastrgamr.rettiwt.databinding.FragmentTimelineBinding
import net.mastrgamr.rettiwt.viewmodels.TimelineFragmentViewModel

/**
 * A simple [Fragment] subclass.
 *
 * Use the [TimelineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TimelineFragment : Fragment(), TimelineFragmentViewModel.TimelineRefreshListener {

    private var text: String? = null

    private var binding: FragmentTimelineBinding? = null
    private var timelineFragmentVM: TimelineFragmentViewModel? = null

    private var timelineAdapter = TimelineAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            text = arguments.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout and attach the ViewModel for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_timeline, container, false)
        val view: View = binding!!.root
        timelineFragmentVM = TimelineFragmentViewModel(this)
        binding!!.vm = timelineFragmentVM

        binding!!.timelineRecview.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            // specify an adapter (see also next example)
            timelineFragmentVM!!.getTweets()
            adapter = timelineAdapter
        }
        return view
    }

    override fun onTimelineRefresh(tweets: List<Tweet>) {
        timelineAdapter.updateItems(tweets)
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * *
         * @return A new instance of fragment MainFragment.
         */
        fun newInstance(param1: String): TimelineFragment {
            val fragment = TimelineFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}
