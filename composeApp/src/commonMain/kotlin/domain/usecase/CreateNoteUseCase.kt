package domain.usecase

import data.repository.NoteRepository
import domain.model.Note
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CreateNoteUseCase : KoinComponent {
    private val noteRepository: NoteRepository by inject()
    suspend fun execute(note: Note) = noteRepository.createNote(note)
}