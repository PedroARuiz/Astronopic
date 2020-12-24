package org.edrodev.astronopic.data.remote.service.client

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

internal actual val engine: HttpClientEngine = OkHttp.create()