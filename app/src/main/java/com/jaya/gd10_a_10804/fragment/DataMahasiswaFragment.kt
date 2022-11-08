package com.jaya.gd10_a_10804.fragment

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaya.gd10_a_10804.*
import com.jaya.gd10_a_10804.databinding.FragmentDataMahasiswaBinding
import okhttp3.Response
import javax.security.auth.callback.Callback

@Suppress("UNREACHABLE_CODE")
class DataMahasiswaFragment : Fragment() {
    private var _binding: FragmentDataMahasiswaBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private val listMahasiswa = ArrayList<MahasiswaData>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataMahasiswaBinding.inflate(inflater,
            container, false)
        return binding.root
        getDataMahasiswa()
    }
    override fun onStart() {
        super.onStart()
        getDataMahasiswa()
    }
    private fun getDataMahasiswa() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager= LinearLayoutManager(context)
        val bundle = arguments
        val cari = bundle?.getString(/* key = */ "cari")
        binding.progressBar.visibility
        RClient.instances.getData(cari).enqueue(object :
            retrofit2.Callback<ResponseDataMahasiswa> {
            override fun onResponse(
                call: retrofit2.Call<ResponseDataMahasiswa>,
                response: retrofit2.Response<ResponseDataMahasiswa>
            ){
                if (response.isSuccessful){
                    listMahasiswa.clear()
                    response.body()?.let {
                        listMahasiswa.addAll(it.data) }
                    val adapter =
                        MahasiswaAdapter(listMahasiswa, requireContext())
                    binding.rvData.adapter = adapter
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }
            override fun onFailure(call: retrofit2.Call<ResponseDataMahasiswa>, t:
            Throwable) {
            }
        }
        )
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}