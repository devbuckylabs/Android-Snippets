PackageManager pm = getPackageManager();
 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            requestPermissions(new String[]{Manifest.permission.WRITE_SETTINGS}, 1);
            requestPermissions(new String[]{Manifest.permission.MANAGE_DOCUMENTS}, 1);
            //   requestPermissions(new String[]{android.Manifest.permission.F}, 1);

        }

Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent .addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> apps = context.getPackageManager().queryIntentActivities( intent , 0);
        Collections.sort(apps,new ResolveInfo.DisplayNameComparator(pm)); 


for (ResolveInfo info : apps) {

            try {
                File f1 =new File( info.activityInfo.applicationInfo.publicSourceDir);
                String rootPath = Environment.getExternalStorageDirectory()
                        .getAbsolutePath() + "/App_Backup/";
                String file_name = info.loadLabel(getPackageManager()).toString();
                //File f2 = new File(Environment.getExternalStorageDirectory().toString()+"/Folder");
                File f2 = new File(rootPath);
                if (!f1.exists()) {
                    f1.mkdirs();
                }
                f2 = new File(f2.getPath()+"/"+file_name+".apk");
                f2.createNewFile();
                InputStream in = new FileInputStream(f1);
                FileOutputStream out = new FileOutputStream(f2);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0){
                    out.write(buf, 0, len);
                }
                out.flush();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
