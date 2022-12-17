package academy.nouri.s1_project.ui.home.adapters


import com.aristotele.film.models.home.ResponseMoviesList.*
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aristotele.film.databinding.ItemHomeMoviesLastBinding
import javax.inject.Inject

/**
 * این ادابتر با بقیه ادابتر ها فرق داره
 * چون وقتی کار بر یه چیزی سرچ میکنه هی باید به روز بشه !!!!!
 * دقیقا مثل دیکشنری
 * پس میاد یه لیست خالی درست میکنه همش اون رو عوض میکنه
 * moviesList
 */

class LastMoviesAdapter @Inject constructor() : RecyclerView.Adapter<LastMoviesAdapter.ViewHolder>() {

    private lateinit var binding: ItemHomeMoviesLastBinding


    private var moviesList = emptyList<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastMoviesAdapter.ViewHolder {
        binding = ItemHomeMoviesLastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: LastMoviesAdapter.ViewHolder, position: Int) {
        holder.bindItems(moviesList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount() = moviesList.size

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bindItems(item: Data) {
            binding.apply {
                movieNameTxt.text = item.title
                movieRateTxt.text = item.imdbRating
                movieCountryTxt.text = item.country
                movieYearTxt.text = item.year
                moviePosterImg.load(item.poster) {
                    crossfade(true)
                    crossfade(800)
                }
                //Click
                root.setOnClickListener {
                    onItemClickListener?.let {
                        it(item)
                    }
                }
            }
        }
    }

    private var onItemClickListener: ((Data) -> Unit)? = null

    fun setOnItemClickListener(listener: (Data) -> Unit) {
        onItemClickListener = listener
    }


    /**
     * این متد برای ست کردنه که کلاس پایینی رو استفاده میکنه
     */
    fun setData(data: List<Data>) {
        //ببین از این کلاس پایینی استفاده کرد
        val moviesDiffUtil = MoviesDiffUtils(moviesList, data)

        //بعد میدیمش به دیفررررررررر
        val diffUtils = DiffUtil.calculateDiff(moviesDiffUtil)
        moviesList = data
        diffUtils.dispatchUpdatesTo(this)
    }


    /**
     * یه کلاس خودمون میسازیم با متد های زیر 3 تا متد باید داشته باشه
     * درس 67 هست دقیقه 7.50
     * این کلاس همیشه ثابت به نظر میاد چون همچیش ثابته
     * تعداد مساوی ها دقت کنید
     */
    class MoviesDiffUtils(private val oldItem: List<Data>, private val newItem: List<Data>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldItem.size
        }

        override fun getNewListSize(): Int {
            return newItem.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] === newItem[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] === newItem[newItemPosition]
        }
    }
}