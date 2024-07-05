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
import org.koin.dsl.module
import viewmodel.CreateNoteViewModel
import viewmodel.HomeViewModel

expect fun platformModule(): Module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            provideDataSourceModule, provideRepositoryModule, provideUseCaseModule,
            provideViewModelModule, platformModule()
        )
    }

val provideDataSourceModule = module {
    single<NoteLocalDataSource> { NoteLocalDataSourceImpl() }
}

val provideRepositoryModule = module {
    single<NoteRepository> { NoteRepositoryImpl() }
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