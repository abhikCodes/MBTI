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
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;

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
        Bundle args=getArguments();
        for (int i=0;i<70; i++)
        {
            Log.d(TAG, "onCreateView: "+ list_ques.get(i));
            Log.d("chu", "onCreateView: "+args.getInt("page_position"));
            if(args.getInt("page_position")==(i+1))
            {
                tv1.setText(list_ID.get(i));
                tv2.setText(list_ques.get(i));
                rb1.setText(list_A.get(i));
                rb2.setText(list_B.get(i));
            }

        }

//            Log.d(TAG, "onCreateView: "+list_ques.get(mNum-1));
//            tv1.setText(list_ques.get(mNum - 1));
//
//            TextView tv2 = (TextView) rootView.findViewById(R.id.tv_qno);
//            tv2.setText(getArguments().getInt(ARG_SECTION_NUMBER));
        return rootView;
    }
}
