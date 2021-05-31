package com.example.database

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.database.database.RoomDatabase
import com.example.database.databinding.FragmentMainBinding
import com.example.database.model.Word

class MainFragment : Fragment() {

    private lateinit var adapterof: MyAdapter
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
           val dataSource = RoomDatabase.getDatabase(requireContext()).wordDao
        val factory = MainViewModelFactory(dataSource)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        setRv()
        setWord()
    }

    private fun setRv() {
        adapterof = MyAdapter { it ->
            viewModel.getWord(it.english).observe(viewLifecycleOwner){word ->
                AlertDialog.Builder(requireContext())
                    .setMessage(word.uzbek)
                    .setCancelable(true)
                    .show()
            }
        }
        binding.rvItemHj.adapter = adapterof
        Log.d("-------------", "setRv: ${list()}")
        adapterof.setData(list())
        binding.rvItemHj.layoutManager = LinearLayoutManager(requireContext())
        binding.rvItemHj.setHasFixedSize(true)
    }

    private fun setWord() {
//
//        viewModel.setWord(Word(1, "Your Name", "Seninh isming"))
//        viewModel.setWord(Word(2, "Your Lie in April", "Apreldagi yolg`oning"))
//        viewModel.setWord(Word(3, "I Want to Eat Your pancreas", "Men sizning oshqozon osti bezingizni iste'mol qilmoqchiman"))
//        viewModel.setWord(Word(4, "Five meters per second", "Sekundiga besh metr"))
//        viewModel.setWord(Word(5, "Golden Time", "Tilla vaqt"))
//        viewModel.setWord(Word(6, "From up on poppy hill", "Polly Hill tomon"))
//        viewModel.setWord(Word(7, "Howl’s Moving Castle", "Hovlning yuruvchi qasri"))
//        viewModel.setWord(Word(8, "Attack on Titan", "Titanga hujum"))
//        viewModel.setWord(Word(9, "Fullmetal Alchemist: Brotherhood", "Buniyam bilmimaneee"))
//        viewModel.setWord(Word(10, "Death Note", "O`lim yozuvi"))
//        viewModel.setWord(Word(11, "Demon Slayer: Kimetsu no Yaiba", "Tarjimasini bilmaymaneeeee"))

        viewModel.setWord(Word(1, this.getString(R.string.one), this.getString(R.string.bir)))
        viewModel.setWord(Word(2, this.getString(R.string.two), this.getString(R.string.ikki)))
        viewModel.setWord(Word(3, this.getString(R.string.three), this.getString(R.string.uch)))
        viewModel.setWord(Word(4, this.getString(R.string.four), this.getString(R.string.tort)))
        viewModel.setWord(Word(5, this.getString(R.string.five), this.getString(R.string.besh)))
        viewModel.setWord(Word(6, this.getString(R.string.six), this.getString(R.string.olti)))
        viewModel.setWord(Word(7, this.getString(R.string.seven), this.getString(R.string.yetti)))
        viewModel.setWord(Word(8 ,this.getString(R.string.eight), this.getString(R.string.sakkiz)))
        viewModel.setWord(Word(9, this.getString(R.string.nine), this.getString(R.string.toqqiz)))
        viewModel.setWord(Word(10, this.getString(R.string.ten), this.getString(R.string.on)))
        viewModel.setWord(Word(11, this.getString(R.string.hundren), this.getString(R.string.yuz)))
        viewModel.setWord(Word(12, this.getString(R.string.thousand), this.getString(R.string.ming)))
    }

    private fun list(): ArrayList<Word> {
        return arrayListOf(
//            Word(1, "Your Name", "Sening isming"),
//            Word(2, "Your Lie in April", "Apreldagi yolg`oning"),
//            Word(3,"I Want to Eat Your pancreas", "Men sizning oshqozon osti bezingizni iste'mol qilmoqchiman"),
//            Word(4, "Five meters per second", "Sekundiga besh metr"),
//            Word(5, "Golden Time", "Tilla vaqt"),
//            Word(6,"From up on poppy hill", "Polly Hill tomon"),
//            Word(7, "Howl’s Moving Castle", "Hovlning yuruvchi qasri"),
//            Word(8, "Attack on Titan", "Titanga hujum"),
//            Word(9, "Fullmetal Alchemist: Brotherhood", "Buniyam bilmimaneee"),
//            Word(10, "Death Note", "O`lim yozuvi"),
//            Word(11, "Demon Slayer: Kimetsu no Yaiba", "Tarjimasini bilmaymaneeeee")


            Word(1, this.getString(R.string.one), this.getString(R.string.bir)),
            Word(2, this.getString(R.string.two), this.getString(R.string.ikki)),
            Word(3, this.getString(R.string.three), this.getString(R.string.uch)),
            Word(4, this.getString(R.string.four), this.getString(R.string.tort)),
            Word(5, this.getString(R.string.five), this.getString(R.string.besh)),
            Word(6, this.getString(R.string.six), this.getString(R.string.olti)),
            Word(7, this.getString(R.string.seven), this.getString(R.string.yetti)),
            Word(8, this.getString(R.string.eight), this.getString(R.string.sakkiz)),
            Word(9, this.getString(R.string.nine), this.getString(R.string.toqqiz)),
            Word(10, this.getString(R.string.ten), this.getString(R.string.on)),
            Word(11, this.getString(R.string.hundren), this.getString(R.string.yuz)),
            Word(12, this.getString(R.string.thousand), this.getString(R.string.ming))
        )
    }
}