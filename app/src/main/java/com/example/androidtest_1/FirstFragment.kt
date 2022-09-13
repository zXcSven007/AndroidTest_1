package com.example.androidtest_1

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidtest_1.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!

    private var textField: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      _binding = FragmentFirstBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.buttonFirst.setOnClickListener {
        //    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        //}

        binding.bNumC.setOnClickListener {
            textField = ""
            binding.displayField.text = textField
        }

        binding.bNum0.setOnClickListener {
            textField = textField.padEnd(textField.count() + 1, '0')
            binding.displayField.text = textField
        }

        binding.bNum1.setOnClickListener {
            textField = textField.padEnd(textField.count() + 1, '1')
            binding.displayField.text = textField
        }

        binding.bNum2.setOnClickListener {
            textField = textField.padEnd(textField.count() + 1, '2')
            binding.displayField.text = textField
        }

        binding.bNum3.setOnClickListener {
            textField = textField.padEnd(textField.count() + 1, '3')
            binding.displayField.text = textField
        }

        binding.bNum4.setOnClickListener {
            textField = textField.padEnd(textField.count() + 1, '4')
            binding.displayField.text = textField
        }

        binding.bNum5.setOnClickListener {
            textField = textField.padEnd(textField.count() + 1, '5')
            binding.displayField.text = textField
        }

        binding.bNum6.setOnClickListener {
            textField = textField.padEnd(textField.count() + 1, '6')
            binding.displayField.text = textField
        }

        binding.bNum7.setOnClickListener {
            textField = textField.padEnd(textField.count() + 1, '7')
            binding.displayField.text = textField
        }

        binding.bNum8.setOnClickListener {
            textField = textField.padEnd(textField.count() + 1, '8')
            binding.displayField.text = textField
        }

        binding.bNum9.setOnClickListener {
            textField = textField.padEnd(textField.count() + 1, '9')
            binding.displayField.text = textField
        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}