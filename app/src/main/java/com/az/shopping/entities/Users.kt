package com.az.shopping.entities

import com.orm.SugarRecord
import com.orm.dsl.Unique

open class Users(
    @Unique val Name: String = "",
    val password: String = ""
) : SugarRecord()