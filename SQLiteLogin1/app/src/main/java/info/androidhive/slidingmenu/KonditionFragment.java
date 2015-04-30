package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.packone.login.R;

public class KonditionFragment extends Fragment implements View.OnClickListener {

    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private Button startB;
    public TextView text;
    private EditText timerEditText;



    private int time;
    private long startTime;
    private long hours = 0;
    private long sek = 0;
    private long interval = 1 * 1000;
    private View rootView;

    public KonditionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.fragment_kondition, container, false);

        super.onCreate(savedInstanceState);
        startB = (Button) this.rootView.findViewById(R.id.button);
        startB.setOnClickListener(this);

        return rootView;
    }
    public int getTime() {
        return time;
    }
    @Override
    public void onClick(View v) {
        if (!timerHasStarted) {
            this.timerEditText = (EditText) this.rootView.findViewById(R.id.editTimer);
            this.time = Integer.parseInt(timerEditText.getText().toString());

            this.startTime = this.time*1* 1000;

            text = (TextView) this.rootView.findViewById(R.id.timer);
            countDownTimer = new MyCountDownTimer(startTime, interval);
            text.setText(text.getText() + String.valueOf(startTime / 1000));
            countDownTimer.start();
            timerHasStarted = true;
            startB.setText("STOP");
        } else {
            countDownTimer.cancel();
            timerHasStarted = false;
            startB.setText("RESTART");
        }
    }

    public class MyCountDownTimer extends CountDownTimer {
        private ProgressBar progress;
        private long totaltime = getTime()*1;
        private double proz = 0;
        private String sekstr = "";
        private String hourstr = "";
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            text.setText("Time's up!");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if((millisUntilFinished/1000)/60 > 1){
                hours = (long)(millisUntilFinished/1000)/60;
                sek = ((millisUntilFinished/1000)%60);
            }else if((millisUntilFinished/1000)/60 <= 1){
                hours = (long)(millisUntilFinished/1000)/60;
                sek = ((millisUntilFinished/1000)%60);
            }
            double zaehler = (millisUntilFinished/1000);
            double x = 100.0/getTime();
            this.proz = (x * zaehler);
            /**hourstr = String.valueOf(hours);

            this.proz = (x * zaehler);
            if (sek < 10){
                sekstr = "0"+sek;
                text.setText("" + hourstr+":"+sekstr);
            } else if(hours < 10){
                hourstr = "0"+hours;
                text.setText("" + hourstr+":"+sekstr);
            } else if(hours >=10){*/
                text.setText("" + hours+":"+sek);
            //}

            //Progressbar wird resettet

            this.progress = (ProgressBar) rootView.findViewById(R.id.fat_prog);

            this.progress.setProgress((int) this.proz);
        }
    }


}

