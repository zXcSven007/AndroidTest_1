package com.example.androidtest_1

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidtest_1.databinding.FragmentFirstBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "FirstFragment"
    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!

    private val maxTextLength: Int = 16

    private var currentTextField: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun addTextFieldSymbol(symbol: Char) {
        if (currentTextField.length < maxTextLength) {
            currentTextField += symbol
            binding.displayField.text = currentTextField
        }
    }

    private fun clearTextField() {
        currentTextField = ""
        binding.displayField.text = currentTextField
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.buttonFirst.setOnClickListener {
        //    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        //}

        val mAdView : AdView = binding.adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        binding.buttonNext.setOnClickListener {
            //TODO(show interstitial ads)
            var adRequest = AdRequest.Builder().build()

            InterstitialAd.load(requireContext(),"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError.toString())
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(TAG, "Ad was loaded.")
                    mInterstitialAd = interstitialAd
                }
            })

            if (mInterstitialAd != null) {
                mInterstitialAd?.show(requireActivity())
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }
        }

        binding.bNumC.setOnClickListener {
            clearTextField()
        }

        binding.bNum0.setOnClickListener {
            addTextFieldSymbol('0')
        }

        binding.bNum1.setOnClickListener {
            addTextFieldSymbol('1')
        }

        binding.bNum2.setOnClickListener {
            addTextFieldSymbol('2')
        }

        binding.bNum3.setOnClickListener {
            addTextFieldSymbol('3')
        }

        binding.bNum4.setOnClickListener {
            addTextFieldSymbol('4')
        }

        binding.bNum5.setOnClickListener {
            addTextFieldSymbol('5')
        }

        binding.bNum6.setOnClickListener {
            addTextFieldSymbol('6')
        }

        binding.bNum7.setOnClickListener {
            addTextFieldSymbol('7')
        }

        binding.bNum8.setOnClickListener {
            addTextFieldSymbol('8')
        }

        binding.bNum9.setOnClickListener {
            addTextFieldSymbol('9')
        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}