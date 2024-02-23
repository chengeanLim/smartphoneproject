package ac.baekseok.dialog20221128_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvEmail;
    Button button1;
    EditText dlgEdtName, dloEdtEmail;
    TextView toastText;
    View dialogView, toastView; //dialog.xml toast.xml을 inflate(확장)해서 사용하기 위한 View 인스턴스 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보입력(임찬근)");
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        button1 = (Button) findViewById(R.id.button1);

        //button1 [여기 클릭] 누르면 dialog.xml이 대화상자로 떠야함
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);//대화상자 인스턴스 생성
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                        dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt2);
                        tvName.setText(dlgEdtName.getText().toString());
                        tvEmail.setText(dloEdtEmail.getText().toString());
                    }//onClick
                }); //버튼클릭시 대화상자 사라짐. 클릭했을 때 안함.
                //사용자 이름 입력 후 MainActivity에 글자 설정, 확인버튼을 누르면 동작을 추가해야함

                dlg.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this); //토스트메세지 사용, 인스턴스 생성
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast, null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다."); //글자 설정
                        toast.setView(toastView); //toast.xml을 설정
                        toast.show();//토스트메세지 보이기
                    }//OnClickListener()
                });//취소버튼을 누르면 toast.xml이 취소되었습니다. 빨간 메세지로 뜸

                dlg.show();
            }//onClcik
        });//button1
    }//onCreate
}//MainActivity()