package com.ute.multimedia

import android.net.Uri
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- WebView para YouTube (iframe embed) ---
        webView = findViewById(R.id.webViewYouTube)
        val ws: WebSettings = webView.settings
        ws.javaScriptEnabled = true
        ws.domStorageEnabled = true
        ws.mediaPlaybackRequiresUserGesture = false

        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()

        webView.clearCache(true)
        webView.clearHistory()

        val videoId = "hg7wma0GXAc" // ID del video
        val html = """
            <html>
                <body style="margin:0;padding:0;">
                    <iframe width="100%" height="100%" 
                        src="https://www.youtube.com/embed/$videoId" 
                        frameborder="0" allowfullscreen>
                    </iframe>
                </body>
            </html>
        """.trimIndent()

        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null)

        // --- VideoView para MP4 local ---
        videoView = findViewById(R.id.videoViewMp4)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        val videoUri: Uri = Uri.parse("android.resource://${packageName}/${R.raw.demo}")
        videoView.setVideoURI(videoUri)

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = false
            videoView.start() // Inicia automáticamente
        }
    }

    override fun onBackPressed() {
        if (this::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
