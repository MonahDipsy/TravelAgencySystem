package com.github.stephenwanjala.auth.domain.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId


data class User(
    @BsonId
    val id: ObjectId = ObjectId(),
    val userName: String,
    val email: String,
    val password: String,
    val phoneNumber : String,
    val fullName:String?=null,
    val salt: String,
    val role: UserRole

)
