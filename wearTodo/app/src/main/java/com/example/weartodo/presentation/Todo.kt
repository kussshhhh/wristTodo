package com.example.weartodo.presentation

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey
    val id: String,
    val json: String // store the entire JSON object as a string
)
//{
//    "kind": string,
//    "id": string,
//    "etag": string,
//    "title": string,
//    "updated": string,
//    "selfLink": string,
//    "parent": string,
//    "position": string,
//    "notes": string,
//    "status": string,
//    "due": string,
//    "completed": string,
//    "deleted": boolean,
//    "hidden": boolean,
//    "links": [
//    {
//        "type": string,
//        "description": string,
//        "link": string
//    }
//    ],
//    "webViewLink": string
//}