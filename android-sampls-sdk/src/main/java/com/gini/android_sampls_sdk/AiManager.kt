package com.gini.android_sampls_sdk

import android.util.Log
import kotlin.reflect.KClass
import kotlin.reflect.full.callSuspend

object AiManager {

    private suspend fun invokeSuspendFunctionByName(
        targetClass: KClass<*>,
        instance: Any,
        methodName: String,
        vararg args: Any?
    ): Any? {
        // Find the method by name that matches the provided arguments.
        val method = targetClass.members.find { it.name == methodName }//&& it.parameters.size == args.size } // +1 for instance parameter
            ?: throw NoSuchMethodException("Method $methodName not found in ${targetClass.simpleName}")
        Log.d("TAG", "invokeSuspendFunctionByName: Parameters for createTask: ${method?.parameters?.map { it.type }}")

        // Call the method with the provided arguments.
        return method.callSuspend(instance, *args)
    }
}