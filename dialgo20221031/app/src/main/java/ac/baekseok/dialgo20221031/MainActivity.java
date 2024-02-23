 package ac.baekseok.dialgo20221031;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

 public class MainActivity extends AppCompatActivity {
    RadioGroup rGroup;
    RadioButton rdoDog, rdoCat, rdoRabbit, rdoHores;
    Button btnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("동물 대화상자 띄우기");

        rGroup=(RadioGroup) findViewById(R.id.rGroup);
        rdoDog=(RadioButton) findViewById(R.id.rdoDog);
        rdoCat=(RadioButton) findViewById(R.id.rdoCat);
        rdoRabbit=(RadioButton) findViewById(R.id.rdoRabbit);
        rdoHores=(RadioButton) findViewById(R.id.rdoHores);
        btnImage=(Button) findViewById(R.id.btnImage);

        final Integer[] radioID={R.id.rdoDog, R.id.rdoCat,R.id.rdoRabbit, R.id.rdoHores};

        final Integer[] petId={R.drawable.dog, R.drawable.cat, R.drawable.rabbit, R.drawable.horse};

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=rGroup.getCheckedRadioButtonId();
                View dialogView=(View) View.inflate(MainActivity.this,R.layout.dialog1, null);
                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                ImageView ivPet=(ImageView) dialogView.findViewById(R.id.ivPet);

                //라디오버튼의 선택에 따라서 스위치문으로 분기명령을 작성해 보자.
                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.rdoDog:
                        ivPet.setImageResource(petId[0]);
                        dlg.setTitle("강아지");
                        break;

                    case R.id.rdoCat:
                        ivPet.setImageResource(petId[1]);
                        dlg.setTitle("고양이");
                        break;

                    case R.id.rdoRabbit:
                        ivPet.setImageResource(petId[2]);
                        dlg.setTitle("토끼");
                        break;

                    case R.id.rdoHores:
                        ivPet.setImageResource(petId[3]);
                        dlg.setTitle("말");
                        break;
                }//switch

                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }//onClick()
        });//btnImage
    }//onCreate()
}//MainActivity