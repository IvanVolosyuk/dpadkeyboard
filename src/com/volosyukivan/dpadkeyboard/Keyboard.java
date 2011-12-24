package com.volosyukivan.dpadkeyboard;

import android.inputmethodservice.InputMethodService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;

public class Keyboard extends InputMethodService {
  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_SPACE) {
      InputConnection ic = getCurrentInputConnection();
      if (ic == null) {
        Log.d("kbd", "null input connection");
        return false;
      }
      Log.d("kbd", "sent dpad center");
      ic.sendKeyEvent(replaceKeyCode(event, KeyEvent.KEYCODE_DPAD_CENTER));
      return false;
    }
    return super.onKeyDown(keyCode, event);
  }

  @Override
  public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_SPACE) {
      getCurrentInputConnection().sendKeyEvent(replaceKeyCode(event, KeyEvent.KEYCODE_DPAD_CENTER));
      return false;
    }
    return super.onKeyMultiple(keyCode, count, event);
  }
  
  private KeyEvent replaceKeyCode(KeyEvent ev, int keyCode) {
    return new KeyEvent(
        ev.getDownTime(),
        ev.getEventTime(),
        ev.getAction(), keyCode, ev.getRepeatCount());
  }

  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_SPACE) {
      getCurrentInputConnection().sendKeyEvent(replaceKeyCode(event, KeyEvent.KEYCODE_DPAD_CENTER));
      return false;
    }
    return super.onKeyUp(keyCode, event);
  }

  public Keyboard() {
    Log.d("ruskey", "RusKeyboard constructor called");
  }
  
  @Override
  public void onCreate() {
    Log.d("ruskey", "RusKeyboard: onCreate()");
    super.onCreate();
  }
}