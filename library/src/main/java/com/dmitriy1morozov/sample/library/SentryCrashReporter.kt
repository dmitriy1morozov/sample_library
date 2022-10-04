package com.dmitriy1morozov.sample.library

import io.sentry.Hub
import io.sentry.Sentry
import io.sentry.SentryEvent
import io.sentry.SentryLevel
import io.sentry.protocol.Message


object SentryCrashReporter {

    const val SENTRY_DSN =
        "https://b50d9bee97814c769500ea0d9eb7aaf4@o4503903413665792.ingest.sentry.io/4503903414779904"

    fun reportError(e: Throwable) {
        val mainHub = Sentry.getCurrentHub().clone()
        val retenoHub = Hub(mainHub.options.apply {
            dsn = SENTRY_DSN
        })

        retenoHub.captureException(e)

//        retenoHub.captureMessage("SomeMessage custom")
    }
}