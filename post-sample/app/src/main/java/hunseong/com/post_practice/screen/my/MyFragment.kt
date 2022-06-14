package hunseong.com.post_practice.screen.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import hunseong.com.post_practice.databinding.FragmentMyBinding

class MyFragment : DaggerFragment() {

    private lateinit var binding: FragmentMyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        const val TAG = "myFragment"
        fun newInstance() : MyFragment {
            return MyFragment()
        }
    }
}