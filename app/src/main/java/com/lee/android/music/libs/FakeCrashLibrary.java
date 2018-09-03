package com.lee.android.music.libs;

/**
 * 作者：凌章 on 2017/4/9 11:54
 * 邮箱：lilingzhang@longshine.com
 */

public class FakeCrashLibrary {
  public static void log(int priority, String tag, String message) {
    // TODO add log entry to circular buffer.
  }

  public static void logWarning(Throwable t) {
    // TODO report non-fatal warning.
  }

  public static void logError(Throwable t) {
    // TODO report non-fatal error.
  }

  private FakeCrashLibrary() {
    throw new AssertionError("No instances.");
  }
}
