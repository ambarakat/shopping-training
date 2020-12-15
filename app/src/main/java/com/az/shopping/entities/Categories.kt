package com.az.shopping.entities

import com.orm.SugarRecord
import com.orm.dsl.Unique

open class Categories (
    @Unique val Name: String = "",
    val details: String = ""
): SugarRecord()