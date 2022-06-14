package hunseong.com.post_practice.screen.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import hunseong.com.post_practice.databinding.FragmentUserBinding
import hunseong.com.post_practice.di.ViewModelFactory
import hunseong.com.post_practice.screen.detail.DetailFragment
import hunseong.com.post_practice.screen.detail.UserItem
import javax.inject.Inject

class UserFragment : DaggerFragment() {

    private lateinit var binding: FragmentUserBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)

        if (savedInstanceState == null) {
            val user = arguments?.getParcelable<UserItem>(DetailFragment.USERID_KEY)
            userViewModel.setUser(user)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.userViewModel = userViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    companion object {
        const val TAG = "userFragment"
        fun newInstance(user: UserItem): UserFragment {
            val bundle = Bundle().apply {
                putParcelable(DetailFragment.USERID_KEY, user)
            }
            return UserFragment().apply {
                arguments = bundle
            }
        }
    }
}