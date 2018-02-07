package tw.jefftzeng.puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
public class MainActivity extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        gridView = (GridView)findViewById(R.id.gridView);
        gridView.setNumColumns(3);
        gridView.setHorizontalSpacing(0);
        gridView.setAdapter(new ImageAdapter(this));

    }
}
