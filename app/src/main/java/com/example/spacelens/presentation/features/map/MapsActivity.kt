package com.example.spacelens.presentation.features.map

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.spacelens.R
import com.example.spacelens.domain.entities.Product
import com.example.spacelens.presentation.features.list.MainActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.net.URL


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    var product: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        product = intent.getParcelableExtra(MainActivity.product_key)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val location = LatLng(product!!.location.latitude, product!!.location.longitude)
        mMap.addMarker(MarkerOptions().position(location).title(product!!.title)
            .icon(BitmapDescriptorFactory.fromBitmap(getImage())))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))

        mMap.setOnMarkerClickListener {
            finish()
            true
        }


    }

    private fun getImage(): Bitmap?{
        var image: Bitmap? = null
        val url = URL(product!!.attachment.url)
        image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        return Bitmap.createScaledBitmap(image, 150, 150, false)
    }
}