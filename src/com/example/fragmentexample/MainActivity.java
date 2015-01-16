package com.example.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new HelloWorldFragment(), "HelloWorldFragment")
                    .commit();
        }
        
        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class HelloWorldFragment extends Fragment {

        public HelloWorldFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public static class XinChaoFragment extends Fragment {

        public XinChaoFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.second_fragment_main, container, false);
            return rootView;
        }
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_next:
			Fragment oldFrag = getSupportFragmentManager().findFragmentByTag("HelloWorldFragment");
			
			if(oldFrag == null){
				getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new HelloWorldFragment(), "HelloWorldFragment")
                .commit();
				
				break;
			}
			
			if(oldFrag.isVisible()){
				 getSupportFragmentManager().beginTransaction()
                 .replace(R.id.container, new XinChaoFragment(), "XinChaoFragment")
                 .commit();
			}
			break;

		default:
			break;
		}
	}

}
