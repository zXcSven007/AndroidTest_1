package com.example.androidtest_1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtest_1.databinding.FragmentFirstBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var mInterstitialAd: InterstitialAd? = null
    private var mRewardedAd: RewardedAd? = null
    private final var TAG = "FirstFragment"

    private var currentUserReward = 0
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

    private fun showRewardCurrentAmount() {
        val rewardString = getString(R.string.reward_current_amount, currentUserReward.toString())
        binding.rewardField.text = rewardString
    }

    private fun onUserGetReward() {
        currentUserReward += 100
        Log.d(TAG, "User earned the reward.")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.buttonFirst.setOnClickListener {
        //    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        //}

        showRewardCurrentAmount()

        binding.buttonRewardedAd.setOnClickListener {
            var adRequest = AdRequest.Builder().build()
            RewardedAd.load(requireContext(),"ca-app-pub-3940256099942544/5224354917", adRequest, object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError.toString())
                    mRewardedAd = null
                }

                override fun onAdLoaded(rewardedAd: RewardedAd) {
                    Log.d(TAG, "Ad was loaded.")
                    mRewardedAd = rewardedAd
                }
            })

            if (mRewardedAd != null) {
                mRewardedAd?.show(requireActivity(),
                    OnUserEarnedRewardListener() {
                        onUserGetReward()
                        showRewardCurrentAmount()
                    })
            } else {
                Log.d(TAG, "The rewarded ad wasn't ready yet.")
            }
        }

        binding.buttonInterstitialAd.setOnClickListener {
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

        binding.buttonBannerAd.setOnClickListener {
            binding.adView.visibility = View.VISIBLE
            val mAdView : AdView = binding.adView
            val adRequest = AdRequest.Builder().build()
            mAdView.loadAd(adRequest)
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