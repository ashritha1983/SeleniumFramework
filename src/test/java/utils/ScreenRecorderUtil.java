//package utils;//package utils;
//
//import java.awt.AWTException;
//import java.awt.Dimension;
//import java.awt.GraphicsConfiguration;
//import java.awt.GraphicsEnvironment;
//import java.awt.Rectangle;
//import java.awt.Toolkit;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import org.monte.media.Format;
//import org.monte.media.FormatKeys.MediaType;
//import org.monte.media.Registry;
//import org.monte.media.math.Rational;
//import org.monte.screenrecorder.ScreenRecorder;
//
//import static org.monte.media.AudioFormatKeys.*;
//import static org.monte.media.VideoFormatKeys.*;
//
//public class ScreenRecorderUtil extends ScreenRecorder {
//    public static ScreenRecorder screenRecorder;
//    public String name;
//    public ScreenRecorderUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
//                              Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
//            throws IOException, AWTException {
//        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
//        this.name = name;
//    }
//
//    @Override
//    protected File createMovieFile(Format fileFormat) throws IOException {
//
//        if (!movieFolder.exists()) {
//            movieFolder.mkdirs();
//        } else if (!movieFolder.isDirectory()) {
//            throw new IOException("\"" + movieFolder + "\" is not a directory.");
//        }
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
//        return new File(movieFolder,
//                name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
//    }
//
//    public static void startRecord(String methodName) throws Exception {
//        File file = new File("./test-recordings/");
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = screenSize.width;
//        int height = screenSize.height;
//
//        Rectangle captureSize = new Rectangle(0, 0, width, height);
//
//        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
//                getDefaultScreenDevice()
//                .getDefaultConfiguration();
//        screenRecorder = new ScreenRecorderUtil(gc, captureSize,
//                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
//                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
//                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
//                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
//                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
//                null, file, methodName);
//        screenRecorder.start();
//    }
//
//    public static void stopRecord() throws Exception {
//        screenRecorder.stop();
//    }
//}
//
//package utils;
//
//import java.awt.AWTException;
//import java.awt.Dimension;
//import java.awt.GraphicsConfiguration;
//import java.awt.GraphicsEnvironment;
//import java.awt.Rectangle;
//import java.awt.Toolkit;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.monte.media.Format;
//import org.monte.media.FormatKeys.MediaType;
//import org.monte.media.Registry;
//import org.monte.media.math.Rational;
//import org.monte.screenrecorder.ScreenRecorder;
//
//import static org.monte.media.AudioFormatKeys.*;
//import static org.monte.media.VideoFormatKeys.*;
//
//public class ScreenRecorderUtil extends ScreenRecorder {
//    private static ScreenRecorderUtil screenRecorder;
//    private static File movieFile;
//    private String name;
//
//    public ScreenRecorderUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
//                              Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
//            throws IOException, AWTException {
//        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
//        this.name = name;
//    }
//
////    @Override
////    protected File createMovieFile(Format fileFormat) throws IOException {
////        if (!movieFolder.exists()) {
////            if (movieFolder.mkdirs()) {
////                System.out.println("Directory created: " + movieFolder.getAbsolutePath());
////            } else {
////                throw new IOException("Failed to create directory: " + movieFolder.getAbsolutePath());
////            }
////        } else if (!movieFolder.isDirectory()) {
////            throw new IOException("\"" + movieFolder + "\" is not a directory.");
////        }
////
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
////        String fileExtension = Registry.getInstance().getExtension(fileFormat);
////        movieFile = new File(movieFolder, name + "-" + dateFormat.format(new Date()) + "." + fileExtension);
////        System.out.println("Creating movie file: " + movieFile.getAbsolutePath());
////        return movieFile;
////    }
////
////    public static void startRecord(String methodName) throws Exception {
////        File file = new File("./test-recordings/");
////        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
////        Rectangle captureSize = new Rectangle(0, 0, screenSize.width, screenSize.height);
////
////        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
////                .getDefaultScreenDevice()
////                .getDefaultConfiguration();
////
////        screenRecorder = new ScreenRecorderUtil(gc, captureSize,
////                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
////                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
////                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
////                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
////                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
////                null, file, methodName);
////
////        screenRecorder.start();
////        System.out.println("Screen recording started for " + methodName + ".");
////    }
////
////    public static void stopRecord() throws Exception {
////        if (screenRecorder != null) {
////            screenRecorder.stop();
////            screenRecorder = null;
////            System.out.println("Screen recording stopped.");
////        }
////    }
////
////    public static String getVideoFilePath() {
////        return movieFile != null ? movieFile.getAbsolutePath() : null;
////    }
////}

package utils;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class ScreenRecorderUtil extends ScreenRecorder {
    private static ScreenRecorderUtil screenRecorder;
    private static File movieFile;
    private String name;

    public ScreenRecorderUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                              Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!movieFolder.exists()) {
            if (movieFolder.mkdirs()) {
                System.out.println("Directory created: " + movieFolder.getAbsolutePath());
            } else {
                throw new IOException("Failed to create directory: " + movieFolder.getAbsolutePath());
            }
        } else if (!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileExtension = Registry.getInstance().getExtension(fileFormat);
        movieFile = new File(movieFolder, name + "-" + dateFormat.format(new Date()) + "." + fileExtension);
        System.out.println("Creating movie file: " + movieFile.getAbsolutePath());
        return movieFile;
    }

    public static void startRecord(String methodName) throws Exception {
        File file = new File("./test-recordings/");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle captureSize = new Rectangle(0, 0, screenSize.width, screenSize.height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new ScreenRecorderUtil(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, methodName);

        screenRecorder.start();
        System.out.println("Screen recording started for " + methodName + ".");
    }

    public static void stopRecord() throws Exception {
        if (screenRecorder != null) {
            screenRecorder.stop();
            screenRecorder = null;
            System.out.println("Screen recording stopped.");
        }
    }

    public static String getVideoFilePath() {
        return movieFile != null ? movieFile.getAbsolutePath() : null;
    }
}




