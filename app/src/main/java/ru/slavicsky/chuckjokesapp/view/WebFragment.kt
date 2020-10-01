package ru.slavicsky.chuckjokesapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import ru.slavicsky.chuckjokesapp.MainActivity
import ru.slavicsky.chuckjokesapp.R

@AndroidEntryPoint
class WebFragment : Fragment() {
    companion object {
        private const val API_URL = "http://www.icndb.com/api/"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).titleMain.text = getString(R.string.title_web)

        val root = inflater.inflate(R.layout.fragment_web, container, false)
        val mWebView = root.findViewById(R.id.web_view) as WebView

        mWebView.settings.javaScriptEnabled = true
        mWebView.webViewClient = WebViewClient()
        mWebView.settings.defaultZoom = WebSettings.ZoomDensity.FAR;
        mWebView.loadUrl(API_URL)
        return root
    }


}