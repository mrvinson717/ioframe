package com.fjw.myapp.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.fjw.myapp.Interface.DiologInterface;
import com.fjw.myapp.R;

/**
 * Created by 范佳伟 on 2017/8/1.
 */

public class IoDialogView extends Dialog {
   private Context context;
    private Button btn_sure,btn_cancel;
    private String title,text1,text2;
    private TextView txt_title,txt1,txt2;
    private DialogClickListener dialogClickListener;

    public IoDialogView(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected IoDialogView(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    public IoDialogView(Context context,String title,String text1,String text2,DialogClickListener dialogClickListener) {
        super(context);
        this.dialogClickListener=dialogClickListener;
        this.context=context;
        this.title=title;
        this.text1=text1;
        this.text2=text2;
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams wAttrs = window.getAttributes();
        wAttrs.gravity = Gravity.CENTER;
        window.setWindowAnimations(android.R.style.Animation_Dialog);
        window.setBackgroundDrawable(context.getResources().getDrawable((android.R.color.transparent)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.io_dialog);
        initView();
        initData();


    }

    private void initData() {
        txt_title.setText(title);
        txt1.setText(text1);
        txt2.setText(text2);
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogClickListener.sure();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogClickListener.cancel();
            }
        });
    }

    private void initView() {

        btn_sure=(Button) findViewById(R.id.btn_sure);
        btn_cancel=(Button) findViewById(R.id.btn_cancel);
        txt1= (TextView) findViewById(R.id.txt1);
        txt2= (TextView) findViewById(R.id.txt2);
        txt_title= (TextView) findViewById(R.id.txt_title);
    }

    public interface DialogClickListener {
         void sure();

         void cancel();
    }

}
