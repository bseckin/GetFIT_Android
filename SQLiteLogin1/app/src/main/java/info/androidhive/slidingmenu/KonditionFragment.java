package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.packone.login.R;

public class KonditionFragment extends Fragment implements View.OnClickListener {


    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private Button startB;
    public TextView text;
    private final long startTime = 60*2 * 1000;
    private long hours = 0;
    private long sek = 0;
    private final long interval = 1 * 1000;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.fragment_kondition, container, false);
        super.onCreate(savedInstanceState);
        startB = (Button) this.rootView.findViewById(R.id.button);
        startB.setOnClickListener(this);
        text = (TextView) this.rootView.findViewById(R.id.timer);
        countDownTimer = new MyCountDownTimer(startTime, interval);
        text.setText(text.getText() + String.valueOf(startTime / 1000));
        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (!timerHasStarted) {
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
        private long totaltime = 60*2 * 1000;
        private int proz = 0;
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            text.setText("Time's up!");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if((millisUntilFinished/1000)/60 >= 1){
                hours = (long)(millisUntilFinished/1000)/60;
                sek = (millisUntilFinished%60);
            }
            this.proz = (int) ((100/this.totaltime)*(millisUntilFinished));
            text.setText("" + hours+":"+millisUntilFinished);
            //Progressbar wird resettet

            this.progress = (ProgressBar) rootView.findViewById(R.id.fat_prog);
            this.progress.setProgress(proz);
        }
    }


}

