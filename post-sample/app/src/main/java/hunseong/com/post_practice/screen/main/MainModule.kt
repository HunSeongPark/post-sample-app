package hunseong.com.post_practice.screen.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hunseong.com.post_practice.di.annotation.FragmentScope
import hunseong.com.post_practice.screen.detail.DetailFragment
import hunseong.com.post_practice.screen.my.MyFragment
import hunseong.com.post_practice.screen.post.PostFragment
import hunseong.com.post_practice.screen.user.UserFragment

@Module
abstract class MainModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun myFragment(): MyFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun postFragment(): PostFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun detailFragment(): DetailFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun userFragment(): UserFragment

}