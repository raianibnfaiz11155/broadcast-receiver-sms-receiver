/*
package com.bjit.broadcastrecieverexample

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Toast


class CheckNetwork {
    fun checkINTERNETPermission() {
        if (ContextCompat.checkSelfPermission(
                MyApplication.instance,
                Manifest.permission.INTERNET
            ) == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                MainActivity(),
                arrayOf(Manifest.permission.INTERNET),
                Constant.internetPermissionAccesCode
            )
        } else {
            Toast.makeText(MyApplication.instance, "INTERNET Permission Granted", Toast.LENGTH_SHORT).show()
        }
    }

    fun isOnline(): Boolean {
        val instance = MyApplication.instance
        val connectivityManager =
            instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                Toast.makeText(instance, "ON CELLULAR NETWORK", Toast.LENGTH_SHORT).show()
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                Toast.makeText(instance, "ON WIFI NETWORK", Toast.LENGTH_SHORT).show()
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                Toast.makeText(instance, "ON ETHERNET NETWORK", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        Toast.makeText(instance, "No Internet Connection Available", Toast.LENGTH_SHORT).show()
        return false
    }

    fun networkReceiver():BroadcastReceiver{
        val networkReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetwork = connectivityManager.activeNetworkInfo
                val isConnected = activeNetwork?.isConnected == true
                if (!isConnected) {
                    Toast.makeText(MyApplication.instance, "Internet is not connected", Toast.LENGTH_SHORT).show()
                    isOnline()
                }
                else if(isConnected){
                    Toast.makeText(MyApplication.instance, "Internet is connected", Toast.LENGTH_SHORT).show()
                    isOnline()
                }
            }
        }
        return networkReceiver
    }
}*/
