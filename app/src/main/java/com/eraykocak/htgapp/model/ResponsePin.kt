package com.eraykocak.htgapp.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class ResponsePin(){
	@SerializedName("p1")
	val p1: Boolean? = null

	@SerializedName("p2")
	val p2: Boolean? = null

	@SerializedName("p3")
	val p3: Boolean? = null

	@SerializedName("p4")
	val p4: Boolean? = null
}



