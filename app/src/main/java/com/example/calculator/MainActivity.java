package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    private TextView previousCalculation;
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);
//        Ko hien thi ban phim
        display.setShowSoftInputOnFocus(false);
    }
    private  void updateText(String strToAdd){

        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        //        Hiển thị chuỗi cũ + mới một lúc
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
        display.setSelection(cursorPos+strToAdd.length());

    }

    public void ZeroBtnPush(View view){
        updateText(getResources().getString(R.string.zeroText));
    }
    public void OneBtnPush(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void TwoBtnPush(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void ThreeBtnPush(View view){
        updateText(getResources().getString(R.string.threeText));
    }
    public void FourBtnPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }
    public void FiveBtnPush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void SixBtnPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }
    public void SevenBtnPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void EightBtnPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }
    public void NineBtnPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }
    public void MultiplyBtnPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void DivideBtnPush(View view){
        updateText(getResources().getString(R.string.divideText));
    }
    public void SubtractBtnPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }
    public void AddBtnPush(View view){
        updateText(getResources().getString(R.string.addText));
    }
    public void DecimalBtnPush(View view){
        updateText(getResources().getString(R.string.decimalText));
    }
    public void ClearBtnPush(View view){
        display.setText("");
        previousCalculation.setText("");
    }
    public void BackSpaceBtnPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos !=0 && textLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
//          To delete, replace the symbol you want to delete with a space
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void ParOpenBtnPush(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void ParCloseBtnPush(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
    public void EqualsBtnPush(View view){
        String userExp = display.getText().toString();
        previousCalculation.setText(userExp);
        userExp = userExp.replaceAll(getResources().getString(R.string.divideText),"/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText),"*");
        Expression exp = new Expression(userExp);

        String res = String.valueOf(exp.calculate());
        display.setText(res);


        display.setSelection(res.length());
    } public void trigSinBTNPush(View view){
        updateText("sin(");
    }

    public void trigCosBTNPush(View view){
        updateText("cos(");
    }

    public void trigTanBTNPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){
        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){
        updateText("arccos(");
    }

    public void trigArcTanBTNPush(View view){
        updateText("arctan(");
    }

    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }

    public void logBTNPush(View view){
        updateText("log(");
    }

    public void sqrtBTNPush(View view){
        updateText("sqrt(");
    }

    public void absBTNPush(View view){
        updateText("abs(");
    }

    public void piBTNPush(View view){
        updateText("pi");
    }

    public void eBTNPush(View view){
        updateText("e");
    }

    public void xSquaredBTNPush(View view){
        updateText("^(2)");
    }

    public void xPowerYBTNPush(View view){
        updateText("^(");
    }

    public void primeBTNPush(View view){
        updateText("ispr(");
    }
}