package com.newspro.alexnewspro.utils.common_util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.newspro.alexnewspro.utils.common_util.FileUtils.SdcardPath.IMAGE_SAVEPATH;

public class FileUtils {

    public static class SdcardPath {
        /** EasouMusic根目录 */
        public static final String SAVE_ROOTPATH = Environment.getExternalStorageDirectory() + File.separator + "Alex看看";

        /** 图片缓存目录 */
        public static final String IMAGE_SAVEPATH = SAVE_ROOTPATH + File.separator +"看看相册";

        /** 缓存目录 */
        public static final String CACHE_SAVEPATH = SAVE_ROOTPATH +File.separator + "cache";

        /** 文件缓存目录 */
        public static final String DOWNLOAD_TMP_SAVEPATH = SAVE_ROOTPATH +File.separator + "tmp";

        /** 应用更新目录 */
        public static final String UPDATE_APK_SAVEPATH = SAVE_ROOTPATH +File.separator + "update";

        /** 日志 */
        public static final String LOG_SAVEPATH = SAVE_ROOTPATH +File.separator + "log";

    }

    /**
     * 获取缓存Image的目录
     *
     * @return
     */
    private static String getStorageDirectory() {
        return IMAGE_SAVEPATH;
    }

    /**
     * 保存Image的方法，存储到手机目录
     *
     * @param fileName
     * @param bitmap
     * @throws IOException
     */
    public static void saveBitmap(Context context,String fileName, Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return;
        }
        String path = getStorageDirectory();
        File folderFile = new File(path);
        if (!folderFile.exists()) {
            folderFile.mkdir();
        }
        File file = new File(path + File.separator + fileName);
        if (!initFile(file))
            throw new IOException("FileUtils saveBitmap()错误");
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        fos.flush();
        fos.close();

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getAbsoluteFile())));

    }

    /**
     * 从手机获取Bitmap
     *
     * @param fileName
     * @return
     */
    public static Bitmap getBitmap(String fileName) {
        return BitmapFactory.decodeFile(getStorageDirectory() + File.separator + fileName);
    }

    /**
     * 获取存储的文件的大小
     *
     * @param fileName
     * @return
     */
    public static long getFileSize(String fileName) {
        return new File(getStorageDirectory() + File.separator + fileName).length();
    }

    /**
     * 从文件中获取字符串
     *
     * @param file
     * @return the file content
     */
    public static String readFile(File file) {
        if (!initFile(file))
            return "";
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";

        }
        return inputStream2String(fis);
    }

    /**
     * 将从文件中读取的数据转化为字符串
     *
     * @param is
     * @return
     */
    private static String inputStream2String(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1;
        byte[] data = new byte[1024];
        String result = null;
        try {
            while ((len = is.read(data)) != -1) {
                baos.write(data, 0, len);
            }
            result = new String(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向文件中写入数据
     *
     * @param file
     * @param msg
     */
    public static void writeFile(File file, String msg) {
        if (!initFile(file))
            return;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 创建文件，如果文件被创建则成功
     *
     * @param file
     * @return
     */
    public static boolean initFile(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            File dir = file.getParentFile();
            if (!dir.exists()) {

                if (dir.mkdirs()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                } else
                    return false;
            }
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 得到文件夹的大小
     *
     * @param file
     * @return
     */
    public static long getFolderSize(File file) {
        long size = 0;
        if (file != null) {
            if (file.exists()) {

                if (file.isFile()) {
                    return file.length();
                }
                File[] fileList = file.listFiles();
                if (fileList != null) {
                    for (int i = 0; i < fileList.length; i++) {
                        // 如果下面还有文件则递归继续计算
                        if (fileList[i].isDirectory()) {
                            size += getFolderSize(fileList[i]);
                        } else {
                            size += fileList[i].length();
                        }
                    }
                }
            }
        }
        return size;
    }

    /**
     * 得到文件夹的大小
     *
     * @param fileStr
     * @return
     */
    public static long getFolderSize(String fileStr) {
        File file = new File(fileStr);
        long size = 0;
        if (file.exists()) {

            if (file.isFile()) {
                return file.length();
            }
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件则递归继续计算
                if (fileList[i].isDirectory()) {
                    size += getFolderSize(fileList[i]);
                } else {
                    size += fileList[i].length();
                }
            }
        }
        return size;
    }

    /**
     * 递归删除的方法
     */
    public static void deleteByDir(File file) {
        if (file != null) {

            if (file.exists()) {
                // 如果file为文件或者file为空则直接删除
                // 否则再次调用本方法，删除文件夹中所有文件
                if (file.isFile() || file.list().length == 0) {
                    file.delete();
                } else {
                    for (File file2 : file.listFiles()) {
                        deleteByDir(file2);
                        file2.delete();
                    }
                }
            }
        }
    }

    /**
     * 检测SD卡是否可用
     *
     * @return
     */
    public static boolean isExternalStorageAvailable() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED))
            return true;
        return false;
    }

    /**
     * 手机内存的可用空间大小
     *
     * @return
     */
    public static long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return availableBlocks * blockSize;
    }

    /**
     * 手机内存的总空间大小
     *
     * @return
     */
    public static long getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return totalBlocks * blockSize;
    }

    /**
     * sdcard的可用空间大小
     *
     * @return
     */
    public static long getAvailableExternalMemorySize() {
        if (isExternalStorageAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long availableBlocks = stat.getAvailableBlocks();
            return availableBlocks * blockSize;
        }
        return 0;
    }

    /**
     * 获取sdcard的总空间大小
     *
     * @return
     */
    public static long getTotalExternalMemorySize() {
        if (isExternalStorageAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long totalBlocks = stat.getBlockCount();
            return totalBlocks * blockSize;
        }
        return 0;
    }

    /**
     * 根据链接获取文件名
     *
     * @param url
     * @return 文件名
     */
    public static String getFileNameByUrl(String url) {
        if (url == null || (url = url.trim()).length() <= 0) {
            return null;
        }
        int pos = url.indexOf("?");
        if (pos > 0) {
            url = url.substring(0, pos);
        }
        if (url.endsWith("/") && url.length() > 2) {
            url = url.substring(0, url.length() - 1);
        }
        pos = url.lastIndexOf("/");
        if (pos >= 0) {
            return url.substring(pos + 1);
        }
        return null;
    }

    /**
     * 根据文件名获取文件后缀
     *
     * @param fileName
     *            文件名
     * @return 文件后缀
     */
    public static String getSuffixByFileName(String fileName) {
        if (fileName == null || (fileName = fileName.trim()).length() <= 0) {
            return null;
        }
        int pos = fileName.lastIndexOf(".");
        if (pos >= 0 && fileName.length() - 1 > pos) {
            return fileName.substring(pos);
        }
        return null;
    }

    /**
     * 根据链接返回文件名后缀
     *
     * @param url
     * @return
     */
    public static String getSuffixByUrl(String url) {
        String fileName = getFileNameByUrl(url);
        return getSuffixByFileName(fileName);
    }


}