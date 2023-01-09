package com.example.day13workshop.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class IOUtil {
    public static void createDir(String path){
        File dir = new File(path);
        boolean isCreated = dir.mkdir();
        if(isCreated){
            String osname = System.getProperty("os.name");
            if(!osname.contains("Windows")){
                try {
                    String perm = "rwxrwx---";
                    Set<PosixFilePermission> permissions = PosixFilePermissions.fromString(perm);
                    Files.setPosixFilePermissions(dir.toPath(), permissions);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
    }
}
