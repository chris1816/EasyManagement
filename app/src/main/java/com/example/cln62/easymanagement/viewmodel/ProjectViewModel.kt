package com.example.cln62.easymanagement.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import com.example.cln62.easymanagement.BR
import com.example.cln62.easymanagement.data.DataManager
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.projectpojo.ProjectsItem

class ProjectViewModel: BaseObservable() {

    val dataManager: IDataManager = DataManager()
    var projectList: MutableList<ProjectsItem> = mutableListOf()
    var changedPositions: Int = 0

/*    @get:Bindable
    var projectList: MutableList<ProjectsItem> = mutableListOf()
        private set(value) {
            field = value
            notifyPropertyChanged(BR.projectList)
        }

    @get:Bindable
    var changedPositions: Int = 0
        private set(value) {
            field = value
            notifyPropertyChanged(BR.changedPositions)
        }*/

    fun initList(listener:IDataManager.OnProjectListListener) {
        projectList = mutableListOf()
        dataManager.getProjectList(listener)
    }

    fun updateList(projectsItem: ProjectsItem) {
        Log.d("projectviewmodel", "update list called " + projectsItem.projectname)
        projectList.add(projectsItem)
        changedPositions = 0
    }

    fun updateItem(index:Int, p: ProjectsItem){
        var i = index+1
        projectList[index].copy(p.projectname,p.endstart,
            p.projectdesc,p.id,p.startdate,p.projectstatus)
    }

    fun addProject(listener:IDataManager.OnCreateProjectListener ,projectsItem: ProjectsItem){
        Log.d("mikkiproject", "add project in view model "+projectsItem.projectname)
//        dataManager.storeNewProjectToServer(listener, projectsItem)
    }

    fun updateProject(listener: IDataManager.OnProjectListListener, projectsItem: ProjectsItem, index:Int){
        dataManager.updateProject(listener, projectsItem, index)
    }

    fun markCompleted(listener: IDataManager.OnProjectListListener,
                      adapterPosition: Int) {
        projectList[adapterPosition].projectstatus = "2"
        updateProject(listener, projectList[adapterPosition],adapterPosition)
    }

}
