package cn.pedant.SweetAlert;


import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.List;



public class SweetAlertDialog extends Dialog implements View.OnClickListener {
    private View mDialogView;
    private AnimationSet mModalInAnim;
    private AnimationSet mModalOutAnim;
    private Animation mOverlayOutAnim;
    private Animation mErrorInAnim;
    private AnimationSet mErrorXInAnim;
    private AnimationSet mSuccessLayoutAnimSet;
    private Animation mSuccessBowAnim;
    private TextView mTextMessagenView;
    private TextView mTitleTextView;
    private TextView mContentTextView;
    private TextView mConfirmationTextView;
    private TextView NameMessager;
    private String mNameMessager;
    private String mTextMessagen;
    private String mTitleText;
    private String mContentText;
    private String mConfirmationText;
    private String mCpfText;
    private boolean mShowCancel;
    private boolean mShowContent;
    private boolean mShowConfirm;
    private boolean mShowCpf;
    private boolean mShowPlaca;
    private EditText mInputText4;
    private EditText mInputText5;
    private EditText Numeros ;
    private EditText Letras ;
    private EditText Messagen ;

    private String mCancelText;
    private String mConfirmText;
    private int mAlertType;
    private FrameLayout mErrorFrame;
    private FrameLayout mSuccessFrame;
    private FrameLayout mProgressFrame;
    private SuccessTickView mSuccessTick;
    private ImageView mErrorX;
    private View mSuccessLeftMask;
    private View mSuccessRightMask;
    private Drawable mCustomImgDrawable;
    private ImageView mCustomImage;
    private Button mConfirmButton;
    private Button mCancelButton;
    private ProgressHelper mProgressHelper;
    private FrameLayout mWarningFrame;
    private OnSweetClickListener mCancelClickListener;
    private OnSweetClickListener mConfirmClickListener;
    private OnSweetClickListener mBraFlagClickListener;
    private OnSweetClickListener mOurFlagClickListener;



    private boolean mCloseFromCancel;

    public static int checksweetalert = 0;

    public static final int NORMAL_TYPE = 0;
    public static final int ERROR_TYPE = 1;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    public static final int CUSTOM_IMAGE_TYPE = 4;
    public static final int PROGRESS_TYPE = 5;

    // ----------------------------------------------------------

    private static int layoutID;
    // toggleSwitcher
    private Button Change;

    //    InputText for
    private EditText mInputText;
    private EditText placa1;
    private EditText chassi;
    private EditText renavem;
    private EditText cpf;
    private EditText cnh;
    private EditText CPFPesquisar;

    private EditText mInputText2;
    private EditText mInputText3;

    private EditText placaR;
    private EditText autoR;

    private  TextView x;

    public static void setLayout(int layoutID1) {
        layoutID = layoutID1;
    }


    public String getInputText() {
        return mInputText.getText().toString();
    }
    public String getInputplaca1() {  return placa1.getText().toString(); }

    public String getInputchassi() {
        return chassi.getText().toString();
    }
    public String getInputrenavem () {
        return renavem.getText().toString();
    }
    public String getInputcpf(){ return cpf.getText().toString();}
    public String getInputcnh(){ return cpf.getText().toString();}
    public String getCPFPesquisar(){ return CPFPesquisar.getText().toString();}
    public String getInputText2(){
        return mInputText2.getText().toString();
    }
    public String getInputText3(){
        return mInputText3.getText().toString();
    }
    public String getInputText4(){
        return mInputText4.getText().toString();
    }
    public String getInputText5(){
        return mInputText5.getText().toString();
    }
    public String getInputplacaR() {
        return placaR.getText().toString();
    }
    public String getInputautoR() { return autoR.getText().toString();  }
    public String getLetras () { return Letras.getText().toString();}
    public String getNumeros () { return Numeros.getText().toString();}


    public EditText getInputElement4(){return mInputText4;}
    public EditText getInputElement5(){return mInputText5;}

    public EditText getInputElement () {
        return mInputText;
    }
    public EditText getplaca1Element () {
        return placa1;
    }
    public EditText getchassiElement () {
        return chassi;
    }
    public EditText getrenavemElement () {
        return renavem;
    }
    public EditText getcpfElement () {
        return cpf;
    }
    public EditText getcnhElement () {
        return cnh;
    }
    public EditText getCPFPesquisarElement () {
        return CPFPesquisar;
    }
    public EditText getInputElement2(){ return mInputText2;}

    public EditText getInputElement3()
    {
        return mInputText3;
    }

