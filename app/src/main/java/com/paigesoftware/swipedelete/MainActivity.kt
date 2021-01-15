package com.paigesoftware.swipedelete

import android.graphics.Canvas
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.paigesoftware.swipedelete.SwipeController.SwipeController
import com.paigesoftware.swipedelete.SwipeController.SwipeControllerActions
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mAdapter: PlayerAdapter? = null
    val playerList = ArrayList<Player>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPlayersDataAdapter()
        setupRecyclerView()
    }

    private fun setPlayersDataAdapter() {


        for(i in 0..200) {
            val player = Player("paige $i", "korea", "FCSeoul", 29, 10)
            playerList.add(player)
        }

        mAdapter = PlayerAdapter(playerList)

    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = mAdapter
        //initialize swipe controller and attach it to recyclerview
        val swipeController = SwipeController(object: SwipeControllerActions() {
            override fun onLeftClicked(position: Int) {

            }

            override fun onRightClicked(position: Int) {
                playerList.removeAt(position)
                mAdapter?.notifyItemRemoved(position);
                mAdapter?.notifyItemRangeChanged(position, mAdapter!!.itemCount);
            }
        })
        val itemTouchHelper = ItemTouchHelper(swipeController)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                super.onDraw(c, parent, state)
                swipeController.onDraw(c)
            }
        })
    }

}