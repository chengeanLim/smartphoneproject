package ac.baekseok.dialog1018;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = (Button) findViewById(R.id.button1);

        //button1을 누르면 대화상자가띄워지게 설정
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //사용클래스 대화상자클래스
                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목을 설정하는 란"); //제목을 설정하는 메소드
                dlg.setMessage("이곳은 내용을 설정하는 부분입니다."); //내용을 설정하는 메소드
                dlg.setIcon(R.drawable.icon1);//제목에 보여지는 아이콘이미지설정
                
                //[혹인]버튼을 대화상자 위에 배치하는 설정
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //[확인] 버튼을 눌렀을 때 동작: 토스트 메세지로 확인버튼이 눌렸어요" 안내멘트를 설정
                        Toast.makeText(getApplicationContext(), "확인버튼이 눌렸어요.", Toast.LENGTH_SHORT).show();
                    }//OnClick()
                }); //setPositiveButton

                //취소버튼이 눌리는 동작 설정
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소버튼이 눌렸어요", Toast.LENGTH_SHORT).show();
                    }//onClick()
                });//NegativeButton

                dlg.show(); //속성을 설정한 대화상자를 보여주는 메소드
            }//onClick
        });//button1
    }//onCreate()
}//MainActivity