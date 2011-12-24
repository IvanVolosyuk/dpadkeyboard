package com.volosyukivan.dpadkeyboard;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class InfoPage extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = new Intent(Intent.ACTION_VIEW,
        Uri.parse("http://code.google.com/p/dpadkeyboard/wiki/DPADKeyboard"));
    startActivity(intent);
  }
}
