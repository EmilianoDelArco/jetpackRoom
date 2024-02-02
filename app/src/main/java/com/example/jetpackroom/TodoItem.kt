package com.example.jetpackroom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackroom.db.Todo
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TodoItem(
    todo: Todo,
    onEditClick: (todo: Todo) -> Unit = {},
    onClick: (todo: Todo) -> Unit = {}
) {
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.JAPAN)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(2.dp, Color.Blue))
            .padding(32.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Texto del título
            Text(
                text = todo.title,
                modifier = Modifier.weight(1f)
                    .padding(bottom = 4.dp)
            )

            // Icono de lápiz para editar
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Editar",
                tint = Color.Gray,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onEditClick(todo)
                    }
            )

            // Icono de basura
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Eliminar",
                tint = Color.Red,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onClick(todo)
                    }
            )
        }

        Text(
            text = "${stringResource(id = R.string.todo_created_at)} ${sdf.format(todo.created_at)}",
            fontSize = 12.sp,
            textAlign = TextAlign.Right,
            modifier = Modifier.fillMaxWidth()

        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}