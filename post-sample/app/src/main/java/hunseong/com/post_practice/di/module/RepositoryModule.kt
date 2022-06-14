package hunseong.com.post_practice.di.module

import dagger.Binds
import dagger.Module
import hunseong.com.post_practice.data.repository.CommentRepository
import hunseong.com.post_practice.data.repository.PostRepository
import hunseong.com.post_practice.data.repository.Repository
import hunseong.com.post_practice.data.repository.UserRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsPostRepository(repository: PostRepository): Repository

    @Binds
    @Singleton
    abstract fun bindsUserRepository(repository: UserRepository): Repository

    @Binds
    @Singleton
    abstract fun bindsCommentRepository(repository: CommentRepository): Repository
}