package com.aristotele.film.ui.home

import academy.nouri.s1_project.ui.home.adapters.GenresAdapter
import academy.nouri.s1_project.ui.home.adapters.LastMoviesAdapter
import academy.nouri.s1_project.ui.home.adapters.TopMoviesAdapter
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.aristotele.film.R
import com.aristotele.film.databinding.FragmentHomeBinding
import com.aristotele.film.ui.viewmodel.HomeViewModel
import com.aristotele.film.utils.initRecycler
import com.aristotele.film.utils.showInvisible
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * لودینگ در این فرگمنت خارج از اسکرول ویو ساخته میشه
 * که بعد لود شدن ریسایکلر بیاد بالا
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding

    /**
     * اینجکت کردن هر 3 آدابتر
     */

    @Inject
    lateinit var topMoviesAdapter: TopMoviesAdapter

    @Inject
    lateinit var genresAdapter: GenresAdapter

    @Inject
    lateinit var lastMoviesAdapter: LastMoviesAdapter


    /**
     * اضافه کردن ویو مدل
     */
    //Other
    private val viewModel: HomeViewModel by viewModels()


    /**
     * بسیار مهم
     * این گزینه ای ک میاد تو ریسایکلر ویو به ما این امکان رو میده که
     * یک دونه یک دونه اسکرول کنیم
     * مثل تقویم دیوسسسسسسسسسسسسسسسسسسسسسسسسسسسسسسسسسسسس
     */
    private val pagerHelper: PagerSnapHelper by lazy { PagerSnapHelper() }

    /**
     * این رو خودمون اضافه میکنیم چون فقط و فقط یک بار موقع ساختن فرگمنت خوانده میشه و تمام
     * بنابر این درخواست رو این تو میدیم
     * که فقط یک بار درخواست زده شود
     * ما اگر در بخش های دیگه این را صدا کنیم هر بار درخواست به هاست داده میشه پی
     * اینجا میزنیم که فقط یک بار ساخته میشه
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadTopMoviesList(3)
        viewModel.loadGenresList()
        viewModel.loadLastMoviesList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //InitViews
        binding.apply {


            /**
             * میریم لیست رو از اینترنت میگیریم و به محض آپدیت شدن اینجا فعال میشه
             * توی it جواب برمیگرده که تو تو بخش data جواب ما هست
             * اما این چی
             * initRecycler
             * یه کسگلک بازی به اسم استنکشن فانکشن خودمون ساختیم که راحت به ابزار ریسایکلر ویو بتونیم گزینه هایی رو تعریف کنیم
             */
            //Get top movies
            viewModel.topMoviesList.observe(viewLifecycleOwner) {
                topMoviesAdapter.differ.submitList(it.data)
                //RecyclerView اکستنشن فانکشن شخصی ساختیم خودمون که لایوت منجر و آدابتر بدیم بهش
                topMoviesRecycler.initRecycler(
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false),
                    topMoviesAdapter
                )


                //Indicator این برای خود اندویده که میگه یک یکی اسکرول بشه
                pagerHelper.attachToRecyclerView(topMoviesRecycler)
                //Indicator همون 3 نقطه زیرش که کتابخونه داره و ریسایکلر رو میگیره
                topMoviesIndicator.attachToRecyclerView(topMoviesRecycler, pagerHelper)
            }







            //Get genres
            viewModel.genresList.observe(viewLifecycleOwner) {
                genresAdapter.differ.submitList(it)
                genresRecycler.initRecycler(
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false),
                    genresAdapter
                )
            }





            /**
             * این بخش سوم هم  ریسایکلر ویوش چون سرچ داره و هی عوض میشه با بقیه فرق داره
             * میتونید برید آدابترش رو ببینید که تهش یه کلاس ساخته و اولش هم یه لیست خالی
             * داده ها قدیم جدید با این کلاسه حساب میشه و بعد میده به لیست و ...
             */

            //Get last movies
            viewModel.lastMoviesList.observe(viewLifecycleOwner) {
                lastMoviesAdapter.setData(it.data)
                //RecyclerView
                lastMoviesRecycler.initRecycler(LinearLayoutManager(requireContext()), lastMoviesAdapter)
            }



//            کلیک کردن
            //Click
            lastMoviesAdapter.setOnItemClickListener {
                val direction = HomeFragmentDirections.actionToDetail(it.id!!.toInt())
                findNavController().navigate(direction)
            }



            //Loading
            viewModel.loading.observe(viewLifecycleOwner) {
                if (it) {
                    moviesLoading.showInvisible(true)
                    moviesScrollLay.showInvisible(false)
                } else {
                    moviesLoading.showInvisible(false)
                    moviesScrollLay.showInvisible(true)
                }
            }
        }
    }
}