package prilepsky.repdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, object : ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainActivityViewModel(MyRepo()) as T
            }
        }).get(MainActivityViewModel::class.java)

        findViewById<View>(R.id.tv).setOnClickListener {
            viewModel.updateData()
        }

        viewModel.data.observe(this) {
            Log.d("TAG", "onCreate: $it")
        }
    }
}