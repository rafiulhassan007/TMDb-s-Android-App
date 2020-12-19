package com.grameenphone.digitalninja.data.network

class ConnectivityResource <out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): ConnectivityResource<T> =
            ConnectivityResource(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): ConnectivityResource<T> =
            ConnectivityResource(status = Status.FAILED, data = data, message = message)

        fun <T> loading(data: T?): ConnectivityResource<T> =
            ConnectivityResource(status = Status.LOADING, data = data, message = null)

    }
}