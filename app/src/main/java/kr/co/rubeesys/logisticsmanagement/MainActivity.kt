package kr.co.rubeesys.logisticsmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kr.co.rubeesys.logisticsmanagement.databinding.ActivityMainBinding
import kr.co.rubeesys.logisticsmanagement.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mMainBinding:ActivityMainBinding? = null;
    private val binding get() = mMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMenu.setOnClickListener{
            binding.layoutDrawer.openDrawer(GravityCompat.END)
        }
        binding.naviView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.navi_search -> Toast.makeText(applicationContext, "QR 조회", Toast.LENGTH_SHORT).show()
            R.id.navi_packaging -> Toast.makeText(applicationContext, "포장", Toast.LENGTH_SHORT).show()
            R.id.navi_sending -> Toast.makeText(applicationContext, "발송", Toast.LENGTH_SHORT).show()
            R.id.navi_setting -> Toast.makeText(applicationContext, "설정", Toast.LENGTH_SHORT).show()
        }
        binding.layoutDrawer.closeDrawers()
        return false
    }

    override fun onDestroy() {
        mMainBinding = null
        super.onDestroy()
    }

    override fun onBackPressed() {
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.END))
        {
            binding.layoutDrawer.closeDrawers()
        }
        else
        {
            super.onBackPressed()
        }
    }
}