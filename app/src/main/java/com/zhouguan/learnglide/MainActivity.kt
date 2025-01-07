package com.zhouguan.learnglide

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MainActivity : AppCompatActivity() {

    private val imageUrl = "https://www.bing.com/rp/6eCXduaLtTjxr74wpHJ534TrTiE.jpg"  // 示例图片URL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)

        // 普通加载
        findViewById<Button>(R.id.btnNormalLoad).setOnClickListener {
            Glide.with(this)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
        }

        // 圆形裁剪
        findViewById<Button>(R.id.btnCircleCrop).setOnClickListener {
            Glide.with(this)
                .load(imageUrl)
                .transform(CircleCrop()) // 圆形裁剪
                .into(imageView)
        }

        // 圆角裁剪
        findViewById<Button>(R.id.btnRoundedCorners).setOnClickListener {
            Glide.with(this)
                .load(imageUrl)
                .transform(RoundedCorners(30)) // 圆角裁剪，半径 30
                .into(imageView)
        }

        // 调整大小
        findViewById<Button>(R.id.btnResize).setOnClickListener {
            Glide.with(this)
                .load(imageUrl)
                .override(500, 500)  // 调整图片大小
                .into(imageView)
        }

        // 加载占位符
        findViewById<Button>(R.id.btnPlaceholder).setOnClickListener {
            Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)  // 设置占位符
                .into(imageView)
        }

        // 错误占位符
        findViewById<Button>(R.id.btnErrorImage).setOnClickListener {
            Glide.with(this)
                .load(imageUrl)
                .error(R.drawable.error_image)  // 设置加载错误时的占位符
                .into(imageView)
        }

        // CenterCrop
        findViewById<Button>(R.id.btnCenterCrop).setOnClickListener {
            Glide.with(this)
                .load(imageUrl)
                .centerCrop() // 中心裁剪
                .into(imageView)
        }

        // FitCenter
        findViewById<Button>(R.id.btnFitCenter).setOnClickListener {
            Glide.with(this)
                .load(imageUrl)
                .fitCenter() // 保持比例
                .into(imageView)
        }

        // 缓存策略
        findViewById<Button>(R.id.btnCacheStrategy).setOnClickListener {
            Glide.with(this)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL) // 使用缓存策略
                .into(imageView)
        }
    }
}
