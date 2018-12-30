package com.example.souravsaikia.dicegame;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;

/**
 * Created by Sourav Saikia on 30-12-2018.
 */

public class FragmentDialog extends AppCompatDialogFragment {

    String TAG= "EEE";
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.twodices);

        String getArgument1 = getArguments().getString("Turn Score");
        String getArgument2 = getArguments().getString("CPU Score");

        Log.d(TAG,"Turn score is: " + getArgument1);
        Log.d(TAG,"CPU score is: " + getArgument1);


        builder.setTitle("Final Scores");
        builder.setMessage("Your Score: " +  getArgument1 +"\n CPU Score: " + getArgument2).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }

}
