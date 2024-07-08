package di

import data.datasource.NoteLocalDataSource
import data.datasource.NoteLocalDataSourceImpl
import data.repository.NoteRepository
import data.repository.NoteRepositoryImpl
import domain.usecase.CreateNoteUseCase
import domain.usecase.GetAllNotesUseCase
import domain.usecase.DeleteNoteUseCase
import domain.usecase.UpdateNoteUseCase
import domain.usecase.GetNoteUseCase
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module
import viewmodel.CreateNoteViewModel
import viewmodel.HomeViewModel

expect fun platformModule(): Module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            provideDataSourceModule, provideRepositoryModule, provideUseCaseModule,
            provideViewModelModule, platformModule()
        )
    }

val provideDataSourceModule = module {
    singleOf(::NoteLocalDataSourceImpl).bind(NoteLocalDataSource::class)
}

val provideRepositoryModule = module {
    singleOf(::NoteRepositoryImpl).bind(NoteRepository::class)
}

val provideUseCaseModule = module {
    singleOf(::CreateNoteUseCase)
    singleOf(::GetAllNotesUseCase)
    singleOf(::DeleteNoteUseCase)
    singleOf(::UpdateNoteUseCase)
    singleOf(::GetNoteUseCase)
}

val provideViewModelModule = module {
    viewModelOf(::CreateNoteViewModel)
    viewModelOf(::HomeViewModel)
}