package info.pack.selectgoal;


<<<<<<< HEAD
<<<<<<< HEAD

import android.os.Bundle;
import android.app.Fragment;
=======
import android.app.Fragment;
import android.os.Bundle;
>>>>>>> entwicklung
=======
import android.app.Fragment;
import android.os.Bundle;
>>>>>>> origin/entwicklung
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.packone.login.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardioFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class CardioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> entwicklung
=======

>>>>>>> origin/entwicklung
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardioFragment newInstance(String param1, String param2) {
        CardioFragment fragment = new CardioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
<<<<<<< HEAD
<<<<<<< HEAD
        return fragment;
=======

        return fragment;

>>>>>>> entwicklung
=======

        return fragment;

>>>>>>> origin/entwicklung
    }
    public CardioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> entwicklung
=======

>>>>>>> origin/entwicklung
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
<<<<<<< HEAD
<<<<<<< HEAD
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
=======
=======
>>>>>>> origin/entwicklung

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

<<<<<<< HEAD
>>>>>>> entwicklung
=======
>>>>>>> origin/entwicklung
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cardio, container, false);
    }


<<<<<<< HEAD
<<<<<<< HEAD
=======


>>>>>>> entwicklung
=======


>>>>>>> origin/entwicklung
}
