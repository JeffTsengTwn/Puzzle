package tw.jefftzeng.puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView girdView =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        girdView = (GridView)findViewById(R.id.gridView);
        girdView.setAdapter(new ImageAdapter(this));

    }
}
