package com.yashkasera.groupnavigator.ui.group_map

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.yashkasera.groupnavigator.databinding.FragmentMapsBinding
import com.yashkasera.groupnavigator.repository.model.Member
import com.yashkasera.groupnavigator.ui.group_chat.GroupChatFragmentArgs
import com.yashkasera.groupnavigator.util.ItemClickListener


class MapsFragment : Fragment() {
    private val callback = OnMapReadyCallback { googleMap ->
//        val sydney = LatLng(-34.0, 151.0)
        googleMap.uiSettings.isMyLocationButtonEnabled = true
        googleMap.isMyLocationEnabled = true
        googleMap.uiSettings.isZoomGesturesEnabled = true
        googleMap.uiSettings.isZoomControlsEnabled = true
//        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(43.1, -87.9), 10f)
//        map.animateCamera(cameraUpdate)
    }
    private val binding: FragmentMapsBinding by lazy {
        FragmentMapsBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy{
        ViewModelProvider(this).get(MapsViewModel::class.java)
    }
    private val args by lazy { GroupChatFragmentArgs.fromBundle(requireArguments()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.group = args.group
        binding.viewModel = viewModel
        viewModel.memberAdapter.setClickListener(object: ItemClickListener<Member> {
            override fun onItemClick(v: View?, item: Member) {
                Log.d("NewGroupFragment.kt", "YASH => onItemClick: $item")
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync(callback)
        try {
            MapsInitializer.initialize(this.requireActivity())
        } catch (e: GooglePlayServicesNotAvailableException) {
            e.printStackTrace()
        }
        binding.back.setOnClickListener { findNavController().navigateUp() }
    }

    override fun onResume() {
        binding.mapView.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        binding.mapView.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }
}