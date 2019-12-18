package com.lxj.androidktxdemo

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lxj.androidktx.core.*
import com.lxj.androidktxdemo.entity.PageInfo
import com.lxj.androidktxdemo.entity.User
import com.lxj.androidktxdemo.fragment.*
import kotlinx.android.synthetic.main.activity_main.*


data class UserTest(
        var name: String,
        var age: Int
)

data class RestResult(
        var code: Int = 0,
        var message: String = ""
)

class MainActivity : AppCompatActivity() {
    val pages = arrayListOf(
            PageInfo("Span相关", SpanExtPage()),
            PageInfo("View相关", ViewExtPage()),
            PageInfo("ImageView相关", ImageViewExtPage()),
            PageInfo("Fragment相关", FragmentExtPage()),
            PageInfo("Http相关", HttpExtFragment()),
            PageInfo("LiveDataBus", LiveDataBusDemo()),
            PageInfo("RecyclerView相关", RecyclerViewExtDemo())

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.bindFragment(fm = supportFragmentManager, fragments = pages.map { it.page!! }, pageTitles = pages.map { it.title })
        tabLayout.setupWithViewPager(viewPager)

//        viewPager.asCard()
//        viewPager.bind(10, bindView = {container, position ->
//            return@bind TextView(this)
//        })

        toast("测试短吐司")
        longToast("测试长吐司")

        UserTest("李晓俊", 25).toJson().v()
        "{\"age\":25,\"name\":\"李晓俊\"}".toBean<User>().toString().w()
        "[{\"age\":25,\"name\":\"李晓俊\"}]".toBean<List<User>>().toString().e()


//        // 便捷处理
//        sp().getString("a", "default")
//        sp().getBoolean("b", false)
//        sp(name = "xxx.cfg").getBoolean("b", false)
//        //...
//
//        // 批处理
//        sp().edit {
//            putString("a", "1")
//            putBoolean("b", true)
//        }
//        // 清楚
//        sp().clear()

//        val stateLiveData = StateLiveData<String>()
//        stateLiveData.launchAndSmartPost {
//            "xxx".http().get<String>().await()
//        }


        val u1 = UserTest("李晓俊", 25)
        val u3 = u1.copy()
        loge("u3： $u3   u1==u3: ${u1===u3}" )
    }


}
