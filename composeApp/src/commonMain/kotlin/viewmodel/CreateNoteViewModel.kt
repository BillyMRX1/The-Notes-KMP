package viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.Note
import domain.usecase.CreateNoteUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import util.getCurrentTimeAsLong

class CreateNoteViewModel : ViewModel(), KoinComponent {

    private val createNoteUseCase: CreateNoteUseCase by inject()

    private val _isNoteValid = mutableStateOf(false)
    val isNoteValid = _isNoteValid

    private val _noteId = mutableStateOf(0L)
    val noteId = _noteId

    private val _title = mutableStateOf("")
    val title = _title

    private val _createdAt = mutableStateOf(0L)
    val createdAt = _createdAt

    private val _body = mutableStateOf("")
    val body = _body

    private val _isNoteSaved = mutableStateOf(false)
    val isNoteSaved = _isNoteSaved

    init {
        getCurrentTime()
    }

    private fun getCurrentTime() {
        val currentTime = getCurrentTimeAsLong()
        _createdAt.value = currentTime
    }

    fun setTitle(title: String) {
        _title.value = title
        checkNoteValidation()
    }

    fun setBody(body: String) {
        _body.value = body
        checkNoteValidation()
    }

    private fun checkNoteValidation() {
        _isNoteValid.value = _title.value.isEmpty().not() or _body.value.isEmpty().not()
    }

    fun saveNotes() = viewModelScope.launch {
        val currentTime = getCurrentTimeAsLong()
        val note = Note(
            title = _title.value.trim(),
            content = _body.value.trim(),
            createdAt = currentTime,
            updatedAt = currentTime
        )
        createNoteUseCase.execute(note)
        isNoteSaved.value = true
    }

    fun populateDataFromLocal(note: Note) = viewModelScope.launch {
//        try {
//            _noteId.value = note.id
//            _title.value = note.title
//            _body.value = note.content
//            _createdAt.value = note.createdAt
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
    }
}