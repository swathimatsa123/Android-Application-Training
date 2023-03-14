package com.example.databaseactivity2.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.databaseactivity2.R
import com.example.databaseactivity2.databinding.FragmentAddBinding
import com.example.databaseactivity2.model.Student
import com.example.databaseactivity2.viewmodel.StudentViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
   private lateinit var studentViewModel:StudentViewModel
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentAddBinding.inflate(inflater,container,false)
        var studentId =binding.studentID.text.toString().toInt()
        var studentName = binding.studentName.text.toString()
        val student:Student = Student(studentId,studentName)
        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        binding.savebtn.setOnClickListener {
            addStudentToDatabase(student)
        }
        return binding.root
    }

    private fun addStudentToDatabase(student: Student) {
        if(inputCheck()) {
            studentViewModel.addStudent(student)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate back
            findNavController().navigate(R.id.action_addFragment_to_studentListFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(): Boolean {
        var studentId =binding.studentID.text.toString()
        var studentName = binding.studentName.text.toString()
        return !(TextUtils.isEmpty(studentId) && TextUtils.isEmpty(studentName))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}