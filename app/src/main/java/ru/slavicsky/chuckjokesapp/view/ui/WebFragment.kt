package ru.slavicsky.chuckjokesapp.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import ru.slavicsky.chuckjokesapp.AppConstants.API_URL
import ru.slavicsky.chuckjokesapp.R

class WebFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_web, container, false)
        val mWebView = root.findViewById(R.id.web_view) as WebView

        mWebView.settings.javaScriptEnabled = true
        mWebView.webViewClient = WebViewClient()
        mWebView.loadUrl(API_URL)
        return root
    }
}