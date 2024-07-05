package viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.Note
import domain.usecase.DeleteNoteUseCase
import domain.usecase.GetAllNotesUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {
    private val getAllNotesUseCase: GetAllNotesUseCase by inject()
    private val deleteNoteUseCase: DeleteNoteUseCase by inject()

    private val _allNotes = mutableStateOf(listOf<Note>())
    val allNotes = _allNotes

    private val _showDialog = mutableStateOf(false)
    val showDialog = _showDialog

    private val _noteId = mutableStateOf(0L)
    val noteId = _noteId

    fun getAllNotes() = viewModelScope.launch {
        try {
            _allNotes.value = getAllNotesUseCase.execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun deleteNotes(noteId: Long) = viewModelScope.launch {
        _showDialog.value = false
        try {
            deleteNoteUseCase.execute(noteId)
            _noteId.value = 0
            _allNotes.value = getAllNotesUseCase.execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun showAlertDialog(noteId: Long) {
        _noteId.value = noteId
        _showDialog.value = true
    }

    fun dismissAlertDialog() {
        _noteId.value = 0
        _showDialog.value = false
    }
}