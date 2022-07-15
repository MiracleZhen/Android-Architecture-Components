package com.ling.utils;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;

/**
 * author : wangchengzhen
 * github : https://github.com/Blankj/AndroidUtilCode
 * time   : 2021/11/12
 * desc   : utils about volume - 音量相关
 */
public class VolumeUtils {

    /**
     * 获取音量
     * <p>
     * Return the volume.
     *
     * @param streamType The stream type.
     *                   <ul>
     *                   <li>{@link AudioManager#STREAM_VOICE_CALL}</li>
     *                   <li>{@link AudioManager#STREAM_SYSTEM}</li>
     *                   <li>{@link AudioManager#STREAM_RING}</li>
     *                   <li>{@link AudioManager#STREAM_MUSIC}</li>
     *                   <li>{@link AudioManager#STREAM_ALARM}</li>
     *                   <li>{@link AudioManager#STREAM_NOTIFICATION}</li>
     *                   <li>{@link AudioManager#STREAM_DTMF}</li>
     *                   <li>{@link AudioManager#STREAM_ACCESSIBILITY}</li>
     *                   </ul>
     * @return the volume
     */
    public static int getVolume(int streamType) {
        AudioManager am = (AudioManager) Utils.getApp().getSystemService(Context.AUDIO_SERVICE);
        //noinspection ConstantConditions
        return am.getStreamVolume(streamType);
    }

    /**
     * 设置音量
     * <p>
     * Sets media volume.<br>
     * When setting the value of parameter 'volume' greater than the maximum value of the media volume will not either cause error or throw exception but maximize the media volume.<br>
     * Setting the value of volume lower than 0 will minimize the media volume.
     *
     * @param streamType The stream type.
     *                   <ul>
     *                   <li>{@link AudioManager#STREAM_VOICE_CALL}</li>
     *                   <li>{@link AudioManager#STREAM_SYSTEM}</li>
     *                   <li>{@link AudioManager#STREAM_RING}</li>
     *                   <li>{@link AudioManager#STREAM_MUSIC}</li>
     *                   <li>{@link AudioManager#STREAM_ALARM}</li>
     *                   <li>{@link AudioManager#STREAM_NOTIFICATION}</li>
     *                   <li>{@link AudioManager#STREAM_DTMF}</li>
     *                   <li>{@link AudioManager#STREAM_ACCESSIBILITY}</li>
     *                   </ul>
     * @param volume     The volume.
     * @param flags      The flags.
     *                   <ul>
     *                   <li>{@link AudioManager#FLAG_SHOW_UI}</li>
     *                   <li>{@link AudioManager#FLAG_ALLOW_RINGER_MODES}</li>
     *                   <li>{@link AudioManager#FLAG_PLAY_SOUND}</li>
     *                   <li>{@link AudioManager#FLAG_REMOVE_SOUND_AND_VIBRATE}</li>
     *                   <li>{@link AudioManager#FLAG_VIBRATE}</li>
     *                   </ul>
     */
    public static void setVolume(int streamType, int volume, int flags) {
        AudioManager am = (AudioManager) Utils.getApp().getSystemService(Context.AUDIO_SERVICE);
        try {
            //noinspection ConstantConditions
            am.setStreamVolume(streamType, volume, flags);
        } catch (SecurityException ignore) {
        }
    }

    /**
     * 获取最大音量
     * <p>
     * Return the maximum volume.
     *
     * @param streamType The stream type.
     *                   <ul>
     *                   <li>{@link AudioManager#STREAM_VOICE_CALL}</li>
     *                   <li>{@link AudioManager#STREAM_SYSTEM}</li>
     *                   <li>{@link AudioManager#STREAM_RING}</li>
     *                   <li>{@link AudioManager#STREAM_MUSIC}</li>
     *                   <li>{@link AudioManager#STREAM_ALARM}</li>
     *                   <li>{@link AudioManager#STREAM_NOTIFICATION}</li>
     *                   <li>{@link AudioManager#STREAM_DTMF}</li>
     *                   <li>{@link AudioManager#STREAM_ACCESSIBILITY}</li>
     *                   </ul>
     * @return the maximum volume
     */
    public static int getMaxVolume(int streamType) {
        AudioManager am = (AudioManager) Utils.getApp().getSystemService(Context.AUDIO_SERVICE);
        //noinspection ConstantConditions
        return am.getStreamMaxVolume(streamType);
    }

    /**
     * 获取最小音量
     * <p>
     * Return the minimum volume.
     *
     * @param streamType The stream type.
     *                   <ul>
     *                   <li>{@link AudioManager#STREAM_VOICE_CALL}</li>
     *                   <li>{@link AudioManager#STREAM_SYSTEM}</li>
     *                   <li>{@link AudioManager#STREAM_RING}</li>
     *                   <li>{@link AudioManager#STREAM_MUSIC}</li>
     *                   <li>{@link AudioManager#STREAM_ALARM}</li>
     *                   <li>{@link AudioManager#STREAM_NOTIFICATION}</li>
     *                   <li>{@link AudioManager#STREAM_DTMF}</li>
     *                   <li>{@link AudioManager#STREAM_ACCESSIBILITY}</li>
     *                   </ul>
     * @return the minimum volume
     */
    public static int getMinVolume(int streamType) {
        AudioManager am = (AudioManager) Utils.getApp().getSystemService(Context.AUDIO_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            //noinspection ConstantConditions
            return am.getStreamMinVolume(streamType);
        }
        return 0;
    }
}
