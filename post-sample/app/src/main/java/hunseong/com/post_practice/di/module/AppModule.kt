package hunseong.com.post_practice.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import hunseong.com.post_practice.App
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, RetrofitModule::class, ErrorEventModule::class])
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideAppication(application: App): Application

    @Binds
    @Singleton
    abstract fun provideContext(application: App): Context

}