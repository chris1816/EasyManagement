package com.example.cln62.easymanagement.data.pojo.projectpojo


import com.google.gson.annotations.SerializedName


data class ProjectList(

	@field:SerializedName("projects")
	val projects: List<ProjectsItem?>? = null
)