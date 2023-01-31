package com.bjit.broadcastrecieverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class SMSReceiver : BroadcastReceiver() {

    override fun onReceive(contxt: Context, intent: Intent) {
        if (!intent.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) return
        val extractMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        extractMessages.forEach {
            Toast.makeText(contxt, it.displayMessageBody, Toast.LENGTH_SHORT).show()
//            intent.putExtra("sms", it.displayMessageBody)
        }
    }
}