package hunseong.com.post_practice.di.module

import dagger.Module
import dagger.Provides
import hunseong.com.post_practice.util.SingleLiveEvent
import javax.inject.Named
import javax.inject.Singleton

@Module
class ErrorEventModule {
    @Provides
    @Singleton
    @Named("errorEvent")
    fun provideErrorEvent(): SingleLiveEvent<Throwable> {
        return SingleLiveEvent()
    }
}