package hunseong.com.post_practice.screen.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import hunseong.com.post_practice.databinding.FragmentPostBinding
import hunseong.com.post_practice.di.ViewModelFactory
import hunseong.com.post_practice.screen.detail.DetailFragment
import hunseong.com.post_practice.screen.main.MainActivity
import hunseong.com.post_practice.util.adapter.BaseAdapter
import javax.inject.Inject

class PostFragment : DaggerFragment() {

    private lateinit var binding: FragmentPostBinding

    private lateinit var adapter: BaseAdapter<PostItem>

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postViewModel = ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)

        if (savedInstanceState == null) {
            postViewModel.loadPost()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPostBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeData()
    }

    private fun initViews() {
        if (::adapter.isInitialized.not()) {
            adapter = BaseAdapter(listOf(), object : PostListener {
                override fun onPostClick(post: PostItem) {
                    (requireActivity() as MainActivity).showFragment(DetailFragment.newInstance(post),
                        DetailFragment.TAG)
                }
            })
            binding.postRecyclerView.adapter = adapter
        }
        binding.postViewModel = postViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun observeData() {
        postViewModel.items.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {
        const val TAG = "postFragment"
        const val POST_KEY = "post_key"
        fun newInstance(): PostFragment {
            return PostFragment()
        }
    }
}