package ru.anlyashenko.moviesapp.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import ru.anlyashenko.moviesapp.domain.FilmItemModel
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
) {

    fun loadUpcoming(): Flow<List<FilmItemModel>> = callbackFlow {
        val ref = firebaseDatabase.getReference("Upcoming")

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<FilmItemModel>()
                snapshot.children.forEach { child ->
                    child.getValue(FilmItemModel::class.java)?.let { list.add(it) }
                }
                trySend(list)
            }

            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }

        }

        ref.addValueEventListener(listener)
        awaitClose { ref.removeEventListener(listener) }
    }

    fun loadItems(): Flow<List<FilmItemModel>> = callbackFlow {
        val ref = firebaseDatabase.getReference("Items")

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull {
                    it.getValue(FilmItemModel::class.java)
                }
                trySend(list)
            }

            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }

        }

        ref.addValueEventListener(listener)
        awaitClose { ref.removeEventListener(listener) }
    }

}