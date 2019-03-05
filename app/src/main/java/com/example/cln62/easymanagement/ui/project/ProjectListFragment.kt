package com.example.cln62.easymanagement.ui.project

import android.app.Fragment
import android.os.Bundle

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cln62.easymanagement.R
import com.example.cln62.easymanagement.adapter.ProjectListAdapter
import com.example.cln62.easymanagement.data.IDataManager
import com.example.cln62.easymanagement.data.pojo.projectpojo.ProjectsItem
import com.example.cln62.easymanagement.viewmodel.ProjectViewModel
import kotlinx.android.synthetic.main.frag_project_list_databinding.view.*

class ProjectListFragment(): Fragment(), IDataManager.OnProjectListListener {

    private val viewModel = ProjectViewModel()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.frag_project_list, container, false)
/*
        val binding:FragProjectListBinding
                = DataBindingUtil.inflate(inflater,
            R.layout.frag_project_list_databinding,container,false)*/

//        val view:View = binding.root

//        binding.projectViewModel = viewModel

        val adapter = ProjectListAdapter()

        val mLayoutManager = LinearLayoutManager(context)
        mLayoutManager.reverseLayout = true;
        mLayoutManager.stackFromEnd = true;
        view.rv_project_list.layoutManager = mLayoutManager
        view.rv_project_list.adapter = adapter

/*        val swipeHandler = object : SwipeToDeleteCallback(context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
                //val adapter = view.rv_project_list.adapter as ProjectListAdapter
                viewModel.markCompleted( this@ProjectListFragment,
                    viewHolder!!.adapterPosition)
                adapter.removeAt(viewHolder!!.adapterPosition)

            }
        }*/

/*        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(view.rv_project_list)*/

        viewModel.initList(this)

        return view
    }

    override fun finishedInitialList(item: ProjectsItem) {
        viewModel.updateList(item)
    }

    override fun finishedUpdateProject(p: ProjectsItem, index: Int) {
        Toast.makeText(context,
            "project, "+p.id+",marked completed",
            Toast.LENGTH_SHORT).show()
        viewModel.updateItem(index, p)
    }


}