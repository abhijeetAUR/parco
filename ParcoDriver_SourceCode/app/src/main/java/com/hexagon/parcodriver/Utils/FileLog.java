// uncomment if you want write log into files
package com.hexagon.parcodriver.Utils;

import android.util.Log;
import android.widget.Toast;


import com.hexagon.parcodriver.ApplicationLoader;

import java.io.File;

public class FileLog {
    private File currentFile = null;
    private File networkFile = null;

    private static volatile FileLog Instance = null;

    public static FileLog getInstance() {
        FileLog localInstance = Instance;
        if (localInstance == null) {
            synchronized (FileLog.class) {
                localInstance = Instance;
                if (localInstance == null) {
                    Instance = localInstance = new FileLog();
                }
            }
        }
        return localInstance;
    }



    public static String getNetworkLogPath() {
        if (!BuildVars.DEBUG_VERSION) {
            return "";
        }
        try {
            File sdCard = ApplicationLoader.applicationContext.getExternalFilesDir(null);
            if (sdCard == null) {
                return "";
            }
            File dir = new File(sdCard.getAbsolutePath() + "/logs");
            dir.mkdirs();
//            getInstance().networkFile = new File(dir, getInstance().dateFormat.format(System.currentTimeMillis()) + "_net.txt");
            return getInstance().networkFile.getAbsolutePath();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return "";
    }


    public static void e(final String tag, final String message, final Throwable exception) {
        if (!BuildVars.DEBUG_VERSION) {
            return;
        }
        Log.e(tag, message, exception);

    }

    public static void e(final String tag, final String message) {
        if (!BuildVars.DEBUG_VERSION || tag == null || message == null) {
            return;
        }
        Log.e(tag, message);

    }

    public static void e(final String tag, final Throwable e) {
        if (!BuildVars.DEBUG_VERSION) {
            return;
        }
        e.printStackTrace();
        e(e);

    }

    public static void d(final String tag, final String message) {
        if (!BuildVars.DEBUG_VERSION) {
            return;
        }
        Log.d(tag, message);

    }

    public static void w(final String tag, final String message) {
        if (!BuildVars.DEBUG_VERSION) {
            return;
        }
        Log.w(tag, message);

    }

    public static void cleanupLogs() {
        try {
            Toast.makeText(ApplicationLoader.applicationContext, "Logs cleared!", Toast.LENGTH_SHORT).show();
            File sdCard = ApplicationLoader.applicationContext.getExternalFilesDir(null);
            if (sdCard == null) {
                return;
            }
            File dir = new File(sdCard.getAbsolutePath() + "/logs");
            File[] files = dir.listFiles();
            if (files != null) {
                for (int a = 0; a < files.length; a++) {
                    File file = files[a];
                    if (getInstance().currentFile != null && file.getAbsolutePath().equals(getInstance().currentFile.getAbsolutePath())) {
                        continue;
                    }
                    if (getInstance().networkFile != null && file.getAbsolutePath().equals(getInstance().networkFile.getAbsolutePath())) {
                        continue;
                    }
                    file.delete();
                }
            }
        } catch (Exception e) {
            e(e);
        }
    }

    public static void e(final String message) {
        if (!BuildVars.DEBUG_VERSION || message == null) {
            return;
        }
        Log.e("subcorner", message);
    }

    public static void e(final Throwable e) {

        if (!BuildVars.DEBUG_VERSION || e == null) {
            return;
        }
        e.printStackTrace();
        e(e.getMessage());
    }


}
