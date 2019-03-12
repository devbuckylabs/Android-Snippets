try {
        String rootPath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/App_Backup/";
        File root = new File(rootPath);
        if (!root.exists()) {
            root.mkdirs();
        }
        File f = new File(rootPath + s);
        if (f.exists()) {
            f.delete();
        }
        f.createNewFile();

        FileOutputStream out = new FileOutputStream(f);

        out.flush();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
