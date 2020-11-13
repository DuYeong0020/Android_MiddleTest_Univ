package com.example.middletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox Cbphone, Cbnotebook;
    EditText EtPhonenum, EtNotebooknum, Etbirth;
    RadioButton Rbcard, Rbcash, Rbbank;
    TextView Tvbanknum, Tvphonenum, Tvnotebooknum, Tvmoney, Tvhow, Tvbirth;
    Button Btnok, Btninit;
    String sMethod, sNoteBook, sPhone;
    int nTotal=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cbnotebook = (CheckBox)findViewById(R.id.cb_notebook);
        Cbphone = (CheckBox)findViewById(R.id.cb_phone);
        Etbirth = (EditText) findViewById(R.id.et_birth);
        EtNotebooknum = (EditText)findViewById(R.id.et_notebooknum);
        EtPhonenum = (EditText)findViewById(R.id.et_phonenum);
        Rbbank = (RadioButton) findViewById(R.id.rb_bank);
        Rbcard = (RadioButton)findViewById(R.id.rb_card);
        Rbcash = (RadioButton)findViewById(R.id.rb_cash);
        Tvbanknum = (TextView) findViewById(R.id.tv_banknum);
        Tvbirth = (TextView)findViewById(R.id.tv_birth);
        Tvhow = (TextView)findViewById(R.id.tv_how);
        Tvmoney = (TextView)findViewById(R.id.tv_money);
        Tvnotebooknum = (TextView)findViewById(R.id.tv_notebooknum);
        Tvphonenum = (TextView)findViewById(R.id.tv_phonenum);
        Btninit = (Button) findViewById(R.id.btn_init);
        Btnok = (Button) findViewById(R.id.btn_ok);



        Rbcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tvbanknum.setVisibility(View.INVISIBLE);
                sMethod="카드";
            }
        });
        Rbcash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tvbanknum.setVisibility(View.INVISIBLE);
                sMethod="현금";
            }
        });
        Rbbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tvbanknum.setVisibility(View.VISIBLE);
                sMethod="계좌이체";
            }
        });
        Btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nTotal=0;
                // 핸드폰 수량 표기
                if(Cbphone.isChecked())
                {
                    sPhone = EtPhonenum.getText().toString();
                    if(sPhone.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "핸드폰 수량", Toast.LENGTH_SHORT ).show();
                    }
                    else{
                        Tvphonenum.setText("핸드폰 : " + sPhone);
                        int nPhone = Integer.parseInt(sPhone);
                        int nPhoneValue = nPhone*2000;
                        nTotal+=nPhoneValue;


                    }

                }
                else{
                    Tvphonenum.setText("핸드폰 : ");
                }
                // 노트 수량 표기
                if(Cbnotebook.isChecked())
                {
                    sNoteBook = EtNotebooknum.getText().toString();
                    Tvnotebooknum.setText("노트 : " + sNoteBook);
                }else
                {
                    Tvphonenum.setText("노트 : ");
                    int nNoteBook = Integer.parseInt(sNoteBook);
                    int nNoteBookValue = nNoteBook*3000;
                    nTotal+=nNoteBookValue;
                }

                // 결제 방법 표시 : 확인 버튼 클릭시 처리 vs 라디오 버튼 눌렸을 시 처리
//                if (Rbbank.isChecked())
//                {
//                    Tvhow.setText("계좌이체");
//                }
//                else if(Rbcard.isChecked())
//                {
//                    Tvhow.setText("카드");
//               }else if(Rbcash.isChecked())
//                {
//                    Tvhow.setText("현금");
//                }
                Tvhow.setText(sMethod);
                Tvmoney.setText(nTotal+"");

                String sYMD = Etbirth.getText().toString();
                String sYYYY = sYMD.substring(0,4);
                String sMM = sYMD.substring(4,6);
                String sDD = sYMD.substring(6,8);
                Tvbirth.setText(sYYYY+"-"+sMM+"-"+sDD);
            }
        });


    }
}