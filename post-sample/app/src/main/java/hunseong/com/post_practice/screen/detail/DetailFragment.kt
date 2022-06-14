package hunseong.com.post_practice.screen.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import hunseong.com.post_practice.databinding.FragmentDetailBinding
import hunseong.com.post_practice.di.ViewModelFactory
import hunseong.com.post_practice.screen.main.MainActivity
import hunseong.com.post_practice.screen.post.PostFragment
import hunseong.com.post_practice.screen.post.PostItem
import hunseong.com.post_practice.screen.user.UserFragment
import hunseong.com.post_practice.util.adapter.BaseAdapter
import javax.inject.Inject

class DetailFragment : DaggerFragment() {

    private lateinit var binding: FragmentDetailBinding

    private lateinit var adapter: BaseAdapter<DetailItem>

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailViewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
        if (savedInstanceState == null) {
            val post = arguments?.getParcelable<PostItem>(PostFragment.POST_KEY)
            detailViewModel.loadData(post)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeData()
    }

    private fun initViews() {
        if (::adapter.isInitialized.not()) {
            adapter = BaseAdapter(emptyList(), object : UserListener {
                override fun onUserClick(user: UserItem) {
                    (requireActivity() as MainActivity).showFragment(UserFragment.newInstance(user),
                        UserFragment.TAG)
                }

            })
            binding.detailRecyclerView.adapter = adapter
        }
        binding.lifecycleOwner = viewLifecycleOwner
        binding.detailViewModel = detailViewModel
    }

    private fun observeData() {
        detailViewModel.detailItems.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {
        const val TAG = "detailFragment"
        const val USERID_KEY = "user_id_key"
        fun newInstance(post: PostItem): DetailFragment {
            val bundle = Bundle().apply {
                putParcelable(PostFragment.POST_KEY, post)
            }

            return DetailFragment().apply {
                arguments = bundle
            }
        }
    }
}