package com.example.class04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.kofigyan.stateprogressbar.components.StateItem;
import com.kofigyan.stateprogressbar.listeners.OnStateItemClickListener;

public class MainActivity extends AppCompatActivity {

    private StateProgressBar stateProgressBar;
    String[] stateTitle = {"Registation", "Success"};
    private FrameLayout frameLayout;

    private RegistationFragment registationFragment;
    private FragmentSuccess fragmentSuccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frameLayout = findViewById(R.id.frameId);
        stateProgressBar = findViewById(R.id.state_ProgressBar_Id);


        registationFragment = new RegistationFragment();
        fragmentSuccess =new FragmentSuccess();

        setFragment(registationFragment);


        stateProgressBar.setStateDescriptionData(stateTitle);
        stateProgressBar.setCurrentStateDescriptionColor(Color.parseColor("#009688"));

    }


    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameId, fragment);
        fragmentTransaction.commit();
    }

    public void nextState(){

        switch (stateProgressBar.getCurrentStateNumber()) {
            case 1:
                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                setFragment(fragmentSuccess);
                break;

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu,menu);



        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.shareId:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                return true;

                case R.id.settingId:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;

                default:
                    return false;

        }
    }
}

