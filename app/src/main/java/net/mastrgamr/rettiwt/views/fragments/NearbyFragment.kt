package net.mastrgamr.rettiwt.views.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.mastrgamr.rettiwt.R
import net.mastrgamr.rettiwt.databinding.FragmentNearbyBinding
import net.mastrgamr.rettiwt.viewmodels.NearbyFragmentViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [YouFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NearbyFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null

    private var binding: FragmentNearbyBinding? = null
    private var nearbyFragmentVM: NearbyFragmentViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout and attach the ViewModel for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nearby, container, false)
        val view: View = binding!!.root
        nearbyFragmentVM = NearbyFragmentViewModel(container!!.context)
        binding!!.vm = nearbyFragmentVM

        return view
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.

         * @param param1 Parameter 1.
         * *
         * @return A new instance of fragment YouFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String): NearbyFragment {
            val fragment = NearbyFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }

}
