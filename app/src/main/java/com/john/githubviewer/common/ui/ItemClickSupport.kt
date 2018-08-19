package com.john.githubviewer.common.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import com.john.githubviewer.R


/*
  Source: http://www.littlerobots.nl/blog/Handle-Android-RecyclerView-Clicks/
  USAGE:

  ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
      @Override
      public void onItemClicked(RecyclerView recyclerView, int position, View v) {
          // do it
      }
  });
*/
class ItemClickSupport private constructor(private val mRecyclerView: RecyclerView) {

    private var mOnItemClickListener: OnItemClickListener? = null
    private var mOnItemLongClickListener: OnItemLongClickListener? = null
    private val mOnClickListener = object : View.OnClickListener {
        override fun onClick(v: View) {
            val listener = mOnItemClickListener
            if (listener != null) {
                val holder = mRecyclerView.getChildViewHolder(v)
                listener.onItemClicked(mRecyclerView, holder.adapterPosition, v)
            }
        }
    }
    private val mOnLongClickListener = object : View.OnLongClickListener {
        override fun onLongClick(v: View): Boolean {
            val listener = mOnItemLongClickListener
            if (listener != null) {
                val holder = mRecyclerView.getChildViewHolder(v)
                return listener.onItemLongClicked(mRecyclerView, holder.adapterPosition, v)
            }
            return false
        }
    }
    private val mAttachListener = object : RecyclerView.OnChildAttachStateChangeListener {
        override fun onChildViewAttachedToWindow(view: View) {
            if (mOnItemClickListener != null) {
                view.setOnClickListener(mOnClickListener)
            }
            if (mOnItemLongClickListener != null) {
                view.setOnLongClickListener(mOnLongClickListener)
            }
        }

        override fun onChildViewDetachedFromWindow(view: View) {

        }
    }

    init {
        mRecyclerView.setTag(R.id.item_click_support, this)
        mRecyclerView.addOnChildAttachStateChangeListener(mAttachListener)
    }

    @Suppress("unused")
    fun setOnItemClickListener(listener: OnItemClickListener): ItemClickSupport {
        mOnItemClickListener = listener
        return this
    }

    @Suppress("unused")
    fun setOnItemLongClickListener(listener: OnItemLongClickListener): ItemClickSupport {
        mOnItemLongClickListener = listener
        return this
    }

    private fun detach(view: RecyclerView) {
        view.removeOnChildAttachStateChangeListener(mAttachListener)
        view.setTag(R.id.item_click_support, null)
    }

    interface OnItemClickListener {

        fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View)
    }

    interface OnItemLongClickListener {

        fun onItemLongClicked(recyclerView: RecyclerView, position: Int, v: View): Boolean
    }

    companion object {
        fun addTo(view: RecyclerView): ItemClickSupport {
            var support: ItemClickSupport? = view.getTag(R.id.item_click_support) as? ItemClickSupport
            if (support == null) {
                support = ItemClickSupport(view)
            }
            return support
        }

        fun removeFrom(view: RecyclerView): ItemClickSupport? {
            val support: ItemClickSupport? = view.getTag(R.id.item_click_support) as? ItemClickSupport
            support?.detach(view)
            return support
        }
    }
}
