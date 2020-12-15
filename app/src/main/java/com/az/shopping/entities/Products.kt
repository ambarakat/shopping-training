package com.az.shopping.entities

import com.orm.SugarRecord
import com.orm.dsl.Unique

open class Products(
    @Unique
    val Name: String = "",
    val details: String = "",
    val cid: Long = 0
) : SugarRecord()