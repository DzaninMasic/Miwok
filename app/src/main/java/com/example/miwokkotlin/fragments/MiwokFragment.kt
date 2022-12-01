package com.example.miwokkotlin.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miwokkotlin.CategoryView
import com.example.miwokkotlin.MiwokEnum
import com.example.miwokkotlin.R
import com.example.miwokkotlin.adapters.MiwokAdapter
import com.example.miwokkotlin.models.MiwokModel
import com.example.miwokkotlin.presenters.MiwokPresenter


class MiwokFragment: Fragment(), MiwokAdapter.OnItemListener, CategoryView {
    private var recyclerView: RecyclerView? = null
    private var presenter: MiwokPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_miwok, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.myRecyclerView)

        val unBundled = this.arguments?.get("DATA")

        var type: MiwokEnum? = null
        if (unBundled is MiwokEnum){
            type = unBundled
            Log.i("TAG", unBundled.toString())
        }

        presenter = MiwokPresenter(requireContext(),this)
        presenter?.getData(type)
    }

    override fun onPause() {
        super.onPause()
        presenter?.pauseMedia()
    }

    override fun onItemClick(position: Int) {
        presenter?.playMedia(position)
    }

    //.create companion object
    companion object {
        // Change "test"
        fun create(test: MiwokEnum): Fragment {
            val bundle = Bundle()
            bundle.putSerializable("DATA",test)
            val fragment = MiwokFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun showData(data: ArrayList<MiwokModel>) {
        val adapter = MiwokAdapter(requireContext(), data, this)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
    }
}
