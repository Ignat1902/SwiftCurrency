package com.example.swiftcurrency.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.swiftcurrency.App
import com.example.swiftcurrency.data.repository.CurrencyRepository
import com.example.swiftcurrency.databinding.FragmentExchangeRateBinding
import javax.inject.Inject

class ExchangeRateFragment : Fragment() {

    private var _binding: FragmentExchangeRateBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        (context.applicationContext as App).appComponent.inject(this)
        super.onAttach(context)
    }

    @Inject
    lateinit var currencyRepository: CurrencyRepository
    private val viewModel: ExchangeRateViewModel by viewModels {
        VideoListViewModelFactory(currencyRepository)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExchangeRateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}