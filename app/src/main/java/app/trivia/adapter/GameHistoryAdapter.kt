package app.trivia.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.trivia.R
import app.trivia.model.GameHistory
import kotlinx.android.synthetic.main.activity_summary.view.*
import kotlinx.android.synthetic.main.activity_summary.view.tv_answer1
import kotlinx.android.synthetic.main.activity_summary.view.tv_answer2
import kotlinx.android.synthetic.main.activity_summary.view.tv_answer3
import kotlinx.android.synthetic.main.content_history_view.view.*
import kotlin.math.log

class GameHistoryAdapter(val mContext:Context, var mList:List<GameHistory>):
    RecyclerView.Adapter<GameHistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHistoryViewHolder {
        return GameHistoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.content_history_view,parent,false))
    }

    //this is will set the value of list
    fun setValues(movies: List<GameHistory>) {
        mList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mList.size;
    }

    override fun onBindViewHolder(holder: GameHistoryViewHolder, position: Int) {
        holder.tvAnswer1?.setText(
            mContext.resources.getString(R.string.name, mList.get(position).getAnswer1())
        )
        holder.tvAnswer2?.setText(mList.get(position).getAnswer2())
        holder.tvAnswer3?.setText(mList.get(position).getAnswer3())
        holder.tvDate?.setText(
            mContext.getString(
                R.string.game,
                mList.get(position).getGame(),
                mList.get(position).getDate()
            )
        )

    }
}

//viewholder for the adapter
class GameHistoryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
     val tvAnswer1 = itemView.tv_answer1
      val  tvAnswer2 = itemView.tv_answer2
      val  tvAnswer3 = itemView.tv_answer3
      val  tvDate = itemView.tv_game_no
}