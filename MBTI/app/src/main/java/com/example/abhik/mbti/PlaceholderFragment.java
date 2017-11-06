package com.example.abhik.mbti;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    int mNum;

    Context context;

    private ArrayList<String> list_ques, list_A, list_B;
    private ArrayList<Integer> list_ID;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static final String TAG = "ques";
    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        Log.d("number", "newInstance: "+sectionNumber);
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
//        if (getArguments()!=null){
//
//            mNum = getArguments().getInt(ARG_SECTION_NUMBER);
//
//            Log.d("lol", "onCreate: "+mNum);
//        }

        Log.d("lol", "onCreate: "+mNum);


        DatabaseAccess databaseAccess = DatabaseAccess.getInstance((MBTIquestionarre) getActivity());
        databaseAccess.open();


        list_ques = (ArrayList<String>) databaseAccess.getQuestion();
        list_A = (ArrayList<String>) databaseAccess.getOptionA();
        list_B = (ArrayList<String>) databaseAccess.getOptionB();
        list_ID = (ArrayList<Integer>) databaseAccess.getID();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_mbtiquestionarre, container, false);
        TextView tv1  = (TextView) rootView.findViewById(R.id.tv_qno);
        TextView tv2 = (TextView) rootView.findViewById(R.id.tv_section_label);
        RadioButton rb1 = (RadioButton) rootView.findViewById(R.id.rb_choice1);
        RadioButton rb2 = (RadioButton) rootView.findViewById(R.id.rb_choice2);
        Bundle args = getArguments();
        int x =args.getInt(ARG_SECTION_NUMBER);
        Log.d("don", "onCreateView: "+x);

        Log.d("boob", "onCreateView: "+(args.getInt(ARG_SECTION_NUMBER))+" "
                +list_ID.get(0)+" "
                +list_ques.get(0)+" "
                +list_A.get(0)+" "
                +list_B.get(0));



        for (int j = 1;j<70;j++)
        {
            String s1 = list_ques.get(j);
            String s2 = list_A.get(j);
            String s3 = list_B.get(j);
            Integer i = list_ID.get(j);
            String s4 = i.toString();


            if(x==2){
                Log.d("nino", "onCreateView: "+x);
                tv1.setText(s4);
                tv2.setText(s1);
                rb1.setText(s2);
                rb2.setText(s3);
                Log.d("nino", "onCreateView: "+list_ques.get(0));
            }

            else if(x==(j+2))
            {
                Log.d("nino", "onCreateView: "+x);
                tv1.setText(s4);
                tv2.setText(s1);
                rb1.setText(s2);
                rb2.setText(s3);
            }

        }



        Log.d(TAG, "onCreateView: "+args.getInt("page_position"));



        return rootView;
    }
}
