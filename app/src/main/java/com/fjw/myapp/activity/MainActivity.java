package com.fjw.myapp.activity;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;


import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;


import com.fjw.myapp.Interface.DiologInterface;
import com.fjw.myapp.fragment.MainFragment;
import com.fjw.myapp.fragment.MyFragment;
import com.fjw.myapp.fragment.PicGalleryFragment;
import com.fjw.myapp.R;
import com.fjw.myapp.dummy.DummyContent;
import com.fjw.myapp.util.ToastUtil;
import com.fjw.myapp.view.IoDialogView;
import com.fjw.myapp.zxing.CaptureActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener  {
    private static final int REQUEST_CODE_SCAN = 0x0000;
    private static final int MY_PERMISSIONS_REQUEST_CALL_CAMERA = 1;//请求码
    private static final String DECODED_CONTENT_KEY = "codedContent";
   // private static final String DECODED_BITMAP_KEY = "codedBitmap";
    private ArrayList<Fragment> mTabs = new ArrayList<Fragment>();

    private ImageView icon1,icon2,icon3,icon4;
    private android.app.FragmentManager fm;
    private android.app.FragmentTransaction ft;
    private int currentIndex = 0;

    private Fragment mCurrentFrgment;
    private ImageView icon5;
    private IoDialogView dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initState();

        initView();
        initListener();
        initData();
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        changeTab(0);

        dialog=new IoDialogView(MainActivity.this, "解绑", "文字叙述1", "文字叙述2", new IoDialogView.DialogClickListener() {
            @Override
            public void sure() {
                ToastUtil.showShort(MainActivity.this,"sure");

            }

            @Override
            public void cancel() {
                ToastUtil.showShort(MainActivity.this,"cancel");
                dialog.dismiss();
            }
        });

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

           getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }



    private void initData() {


        mTabs.add(new MainFragment());
        mTabs.add(new PicGalleryFragment());
        mTabs.add(new PicGalleryFragment());
        mTabs.add(new MyFragment());

    }

    private void initListener() {
      icon1.setOnClickListener(this);
      icon2.setOnClickListener(this);
      icon3.setOnClickListener(this);
      icon4.setOnClickListener(this);
        icon5.setOnClickListener(this);



    }

    private void initView() {

        icon1= (ImageView) findViewById(R.id.imageView1);
        icon2= (ImageView) findViewById(R.id.imageView2);
        icon3= (ImageView) findViewById(R.id.imageView3);
        icon4= (ImageView) findViewById(R.id.imageView4);
        icon5= (ImageView) findViewById(R.id.imageView5);

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        clickTab(v);
    }

    private void clickTab(View v) {
        switch (v.getId()){

                case R.id.imageView1:

                    changeTab(0);
                    break;
                case R.id.imageView2:
                    changeTab(1);

                    break;
                case R.id.imageView3:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            // 如果没有授权，则请求授权
                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CALL_CAMERA);
                        } else {
                            // 有授权，直接开启摄像头
                            Intent intent = new Intent(MainActivity.this,
                                    CaptureActivity.class);
                            startActivityForResult(intent, REQUEST_CODE_SCAN);
                        }
                    }


                    break;
                case R.id.imageView4:
                   // startActivity(new Intent(MainActivity.this,SearchPicActivity.class));

                    break;
               case R.id.imageView5:
                    changeTab(3);

                break;


        }


    }



    private void changeTab(int index) {
                 currentIndex = index;
                  FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                  if (null != mCurrentFrgment) {
                          ft.hide(mCurrentFrgment);
                      }

                 Fragment fragment = getSupportFragmentManager().findFragmentByTag(mTabs.get(currentIndex).getClass().getName());
        
                  if (null == fragment) {

                          fragment = mTabs.get(index);
                      }
                  mCurrentFrgment = fragment;


                if (!fragment.isAdded()) {
                         ft.add(R.id.fragment, fragment, fragment.getClass().getName());
                      } else {
                          ft.show(fragment);
                      }
                 ft.commit();
              }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // 判断请求码
        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_CAMERA) {
            //grantResults授权结果
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 成功，开启摄像头
                Intent  intent = new Intent(MainActivity.this,
                        CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
            } else {
                // 授权失败
                Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
               /* Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + MainActivity.this.getPackageName()));
                MainActivity.this.startActivityForResult(intent, 1028);*/
                // this.finish();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(DECODED_CONTENT_KEY);
                //Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);
                ToastUtil.showShort(MainActivity.this,content);

            }
        }
    }
}