    public EditText getplacaRElement () {
        return placaR;
    }
    public EditText getAutoRElement () {
        return autoR;
    }
    public void mayuscula(){

        Letras.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        Numeros.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_VARIATION_NORMAL);
    }
    // ----------------------------------------------------------

    public static interface OnSweetClickListener {
        public void onClick (SweetAlertDialog sweetAlertDialog);
    }

    public SweetAlertDialog(Context context) {
        this(context, NORMAL_TYPE);
    }

    public SweetAlertDialog(Context context, int alertType) {
        super(context, R.style.alert_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        mProgressHelper = new ProgressHelper(context);
        mAlertType = alertType;
        mErrorInAnim = OptAnimationLoader.loadAnimation(getContext(), R.anim.error_frame_in);
        mErrorXInAnim = (AnimationSet)OptAnimationLoader.loadAnimation(getContext(), R.anim.error_x_in);
        // 2.3.x system don't support alpha-animation on layer-list drawable
        // remove it from animation set
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
            List<Animation> childAnims = mErrorXInAnim.getAnimations();
            int idx = 0;
            for (;idx < childAnims.size();idx++) {
                if (childAnims.get(idx) instanceof AlphaAnimation) {
                    break;
                }
            }
            if (idx < childAnims.size()) {
                childAnims.remove(idx);
            }
        }
        mSuccessBowAnim = OptAnimationLoader.loadAnimation(getContext(), R.anim.success_bow_roate);
        mSuccessLayoutAnimSet = (AnimationSet)OptAnimationLoader.loadAnimation(getContext(), R.anim.success_mask_layout);
        mModalInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_in);
        mModalOutAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_out);
        mModalOutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.setVisibility(View.GONE);
                mDialogView.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mCloseFromCancel) {
                            SweetAlertDialog.super.cancel();
                        } else {
                            SweetAlertDialog.super.dismiss();
                        }
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        // dialog overlay fade out
        mOverlayOutAnim = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                WindowManager.LayoutParams wlp = getWindow().getAttributes();
                wlp.alpha = 1 - interpolatedTime;
                getWindow().setAttributes(wlp);
            }
        };
        mOverlayOutAnim.setDuration(120);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // -------------------------------------------------------------------------------
        setContentView(layoutID);
        mInputText = (EditText) findViewById(R.id.input_text);

        Messagen   = (EditText) findViewById(R.id.editmessagen);
        NameMessager   = (TextView) findViewById(R.id.namemessager);


        Letras   = (EditText) findViewById(R.id.txtletras);
        Numeros   = (EditText) findViewById(R.id.txtnumeros);

        placa1 = (EditText) findViewById(R.id.placa1);
        chassi = (EditText) findViewById(R.id.chassi);
        renavem = (EditText) findViewById(R.id.renavem);
        cpf = (EditText) findViewById(R.id.cpf);
        cnh = (EditText) findViewById(R.id.cnh);
        CPFPesquisar = (EditText) findViewById(R.id.Cpf_text);
        mInputText2 =(EditText)findViewById(R.id.input_text2);
        mInputText3 =(EditText)findViewById(R.id.input_text3);
        mInputText4=(EditText)findViewById(R.id.input_text4);
        mInputText5=(EditText)findViewById(R.id.input_text5);

        placaR = (EditText) findViewById(R.id.placaR);
        autoR = (EditText) findViewById(R.id.autoR);

        // -------------------------------------------------------------------------------

        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        mTitleTextView = (TextView)findViewById(R.id.title_text);
        mContentTextView = (TextView)findViewById(R.id.content_text);
        mConfirmationTextView=(TextView)findViewById(R.id.confirm_text);
        mErrorFrame = (FrameLayout)findViewById(R.id.error_frame);
        mErrorX = (ImageView)mErrorFrame.findViewById(R.id.error_x);
        mSuccessFrame = (FrameLayout)findViewById(R.id.success_frame);
        mProgressFrame = (FrameLayout)findViewById(R.id.progress_dialog);
        mSuccessTick = (SuccessTickView)mSuccessFrame.findViewById(R.id.success_tick);
        mSuccessLeftMask = mSuccessFrame.findViewById(R.id.mask_left);
        mSuccessRightMask = mSuccessFrame.findViewById(R.id.mask_right);
        mCustomImage = (ImageView)findViewById(R.id.custom_image);
        mWarningFrame = (FrameLayout)findViewById(R.id.warning_frame);
        mConfirmButton = (Button)findViewById(R.id.confirm_button);
        mCancelButton = (Button)findViewById(R.id.cancel_button);
        mProgressHelper.setProgressWheel((ProgressWheel)findViewById(R.id.progressWheel));
        mConfirmButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);

        setNameMessager(mNameMessager);
        setEditMessangen(mTextMessagen);
        setTitleText(mTitleText);
        setContentText(mContentText);
        setCpfText(mCpfText);
        setCancelText(mCancelText);
        setConfirmText(mConfirmText);
        changeAlertType(mAlertType, true);

        if (checksweetalert == 1) {
            PassAutoEdit();
        }

        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            AssetFileDescriptor afd;
            if(mAlertType == ERROR_TYPE){
                afd = getContext().getResources().openRawResourceFd(R.raw.finished_task);
            }else {
                afd = getContext().getResources().openRawResourceFd(R.raw.all_eyes_on_me);
            }
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void PassAutoEdit ( ) {

        Letras.addTextChangedListener(new TextWatcher() {
            StringBuilder sb=new StringBuilder();
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if(sb.length()==0&Letras.length()==3)   {
                    sb.append(s);
                    Letras.clearFocus();
                    Numeros.requestFocus();
                    Numeros.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(sb.length()==0){
                    Letras.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(sb.length()==3)
                {
                    sb.deleteCharAt(0);
                }
            }
        });
    }


    private void restore () {
        mCustomImage.setVisibility(View.GONE);
        mErrorFrame.setVisibility(View.GONE);
        mSuccessFrame.setVisibility(View.GONE);
        mWarningFrame.setVisibility(View.GONE);
        mProgressFrame.setVisibility(View.GONE);
        mConfirmButton.setVisibility(View.VISIBLE);

        mConfirmButton.setBackgroundResource(R.drawable.blue_button_background);
        mErrorFrame.clearAnimation();
        mErrorX.clearAnimation();
        mSuccessTick.clearAnimation();
        mSuccessLeftMask.clearAnimation();
        mSuccessRightMask.clearAnimation();
    }

    private void playAnimation () {
        if (mAlertType == ERROR_TYPE) {
            mErrorFrame.startAnimation(mErrorInAnim);
            mErrorX.startAnimation(mErrorXInAnim);
        } else if (mAlertType == SUCCESS_TYPE) {
            mSuccessTick.startTickAnim();
            mSuccessRightMask.startAnimation(mSuccessBowAnim);
        }
    }

    private void changeAlertType(int alertType, boolean fromCreate) {
        mAlertType = alertType;
        // call after created views
        if (mDialogView != null) {
            if (!fromCreate) {
                // restore all of views state before switching alert type
                restore();
            }
            switch (mAlertType) {
                case ERROR_TYPE:
                    mErrorFrame.setVisibility(View.VISIBLE);
                    break;
                case SUCCESS_TYPE:
                    mSuccessFrame.setVisibility(View.VISIBLE);
                    // initial rotate layout of success mask
                    mSuccessLeftMask.startAnimation(mSuccessLayoutAnimSet.getAnimations().get(0));
                    mSuccessRightMask.startAnimation(mSuccessLayoutAnimSet.getAnimations().get(1));
                    break;
                case WARNING_TYPE:
                    mConfirmButton.setBackgroundResource(R.drawable.red_button_background);
                    mWarningFrame.setVisibility(View.VISIBLE);
                    break;
                case CUSTOM_IMAGE_TYPE:
                    setCustomImage(mCustomImgDrawable);
                    break;
                case PROGRESS_TYPE:
                    mProgressFrame.setVisibility(View.VISIBLE);
                    mConfirmButton.setVisibility(View.GONE);
                    break;
            }
            if (!fromCreate) {
                playAnimation();
            }
        }
    }

    public int getAlerType () {
        return mAlertType;
    }

    public void changeAlertType(int alertType) {
        changeAlertType(alertType, false);
    }


    public String getTitleText () {
        return mTitleText;
    }

    public SweetAlertDialog setNameMessager(String text){
        mNameMessager = text;
        if (NameMessager != null && mNameMessager != null) {
            NameMessager.setText(mNameMessager);
            NameMessager.setEnabled(false);
        }
        return this;
    }

    public void setEditMessangenHint(String hint){
        Messagen.setHint(hint);
    }

    public SweetAlertDialog setEditMessangen (String text){
        mTextMessagen = text;
        if (Messagen != null && mTextMessagen != null) {
            Messagen.setText(mTextMessagen);
            Messagen.setEnabled(false);
        }
        return this;
    }

    public String getEditMessangenText(){
        if(Messagen == null) return null;
        return Messagen.getText().toString();
    }

    public SweetAlertDialog setTitleText (String text) {
        mTitleText = text;
        if (mTitleTextView != null && mTitleText != null) {
            mTitleTextView.setText(mTitleText);
            mTitleTextView.setVisibility("".equals(mTitleText) ? View.INVISIBLE : View.VISIBLE);
        }
        return this;
    }

    public SweetAlertDialog setCustomImage (Drawable drawable) {
        mCustomImgDrawable = drawable;
        if (mCustomImage != null && mCustomImgDrawable != null) {
            mCustomImage.setVisibility(View.VISIBLE);
            mCustomImage.setImageDrawable(mCustomImgDrawable);
        }
        return this;
    }

    public SweetAlertDialog setCustomImage (int resourceId) {
        return setCustomImage(getContext().getResources().getDrawable(resourceId));
    }

    public String getContentText () {
        return mContentText;
    }

    public SweetAlertDialog setContentText (String text) {
        mContentText = text;
        if (mContentTextView != null && mContentText != null) {
            showContentText(true);
            mContentTextView.setText(mContentText);
        }
        return this;
    }

    public SweetAlertDialog setConfirmationText (String text) {
        mConfirmationText = text;
        if (mConfirmationTextView != null && mConfirmationText != null) {
            showConfirmationText(true);
            mConfirmationTextView.setText(mConfirmationText);
        }
        return this;
    }

    public SweetAlertDialog setCpfText (String text) {
        mCpfText = text;
        if (CPFPesquisar != null && mCpfText != null) {
            showCpfText(true);
            CPFPesquisar.setText(mCpfText);
        }
        return this;
    }

    public boolean isShowCancelButton () {
        return mShowCancel;
    }

    public SweetAlertDialog showCancelButton (boolean isShow) {
        mShowCancel = isShow;
        if (mCancelButton != null) {
            mCancelButton.setVisibility(mShowCancel ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    public boolean isShowContentText () {
        return mShowContent;
    }




    public SweetAlertDialog showContentText (boolean isShow) {
        mShowContent = isShow;
        if (mContentTextView != null) {
            mContentTextView.setVisibility(mShowContent ? View.VISIBLE : View.GONE);
        }
        return this;
    }
    public SweetAlertDialog showConfirmationText (boolean isShow) {
        mShowConfirm = isShow;
        if (mConfirmationTextView != null) {
            mConfirmationTextView.setVisibility(mShowConfirm ? View.VISIBLE : View.GONE);
        }
        return this;
    }


    public String getCpfText () {
        return mCpfText;
    }

    public SweetAlertDialog showCpfText (boolean isShow) {
        mShowCpf = isShow;
        if (CPFPesquisar != null) {
            CPFPesquisar.setVisibility(mShowCpf ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    public String getCancelText () {
        return mCancelText;
    }

    public SweetAlertDialog setCancelText (String text) {
        mCancelText = text;
        if (mCancelButton != null && mCancelText != null) {
            showCancelButton(true);
            mCancelButton.setText(mCancelText);
        }
        return this;
    }

    public String getConfirmText () {
        return mConfirmText;
    }

    public SweetAlertDialog setConfirmText (String text) {
        mConfirmText = text;
        if (mConfirmButton != null && mConfirmText != null) {
            mConfirmButton.setText(mConfirmText);
        }
        return this;
    }

    public SweetAlertDialog setCancelClickListener (OnSweetClickListener listener) {
        mCancelClickListener = listener;
        return this;
    }

    public SweetAlertDialog setConfirmClickListener (OnSweetClickListener listener) {
        mConfirmClickListener = listener;
        return this;
    }


    protected void onStart() {
        mDialogView.startAnimation(mModalInAnim);
        playAnimation();
        if(layoutID== R.layout.alert_dialog4){
            mayuscula();
        }
        if(layoutID==R.layout.alert_dialog8)
        {
            mayuscula();
        }
    }

    /**
     * The real Dialog.cancel() will be invoked async-ly after the animation finishes.
     */
    @Override
    public void cancel() {
        dismissWithAnimation(true);
    }

    /**
     * The real Dialog.dismiss() will be invoked async-ly after the animation finishes.
     */
    public void dismissWithAnimation() {
        dismissWithAnimation(false);
    }

    private void dismissWithAnimation(boolean fromCancel) {
        mCloseFromCancel = fromCancel;
        mConfirmButton.startAnimation(mOverlayOutAnim);
        mDialogView.startAnimation(mModalOutAnim);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cancel_button) {
            if (mCancelClickListener != null) {
                mCancelClickListener.onClick(SweetAlertDialog.this);
            } else {
                dismissWithAnimation();
            }
        } else if (v.getId() == R.id.confirm_button) {
            if (mConfirmClickListener != null) {
                mConfirmClickListener.onClick(SweetAlertDialog.this);
            } else {
                dismissWithAnimation();
            }
        }

    }

    public ProgressHelper getProgressHelper () {
        return mProgressHelper;
    }
}
