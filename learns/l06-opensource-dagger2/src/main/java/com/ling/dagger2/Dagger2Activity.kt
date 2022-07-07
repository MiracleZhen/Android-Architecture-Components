package com.ling.dagger2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ling.dagger2.databinding.ActivityDagger2Binding
import com.ling.dagger2.hilt.HiltActivity
import com.ling.dagger2.part01.RepositoryActivity
import com.ling.dagger2.part02.QualifierActivity
import com.ling.dagger2.part03.ComponentActivity
import com.ling.dagger2.part04.activity.ScopeActivity
import com.ling.dagger2.part05.activity.m1.Demo1Activity
import java.lang.NullPointerException

/**
 * author : wangchengzhen
 * time   : 2022/7/5
 * desc   : Dagger2 知识梳理
 */
class Dagger2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityDagger2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDagger2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
    }

    private fun initData() {
        val titles = ArrayList<String>().apply {
            add("(1) 使用 @Inject 和 @Component")
            add("(2) 使用 @Qualifier 和 @Name")
            add("(3) 依赖、包含方式")
            add("(4) @Scope")
            add("(5) Android 支持库")
            add("(6) Hilt")
        }
        val dagger2Adapter = Dagger2Adapter(titles)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = dagger2Adapter
    }

    class Dagger2Adapter constructor(var titles: List<String>) : RecyclerView.Adapter<Dagger2Adapter.Dagger2ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Dagger2ViewHolder {
            val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_dagger2, parent, false)
            return Dagger2ViewHolder(rootView)
        }

        override fun onBindViewHolder(holder: Dagger2ViewHolder, position: Int) {
            val title = titles.getOrNull(position)
            holder.tvTitle.text = title
            holder.tvTitle.setOnClickListener {
                when (position) {
                    0 -> {
                        it.context.startActivity(Intent(it.context, RepositoryActivity::class.java))
                    }
                    1 -> {
                        it.context.startActivity(Intent(it.context, QualifierActivity::class.java))
                    }
                    2 -> {
                        it.context.startActivity(Intent(it.context, ComponentActivity::class.java))
                    }
                    3 -> {
                        it.context.startActivity(Intent(it.context, ScopeActivity::class.java))
                    }
                    4 -> {
                        it.context.startActivity(Intent(it.context, Demo1Activity::class.java))
                    }
                    5 -> {
                        it.context.startActivity(Intent(it.context, HiltActivity::class.java))
                    }
                }
            }
        }

        override fun getItemCount(): Int {
            return titles.size
        }

        class Dagger2ViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {

            var tvTitle: TextView = rootView.findViewById(R.id.tv_title)
        }
    }
}
