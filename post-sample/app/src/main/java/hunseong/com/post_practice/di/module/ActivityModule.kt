package hunseong.com.post_practice.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hunseong.com.post_practice.di.annotation.ActivityScope
import hunseong.com.post_practice.screen.main.MainActivity
import hunseong.com.post_practice.screen.main.MainModule

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity

}